package com.maven.threadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@Service
public class AsyncTaskService {

//    @Resource(name = "taskExecutor")
//    private Executor executor;

    // 1.注解的方法必须是public方法
    // 2.如果注解在方法级别，则表明该方法是个异步方法。
    //   如果注解在类级别，则表明该类所以的方法都是异步的，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor。
    // 3.当在一个方法上标注了@Async注解之后，在被调用的时候主线程会主动使用多线程来调用此方法
    // 4.异步方法使用注解@Async的返回值只能为void或者Future
    //@Async //4.调用
    @Async("taskExecutor")//4.调用(表示使用此线程池。)
    public void executeAsyncTask(Integer i) {
        System.out.println("开始做任务" + i + ",线成名为::" + Thread.currentThread().getName());
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("完成任务" + i + "，耗时：" + (end - start) + "毫秒");
    }

    @Async("taskExecutor")//4.调用(表示使用此线程池。)
    public Future<String> executeAsyncFuture(Integer i) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("第00" + i + "完成任务，耗时：" + (end - start) + "毫秒，线成名为::" + Thread.currentThread().getName());
        return new AsyncResult("SUCUESS");
    }

    @Async //4.调用
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任二：" + (i + 1) + ",线成名为::" + Thread.currentThread().getName());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}