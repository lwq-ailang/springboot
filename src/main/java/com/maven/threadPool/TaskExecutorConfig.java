package com.maven.threadPool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Spring通州任务执行器(TaskExecutor)来实现多线程和并发编程，使用ThreadPoolTaskExecutor
 * 可实现一个基于线程的TaskExecutor，而实际开发中任务一般是非阻塞的，即异步的，
 * 所以我们要在配置类中通过@EnableAsync开启对异步任务的支持，并通过在实际执行的Bean的方法中使用@Async注解来声明其是一个异步任务。
 */
@Configuration //声明一个配置类
@ComponentScan("com.maven.threadPool")
@EnableAsync //1.开启对异步任务的支持
public class TaskExecutorConfig {

//    @Autowired
//    private ThreadPoolTaskExecutor taskExecutor;

    @Bean("taskExecutor") //2.创建bean对象
    //3.创建方法，并返回一个ThreadPoolTaskExecutor
    public Executor taskExector() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        System.out.println("TaskExecutorConfig");
        Executor executorService = Executors.newCachedThreadPool();//获取到服务器的cpu内核
        taskExecutor.setCorePoolSize(5);//核心池大小
        taskExecutor.setMaxPoolSize(100);//最大线程数
        taskExecutor.setQueueCapacity(1000);//队列程度
        taskExecutor.setKeepAliveSeconds(60);//线程空闲时间
        taskExecutor.setThreadNamePrefix("tsak-asyn");//线程前缀名称
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//配置拒绝策略
        return taskExecutor;
    }

}

