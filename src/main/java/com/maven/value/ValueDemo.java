package com.maven.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
/**
 *  @ConfigurationProperties 表示 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *  @ConfigurationProperties (prefix = "user") 默认从全局配置文件中获取值然后进行注入
 *  prefix = "user" 表示 将配置文件中key为user的下面所有的属性与本类属性进行一一映射注入值，
 *  如果配置文件中不存在"user"的key，则不会为POJO注入值，属性值仍然为默认值
 *
 * PropertySource：加载指定的配置文件
 * 若使用@Value注入，则要配置一个PropertySourcesPlaceholderConfigurer的Bean，
 *      @Value("${book.name}")使用的是"$"而不是"#"
 */
@ConfigurationProperties(prefix = "boot",
        ignoreUnknownFields=true,//忽略未知的字段
        ignoreInvalidFields=true) //是否忽略验证失败的字段
//classpath:其实就是打包之后的classes下
@PropertySource(value= {"classpath:bean/Value.properties"}, //需要加载的属性文件(多个)
        ignoreResourceNotFound=false, //指定的配置文件不存在是否报错,默认是false(不存在就报错)
        encoding="UTF-8", //读取属性文件所使用的编码
        name="Value.properties")
public class ValueDemo {

    /**
     * @Value的值有两类：
     * ① ${ property : default_value }: 注入的是外部配置文件对应的property
     * ② #{ obj.property? :default_value }: SpEL表达式对应的内容。 那个default_value，就是前面的值为空时的默认值。
     * 注意二者的不同，#{}里面那个obj代表对象。
     */
    @Value("${book.author}")
    //@Value("${book.autor:wu}") //若在配置文件中没有设置值时，则指定这个为默认值
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}