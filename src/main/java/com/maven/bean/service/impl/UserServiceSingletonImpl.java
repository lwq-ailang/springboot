package com.maven.bean.service.impl;

import com.maven.bean.dao.UserDao;
import com.maven.bean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service  //声明当前类是spring管理的一个bean
@Scope("singleton")// singleton：bean的单例  prototype：bean的多例
public class UserServiceSingletonImpl implements UserService {


    @Autowired //将UserDao的bean注入到UserService中，让UserService拥有UserDao的功能
    private UserDao userDao;

    @Override
    public String sayHello(String word) {
        return userDao.sayHello(word);
    }

}