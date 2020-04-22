package com.maven.annotation;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }

}