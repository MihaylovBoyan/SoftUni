package com.example.schedules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CronSchedulerDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(CronSchedulerDemo.class);

    @Scheduled(cron = "${schedulers.cron}")
    public void showTimeWithCron() {
        LOGGER.info("Hello, from scheduler at {}", LocalDateTime.now());
    }

//    @Scheduled(cron = "*/10 * * * * *")
//    public void showTimeWithCron(){
//        LOGGER.info("Hello, from scheduler at {}", LocalDateTime.now());
//    }

    @Scheduled(fixedRate = 5000)
    public void showTimeWithFixedRate() {
        LOGGER.info("hi, {}", LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 10000)
    public void fixedDelay(){
        LOGGER.info("fixed delay {} ", LocalDateTime.now());
    }

}
