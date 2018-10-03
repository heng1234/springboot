package com.hlvy.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hlvy.springboot.mapper.UserMapper;
import com.hlvy.springboot.model.User;
import com.hlvy.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * UserSerivceImpl
 *
 * @author heng
 * @version 1.0.0
 **/
@Component//spring的注解
@Service//dubbo的注解
public class UserSerivceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * redis
     */
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 分页查询
     * @param map
     * @return
     */
    @Override
    public List<User> getUserByPage(Map<String, Object> map) {
        return userMapper.getUserByPage(map);
    }

    /**
     * 查询总数量
     * @return
     */
    @Override
    public int getUserTotle() {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        //取redis总数 看看缓存也没有
        Integer userTotle = (Integer) redisTemplate.opsForValue().get("userTotle");
        //如果没有
        if (userTotle == null) {
            userTotle = userMapper.getUserTotle();
            redisTemplate.opsForValue().set("userTotle",userTotle);
        }
        //双重检测 比方法上加synchronized会好点
        if(null == userTotle){
            synchronized (this){
                userTotle = (Integer) redisTemplate.opsForValue().get("userTotle");
                if(null == userTotle){
                    System.out.println("查询了数据库");
                    userTotle = userMapper.getUserTotle();
                    redisTemplate.opsForValue().set("userTotle",userTotle);//存入缓存
                }else{
                    System.out.println("查询了缓存");
                }
            }

        }else{
            System.out.println("查询了缓存");
        }

        return userTotle;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int saveUser(User user) {
    RedisSerializer stringSerializer = new StringRedisSerializer();
     redisTemplate.setKeySerializer(stringSerializer);
    int save = userMapper.insertSelective(user);
    if(save > 0) {
        int userTotle = userMapper.getUserTotle();
        redisTemplate.opsForValue().set("userTotle",userTotle);//存入缓存
    }
        return save;
    }
    /**
     * 修改用户
     * @param user
     * @return
     */
    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
    /**
     * 删除用户
     * @param user
     * @return
     */
    @Override
    public int deleteUser(User user) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        int delete = userMapper.deleteByPrimaryKey(user.getId());
        if(delete > 0) {
            int userTotle = userMapper.getUserTotle();
            redisTemplate.opsForValue().set("userTotle",userTotle);//存入缓存
        }
        return delete;
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public User findUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
