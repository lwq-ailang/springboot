package com.maven.value;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

//声明配置类
@Configuration
@ComponentScan("com.maven.value")  //自动扫描包下的所使用的Controller，Service，Repository，Component的类并注册bean
public class ElConfig {

    @Value("wu")//(1)注入普通字符串
    private String normal;

    @Value("#{systemProperties['os.name']}") //(2)注入操作系统属性，注意格式
    private String osName;

    @Value("#{T(java.lang.Math).random()*100.0}")//(3)注入表达式结果
    private double randomNumber;

    @Value("#{valueDemo.author}")//(4)注入其他bean的属性
    private String fromAnother;

    @Value("classpath:bean/value.txt")//(5)注入文件资源
    private Resource testFile;

    @Value("http://www.baidu.com")//(6)注入网站资源
    private Resource testUrl;

    @Value("${book.name}")//(7)注入配置文件，注意使用的是$而不是#
    private String bookName;

    /**
     * 关于@Autowired和@Bean
     * @Autowired:可注解在set方法和属性上，用来注入bean，习惯上注解在属性上，它是属于注解配置
     * @Bean：注解在方法上，声明当前方法的返回值为一个Bean，它是属于java配置
     */
    //TODO: 使用Environment读取配置
    @Autowired
    private Environment environment;//注入Properties还可以从Environment中获得

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try{
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));

            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
