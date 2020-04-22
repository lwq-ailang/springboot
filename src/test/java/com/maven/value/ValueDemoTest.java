package com.maven.value;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 导入 junit 和 spring-text 依赖包
 **/
@RunWith(SpringJUnit4ClassRunner.class) //在Junit环境下提供Spring TextConText FrameWork的功能
@ContextConfiguration(classes = {ElConfig.class}) //加载配置applicationContext，classes是用来加载配置配置类的
public class ValueDemoTest {

    //注入bean
    @Autowired
    private ValueDemo valueDemo;

    @Autowired
    private ElConfig elConfig;

    @Test
    public void outValue(){
        ////扫描配置类(使用全注解实现) 创建IOC容器（bean工厂）
        //AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        //创建注解类的bean对象
        //ElConfig resourceService = context.getBean(ElConfig.class);
        elConfig.outputResource();
        //context.close();

        //通过注解类创建ValueDemo的bean的对象
        System.out.println(valueDemo.getAuthor());
    }

}