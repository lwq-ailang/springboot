package com.maven.proFile;


/**
 * Profile为不同环境下使用不同的配置提供了支持（开发环境和生成环境)
 * 通过设定Environment的ActiveProfiles类设定当前context需要使用的配置。
 * 在开发中使用@Profile注解类或者方法，达到不同情况下选择实例化不同的Bean。
 * 通过设定JVM的spring.profiles.active参数来设计配置环境。
 * Web项目设置在Servlet的context parameter中。
 */
public class ProFileDemo {

    private String content;

    public ProFileDemo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}