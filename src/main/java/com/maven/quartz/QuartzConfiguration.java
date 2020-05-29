package com.maven.quartz;

import org.quartz.CronTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * Quartz环境初始化：创建Trigger以及JobDetail对象，并用Schedule配置定时任务：
 */
@Configuration
public class QuartzConfiguration {

    /**
     * 1.创建Job对象。在Spring环境中，创建一个类型的对象的时候，很多情况下，都是通过FactoryBean来间接创建的。
     * 如果有多个Job对象，定义多次方法。
     * 2.在JobDetailFactoryBean类型中，用于创建JobDetail对象的方法，其底层使用的逻辑是：Class.newInstance()
     * 也就是说，JobDetail对象不是通过Spring容器管理的。
     * 3.因为Spring容器不管理JobDetail对象，那么Job中需要自动装配的属性，就无法实现自动状态。如上JOB的第10行会报空指针异常。
     * 解决方案是：
     * 将JobDetail加入到Spring容器中，让Spring容器管理JobDetail对象。
     * 需要重写Factory相关代码。实现Spring容器管理JobDetail。
     */
    @Bean
    public JobDetailFactoryBean initJobDetailFactoryBean() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        // 提供job类型。
        factoryBean.setJobClass(SpringBootQuartzJobDemo.class);
        return factoryBean;
    }

    /**
     * 管理Trigger对象
     * CronTrigger - 就是Trigger的一个实现类型。 其中用于定义周期时间的是CronSchedulerBuilder
     * 实际上，CronTrigger是用于管理一个Cron表达式的类型。
     *
     * @param jobDetailFactoryBean - 上一个方法初始化的JobDetailFactoryBean
     */
    @Bean(name = "cronTriggerFactoryBean1")
    public CronTriggerFactoryBean initCronTriggerFactoryBean() {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        JobDetailFactoryBean jobDetailFactoryBean = this.initJobDetailFactoryBean();
        factoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        factoryBean.setCronExpression("0/1 * * * * ?");
        return factoryBean;
    }

    /**
     * 初始化Scheduler
     *
     * @param cronTriggerFactoryBean - 上一个方法初始化的CronTriggerFactoryBean
     */
    @Bean
    public SchedulerFactoryBean initSchedulerFactoryBean(CustomJobFactory customJobFactory, CronTriggerFactoryBean[] cronTriggerFactoryBean) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        CronTrigger[] triggers = new CronTrigger[cronTriggerFactoryBean.length];
        for (int i = 0; i < cronTriggerFactoryBean.length; i++) {
            triggers[i] = cronTriggerFactoryBean[i].getObject();
        }
        // 注册触发器，一个Scheduler可以注册若干触发器。
        factoryBean.setTriggers(triggers);
        // 为Scheduler设置JobDetail的工厂。可以覆盖掉SpringBoot提供的默认工厂，保证JobDetail中的自动装配有效。
        factoryBean.setJobFactory(customJobFactory);
        return factoryBean;
    }

}