package com.maven.enable;

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;
import org.springframework.scheduling.annotation.SchedulingConfiguration;

/**
 * @EnableAspectJAutoProxy：开启对AspectJ自动代理的支持。
 * @EnableAsync：开启异步方法支持。
 * @EnableScheduling：开启计划任务
 * @EnableWebMvc：开启Web Mvc配置功能
 * @Import：用来导入一个或多个class，这些类会注入到spring容器中，或者配置类，配置类里面定义的bean都会被spring容器托管。 通过观察这些@Enable*注解的源码，会发现所有的注解都有一个@Import注解，
 * 该注解是用来导入配置类的，这也意味着这些开启的实现是导入了一些自动配置的Bean。
 * 1 直接导入配置类：直接在类上加  @Import(SchedulingConfiguration.class)
 * 2 依据条件选配置类：
 * AsyncConfigurationSelector通过条件来选择需要导入的配置类，
 * AsyncConfigurationSelector的根接口是ImportSelector（父类），
 * 需要实现selectImports方法，在该方法中进行了条件判断。
 * 如果adviceMode为PROXY，则返回ProxyAsyncConfiguration这个配置类；
 * 如果为ASPECTJ，则返回AspectJAsyncConfiguration配置类，
 * 3 动态注册Bean：
 * AspectJAutoProxyRegistrar实现了ImportBeanDefinitionRegistrar接口，
 * ImportBeanDefinitionRegistrar的作用是在运行时自动添加Bean到已有的配置类，通过重写registerBeanDefinitions方法：
 * 其中importingClassMetadata参数用来获得当前配置类上的注解：BeanDefinitionRegistry参数用来注册Bean。
 */
//@Import(SchedulingConfiguration.class)
//@Import(AsyncConfigurationSelector.class)
//@Import(AspectJAutoProxyRegistrar.class)
public class Enable {

}