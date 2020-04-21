package com.maven.aware;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//声明配置类
@Configuration
@ComponentScan("com.maven.aware")  //自动扫描包下的所使用的Controller，Service，Repository，Component的类并注册bean
public class AwareConfig {

}
