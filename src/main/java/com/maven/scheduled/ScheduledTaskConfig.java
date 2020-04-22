package com.maven.scheduled;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration //声明配置类
@ComponentScan("com.maven.scheduled")
@EnableScheduling//来开启对计划任务的支持
public class ScheduledTaskConfig {

}