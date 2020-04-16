package com.maven.service.impl;

import com.maven.dao.UserDao;
import com.maven.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //声明当前类是spring管理的一个bean
public class UserServiceImpl implements UserService {

    @Autowired //将UserDao的bean注入到UserService中，让UserService拥有UserDao的功能
    private UserDao userDao;

    public String sayHello(String word) {
        return userDao.sayHello("word");
    }
}