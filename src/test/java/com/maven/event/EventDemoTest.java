package com.maven.event;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventDemoTest {

    @Test
    public void Event() {
        //扫描配置类(使用全注解实现) 创建IOC容器（bean工厂）
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        //从IOC容器获取对象
        PublisherDemo publisherDemo = context.getBean(PublisherDemo.class);
        //publisher-->使用ApplicationContext的publishEvent方法来发布-->
        publisherDemo.publish("ApplicationEvent");
        context.close();
    }
}