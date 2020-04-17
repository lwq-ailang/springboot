package com.maven.bean;

import com.maven.bean.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanByXMLTest {

    @Test
    public void say() {
        //1.创建IOC容器（bean工厂） 类路径方式加载
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextBean.xml");
        //2.从IOC容器获取对象
        User user = (User)ac.getBean("user3");
        //3.输出
        System.out.println(user);
    }


}