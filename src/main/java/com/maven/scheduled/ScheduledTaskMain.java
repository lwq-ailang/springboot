package com.maven.scheduled;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.maven.scheduled.dynamicScheduled") //mapper扫描
//@ComponentScan({"com.maven.scheduled.staticScheduled","com.maven.scheduled.dynamicScheduled","com.maven.scheduled.threadScheduled"})
@ComponentScan({"com.maven.scheduled.threadScheduled"})
@EnableScheduling//来开启对计划任务的支持（开启定时任务）
public class ScheduledTaskMain {

    public static void main(String[] args) {
        //扫描使用@Scheduled注解类
        //AnnotationConfigApplicationContext staticContext = new AnnotationConfigApplicationContext(ScheduledTaskConfig.class);

        //扫描基于接口的定时任务类
        SpringApplication.run(ScheduledTaskMain.class, args);
    }

}