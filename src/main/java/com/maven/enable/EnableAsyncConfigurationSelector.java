package com.maven.enable;

import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 2。依据条件选配置类：
 * AsyncConfigurationSelector通过条件来选择需要导入的配置类，
 * AsyncConfigurationSelector的根接口是ImportSelector（父类），需要实现selectImports方法，在该方法中进行了条件判断。
 * 如果adviceMode为PROXY，则返回ProxyAsyncConfiguration这个配置类；
 * 如果为ASPECTJ，则返回AspectJAsyncConfiguration配置类，
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AsyncConfigurationSelector.class)
public @interface EnableAsyncConfigurationSelector {

}