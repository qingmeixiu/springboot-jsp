package com.sinaif.hoover.quartz;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FirstAutoJob {

//    @Scheduled(cron = "0/5 * * * * *")
    public void prepareStart() {

        System.out.println("----------prepareStart-----------1");



    }
//    @Scheduled(cron = "0/5 * * * * *")
    public void prepareStart2() {

        System.out.println("----------prepareStart-----------2");


    }

}
