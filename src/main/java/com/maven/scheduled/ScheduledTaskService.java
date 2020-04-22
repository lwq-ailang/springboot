package com.maven.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Spring通过@Scheduled支持多种类型计划任务，包含cron,fixDelay,fixRate.
 *
 * @Scheduled声明该方法是计划任务
 */
@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //使用fixedRate属性固定时间执行

    /**
     * fixedDelay:上一次执行完毕时间点之后多长时间再执行。如：
     *
     * @Scheduled(fixedDelay = 5000) //上一次执行完毕时间点之后5秒再执行
     * <p>
     * fixedDelayString 与 fixedDelay 意思相同，只是使用字符串的形式。唯一不同的是支持占位符。如：
     * @Scheduled(fixedDelayString = "5000") //上一次执行完毕时间点之后5秒再执行
     * 占位符的使用(配置文件中有配置：time.fixedDelay=5000)：
     * @Scheduled(fixedDelayString = "${time.fixedDelay}")
     * void testFixedDelayString() {
     * System.out.println("Execute at " + System.currentTimeMillis());
     * }
     * <p>
     * fixedRate：上一次开始执行时间点之后多长时间再执行。如：
     * @Scheduled(fixedRate = 5000) //上一次开始执行时间点之后5秒再执行
     * <p>
     * fixedRateString 与 fixedRate 意思相同，只是使用字符串的形式。唯一不同的是支持占位符。
     * <p>
     * initialDelay:第一次延迟多长时间后再执行。如：
     * @Scheduled(initialDelay=1000, fixedRate=5000) //第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * <p>
     * initialDelayString 与 initialDelay 意思相同，只是使用字符串的形式。唯一不同的是支持占位符。
     */
    @Scheduled(fixedRate = 2000) //1.声明该方法是定时任务，每个2秒执行一次
    public void reportCurrentDate() {
        System.out.println("每隔2秒执行一次 " + dateFormat.format(new Date()));
    }

    // cron 表达式：[秒] [分] [小时] [日] [月] [周] [年]
    // 注：[年]不是必须的域，可以省略[年]，则一共6个域
    @Scheduled(cron = "0 34 11 ? * *") //2.每天11点28分执行
    public void fixTimeExecution() {
        System.out.println("在指定时间 " + dateFormat.format(new Date()) + "执行");
    }

}