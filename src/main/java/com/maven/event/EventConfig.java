package com.maven.event;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//声明配置类
@Configuration
@ComponentScan("com.maven.event")  //自动扫描包下的所使用的Controller，Service，Repository，Component的类并注册bean
public class EventConfig {

}
