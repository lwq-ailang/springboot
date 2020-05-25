package com.maven.mybatis.controller;

import com.maven.mybatis.entity.User;
import com.maven.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String getUser(@PathVariable Integer id) {
        return userService.getUser(id).toString();
    }

    @RequestMapping("/findAll")
    public List<User> findAll(User user, int row, int pageSize) {
        return userService.getUserList(user, row, pageSize);
    }
}
