package com.hlvy.springboot.service;

import com.hlvy.springboot.model.User;

import java.util.List;
import java.util.Map;

/**
 * UserService
 *
 * @author heng
 * @version 1.0.0
 **/
public interface UserService {

    /**
     * 分页
     * @param map
     * @return
     */
    List<User> getUserByPage(Map<String,Object> map);

    /**
     * 查询总数量
     * @return
     */
    int getUserTotle();
    /**
     * 添加用户
     * @return
     */
    int saveUser(User user);
    /**
     * 修改用户
     * @return
     */
    int updateUser(User user);
    /**
     * 删除用户
     * @return
     */
    int deleteUser(User user);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findUser(Integer id);
}
