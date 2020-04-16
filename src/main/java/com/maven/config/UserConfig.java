package com.maven.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration //声明一个配置类
@ComponentScan("com.maven") //自动扫描包下的所使用的Controller，Service，Repository，Component的类并注册bean
public class UserConfig {

}