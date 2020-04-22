package com.maven.scheduled;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduledTask {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduledTaskConfig.class);
    }

}