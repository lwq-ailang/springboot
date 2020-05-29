package com.maven.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 定义JOB任务以及JOB任务调用的模拟业务对象：
 * Job - 定时任务内容是什么。
 * Trigger - 在什么时间上执行job。
 * Scheduler - 维护定时任务环境，并让触发器生效。
 * 在开发Quartz相关应用时，只要定义了Job（任务），Trigger（触发器）和Scheduler（调度器），即可实现一个定时调度能力。
 * 其中Scheduler是Quartz中的核心，Scheduler负责管理Quartz应用运行时环境，Scheduler不是靠自己完成所有的工作，
 * 是根据Trigger的触发标准，调用Job中的任务执行逻辑，来完成完整的定时任务调度。
 */
public class SpringBootQuartzJobDemo implements Job {

    // 用于模拟任务中的业务对象。 也可能是数据访问对象，或其他类型的对象。
    @Autowired
    private CommonsUtil4Quartz commonsUtil4Quartz;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时任务QuartzJob : " + new Date());
        this.commonsUtil4Quartz.testMethod();
    }

}