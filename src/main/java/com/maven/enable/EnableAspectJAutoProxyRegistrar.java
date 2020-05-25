package com.maven.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 动态注册Bean：
 * AspectJAutoProxyRegistrar实现了ImportBeanDefinitionRegistrar接口，
 * ImportBeanDefinitionRegistrar的作用是在运行时自动添加Bean到已有的配置类，通过重写registerBeanDefinitions方法：
 * 其中importingClassMetadata参数用来获得当前配置类上的注解：BeanDefinitionRegistry参数用来注册Bean。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Import(AspectJAutoProxyRegistrar.class)
public @interface EnableAspectJAutoProxyRegistrar {

}