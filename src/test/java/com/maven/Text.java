package com.maven;


import com.maven.proFile.ProFileDemo;
import com.maven.proFile.ProfileConfig;
import com.maven.value.ElConfig;
import com.maven.value.ValueDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 导入 junit 和 spring-text 依赖包
 */
@RunWith(SpringJUnit4ClassRunner.class) //在Junit环境下提供Spring TextConText FrameWork的功能
@ContextConfiguration(classes = {ProfileConfig.class}) //加载配置applicationContext，classes是用来加载配置配置类的
@ActiveProfiles("prod")//声明活动的profile
public class Text {

    //注入bean
    @Autowired
    private ProfileConfig profileConfig;

    @Test
    public void outValue() {
        String expected = "from production profile";
        ProFileDemo proFileDemo = profileConfig.prodDemoBean();
        String actual = proFileDemo.getContent();
        Assert.assertEquals(expected, actual);
    }

}