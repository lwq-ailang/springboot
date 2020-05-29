package com.maven.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableScheduling 必要
 * 开启定时任务机制。
 */
@SpringBootApplication
@EnableScheduling //必填
public class QuartzSpringbootlicationMain {

    public static void main(String[] args) {
        SpringApplication.run(QuartzSpringbootlicationMain.class, args);
    }

}