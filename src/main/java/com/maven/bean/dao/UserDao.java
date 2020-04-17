package com.maven.bean.dao;

import org.springframework.stereotype.Repository;

@Repository //声明当前类是spring管理的一个bean
public class UserDao {

    public String sayHello(String word) {
        return "hello "+ word + "!";
    }

}