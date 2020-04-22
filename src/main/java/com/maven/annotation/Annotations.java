package com.maven.annotation;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

@Target(ElementType.TYPE) //jdk5注解，表示作用目标类型，是类、方法还是变量等
@Retention(RetentionPolicy.RUNTIME) //jdk注解，表示该注解会保存多久，生命周期相关
@Documented //jdk注解，表示是否被javadoc命令导出文档
//@Configuration跟@ComponentScan注解组合为一个新注解-
@Configuration //组合@Configuration元注解
@ComponentScan //组合@ComponentScan元注解
public @interface Annotations {// @interface 自定义注解类

    String[] value() default {}; // 覆盖@ComponentScan value参数

}