package com.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class SpringbootLogbackApplication {

    private final static Logger logger = LoggerFactory.getLogger(SpringbootLogbackApplication.class);

    public static void main(String[] args) {
        System.out.println("开始");
        new Thread(()->{
            for (int i=0;i<100;i++){
                logger.info("---test---"+i);
            }
        }).start();
        SpringApplication.run(SpringbootLogbackApplication.class, args);
        System.out.println("结束");
    }
}