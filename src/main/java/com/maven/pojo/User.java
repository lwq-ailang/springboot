package com.maven.pojo;

/**
 * @author: ly-wflei
 * @date: 2020/3/31
 * @version: 1.0
 */
public class User {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                '}';
    }

}