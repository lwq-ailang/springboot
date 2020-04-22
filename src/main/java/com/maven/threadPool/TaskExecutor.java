package com.maven.threadPool;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskExecutor {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext taskExecutorConfig = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = taskExecutorConfig.getBean(AsyncTaskService.class);
        for (int i = 1; i <= 5; i++) {
            // 标注@Async注解的方法和调用的方法一定不能在同一个类下，这样的话注解会失效
            try {
                asyncTaskService.executeAsyncTask(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        AnnotationConfigApplicationContext taskExecutorConfigImpl = new AnnotationConfigApplicationContext(TaskExecutorConfigImpl.class);
        AsyncTaskService asyncTaskServiceImpl = taskExecutorConfigImpl.getBean(AsyncTaskService.class);
        for (int i = 6; i <= 10; i++) {
            // 标注@Async注解的方法和调用的方法一定不能在同一个类下，这样的话注解会失效
            asyncTaskService.executeAsyncTaskPlus(i);
        }
    }

}