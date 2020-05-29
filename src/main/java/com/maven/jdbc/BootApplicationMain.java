package com.maven.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.maven.jdbc.dao")
public class BootApplicationMain {

    public static void main(String[] args) {
        SpringApplication.run(BootApplicationMain.class, args);
    }
}