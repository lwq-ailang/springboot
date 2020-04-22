package com.maven.threadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

@Service
public class AsyncTaskService {

//    @Resource(name = "taskExecutor")
//    private Executor executor;

    // 如果注解在方法级别，则表明该方法是个异步方法。
    // 如果注解在类级别，则表明该类所以的方法都是异步的，而这里的方法自动被注入使用ThreadPoolTaskExecutor作为TaskExecutor。
    // 当在一个方法上标注了@Async注解之后，在被调用的时候主线程会主动使用多线程来调用此方法
    //@Async //4.调用
    @Async("taskExecutor")//4.调用
    public void executeAsyncTask(Integer i) throws Exception {
        System.out.println("开始做任务" + i);
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("完成任务" + i + "，耗时：" + (end - start) + "毫秒");
    }

    @Async //4.调用
    public void executeAsyncTaskPlus(Integer i) {
        System.out.println("执行异步任二：" + (i + 1));
    }

}