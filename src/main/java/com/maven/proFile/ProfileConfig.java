package com.maven.proFile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev") // 1.profile为dev时示例化devDemoBean
    public ProFileDemo devDemoBean() {
        return new ProFileDemo("from development profile");
    }

    @Bean
    @Profile("prod") // 2.profile为prod时实例化为prodDemoBean
    public ProFileDemo prodDemoBean() {
        return new ProFileDemo("from production profile");
    }

}