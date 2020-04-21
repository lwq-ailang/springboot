package com.maven.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//事件发布类
@Component
public class PublisherDemo {

    //注入ApplicationContext用来发布事件
    @Autowired
    ApplicationContext applicationContext;

    //使用ApplicationContext的publishEvent方法来发布
    public void publish(String msg) {
        //先实例化EventDemo，this是调用带方法的PublisherDemo对象
        applicationContext.publishEvent(new EventDemo(this, msg));
    }

}