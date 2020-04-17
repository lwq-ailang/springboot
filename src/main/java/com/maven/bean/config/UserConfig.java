package com.maven.bean.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类:使用全注解形式
 */
@Configuration //声明一个配置类
@ComponentScan("com.maven.bean") //自动扫描包下的所使用的Controller，Service，Repository，Component的类并注册bean
public class UserConfig {

}