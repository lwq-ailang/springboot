package com.maven.value;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ValueDemoTest {

    @Test
    public void outValue(){
        ////扫描配置类(使用全注解实现) 创建IOC容器（bean工厂）
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        //创建注解类的bean对象
        ElConfig resourceService = context.getBean(ElConfig.class);
        resourceService.outputResource();
        context.close();

        //通过注解类创建ValueDemo的bean的对象
        //ValueDemo valueDemo = context.getBean(ValueDemo.class);
        //System.out.println(valueDemo.getAuthor());
    }

}