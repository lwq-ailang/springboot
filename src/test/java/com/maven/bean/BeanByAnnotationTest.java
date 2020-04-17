package com.maven.bean;

import com.maven.bean.config.UserConfig;
import com.maven.bean.service.impl.UserServicePrototypeImpl;
import com.maven.bean.service.impl.UserServiceSingletonImpl;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanByAnnotationTest {

    @Test
    public void singleton(){
        //扫描配置类(使用全注解实现) 创建IOC容器（bean工厂）
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        //从IOC容器获取对象
        UserServiceSingletonImpl s1 = context.getBean(UserServiceSingletonImpl.class);
        UserServiceSingletonImpl s2 = context.getBean(UserServiceSingletonImpl.class);
        System.out.println("s1是否等于s2: "+s1.equals(s2));
    }

    @Test
    public void prototype(){
        //扫描配置类(使用全注解实现) 创建IOC容器（bean工厂）
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
        //从IOC容器获取对象
        UserServicePrototypeImpl p1 = context.getBean(UserServicePrototypeImpl.class);
        UserServicePrototypeImpl p2 = context.getBean(UserServicePrototypeImpl.class);
        System.out.println("p1是否等于p2: "+p1.equals(p2));
    }


}