package com.maven.proFile;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ProFileDemoTest {

    @Test
    public void proFile() {
        //扫描配置类(使用全注解实现) 创建IOC容器（bean工厂）
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //先将活动的Profile设置为prod
        context.getEnvironment().setActiveProfiles("prod");
        //后置注册Bean配置类，不然会报Bean未定义的错误
        context.register(ProfileConfig.class);
        //刷新容器
        context.refresh();

        ProFileDemo demoBean = context.getBean(ProFileDemo.class);
        System.out.println(demoBean.getContent());

        context.close();
    }

}