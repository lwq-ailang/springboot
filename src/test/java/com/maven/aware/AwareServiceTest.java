package com.maven.aware;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareServiceTest {

    @Test
    public void aware() {
        //扫描配置类(使用全注解实现) 创建IOC容器（bean工厂）
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        //从IOC容器获取对象
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();
    }
}