package com.maven.jdbc.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 方式二：与JPA集成
 * 引入Starter:
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-starter-data-jpa</artifactId>
 * </dependency>
 */
@Entity(name = "t_author") //指定表名 （如果不指定，默认的表名为 user）
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String realName;
    private String nickName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realName='" + realName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}