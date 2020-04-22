package com.maven.threadPool;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Spring通州任务执行器(TaskExecutor)来实现多线程和并发编程，使用ThreadPoolTaskExecutor
 * 可实现一个基于线程的TaskExecutor，而实际开发中任务一般是非阻塞的，即异步的，所以我们要在配置类中
 * 通过@EnableAsync开启对异步任务的支持，并通过在实际执行的Bean的方法中使用@Async注解来声明其是一个异步任务。
 */
@Configuration //声明一个配置类
@ComponentScan("com.maven.threadPool")
@EnableAsync //1.开启对异步任务的支持
/**
 * 2.配置类实现AsyncConfigurer接口.
 */
public class TaskExecutorConfigImpl implements AsyncConfigurer {

    /**
     * 3.重写getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor，这样我们就获得了已个基于线程池TaskExecutor.
     */
    @Override
    public Executor getAsyncExecutor() {
        System.out.println("TaskExecutorConfigImpl");
        //通过Runtime方法来获取当前服务器cpu内核，根据cpu内核来创建核心线程数和最大线程数
        int threadCount = Runtime.getRuntime().availableProcessors();
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(threadCount);//核心池大小
        taskExecutor.setMaxPoolSize(threadCount);//最大线程数
        taskExecutor.setQueueCapacity(25);//队列程度
        taskExecutor.setKeepAliveSeconds(60);//线程空闲时间
        taskExecutor.setThreadNamePrefix("taskExecutor-");//线程前缀名称
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//配置拒绝策略
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}