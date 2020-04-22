package com.maven.threadPool;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Future;

public class TaskExecutor {

    /**
     * 标注@Async注解的方法和调用的方法一定不能在同一个类下，这样的话注解会失效
     * 因为@Transactional和@Async注解的实现都是基于Spring的AOP，而AOP的实现是基于动态代理模式实现的。
     * 那么注解失效的原因就很明显了，有可能因为调用方法的是对象本身而不是代理对象，因为没有经过Spring容器。
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext taskExecutorConfig = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = taskExecutorConfig.getBean(AsyncTaskService.class);
        for (int i = 1; i <= 5; i++) {
            asyncTaskService.executeAsyncTask(i);
            Future<String> stringFuture = asyncTaskService.executeAsyncFuture(i);
            System.out.println(stringFuture);
        }

        AnnotationConfigApplicationContext taskExecutorConfigImpl = new AnnotationConfigApplicationContext(TaskExecutorConfigImpl.class);
        AsyncTaskService asyncTaskServiceImpl = taskExecutorConfigImpl.getBean(AsyncTaskService.class);
        for (int i = 6; i <= 10; i++) {
            asyncTaskServiceImpl.executeAsyncTaskPlus(i);
        }

        System.out.println("主线程继续执行222222222222222:::::" + Thread.currentThread().getName());
    }

}