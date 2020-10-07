package com.timer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 定时器 - 注解  -静态：基于注解
 * https://www.cnblogs.com/mmzs/p/10161936.html
 * @Author zouyuxiao
 * @Date 2020-10-07 11:44
 */

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    //3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    // @Scheduled(fixedRate=10000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }

    // fixedDelay方式
    private final Logger log = LoggerFactory.getLogger(SaticScheduleTask.class);

    private List<Integer> index = Arrays.asList(8 * 1000, 3 * 1000, 6 * 1000, 2 * 1000, 2 * 1000);

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Scheduled(fixedDelay = 3 * 1000)
    public void fixedDelay() throws Exception {
        int i = atomicInteger.get();
        if (i < 5) {
            Integer sleepTime = index.get(i);
            log.info("第{}个任务开始执行,执行时间为{}ms", i, sleepTime);
            Thread.sleep(sleepTime);
            atomicInteger.getAndIncrement();
        }
    }

    @PostConstruct
    @Scheduled(fixedRate = 2000) //等价(fixedRateString="2000")字符串形式
    public void testTask() throws InterruptedException {
        Thread.sleep(4000L);
        System.out.println("fixedRate--当前时间"+new Date());
    }

    @Scheduled(fixedDelay = 2000) //与 fixedDelayString=“2000”等价（字符串形式）
    public void testTask2() throws InterruptedException {
        Thread.sleep(4000L);
        System.out.println("fixedDelay---当前时间"+new Date());
    }
}
