package com.maven.mybatis.service;


import com.maven.mybatis.entity.User;
import com.maven.mybatis.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userDao;

    public int insertUser(User user) {
        return 0;
    }

    public int deleteUser(User user) {
        return 0;
    }

    public int updateUser(User user) {
        return 0;
    }

    public User getUser(Integer userId) {
        return userDao.getUser(userId);
    }

    public List<User> getUserList(@Param("userCondition") User userCondition,
                                  @Param("roeIndex") int row,
                                  @Param("pageSize") int pageSize) {
        return null;
    }

    public int getUserCount(@Param("userCondition") User userCondition) {
        return 0;
    }

}