package com.maven.scheduled.staticScheduled;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration //声明配置类，兼备Component的效果。
@ComponentScan("com.maven.scheduled.staticScheduled")
@EnableScheduling//来开启对计划任务的支持（开启定时任务）
public class ScheduledTaskConfig {

}