package com.hlvy.springboot.mapper;


import com.hlvy.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 分页查询
     * @param map
     * @return
     */
    List<User> getUserByPage(Map<String, Object> map);
    /**
     * 查询总数量
     * @param
     * @return
     */
    int getUserTotle();
}