package com.sinaif.hoover.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *  1.多个定时任务 按照顺序执行  前面阻塞会阻塞后面的定时任务执行
 *  2.定时任务 未执行完 会阻塞 直到执行完成
 */
@Component
public class SecondAutoJob {
    Logger logger = LoggerFactory.getLogger(SecondAutoJob.class);

    int count = 0;
    boolean flag= false;

    @Scheduled(cron = "0/5 * * * * *")
    public void prepareStart() {
        logger.info("----------SecondAutoJob-----------进入"+flag);
        if(flag){
            logger.info("----------SecondAutoJob-----------return:"+flag);
            return;
        }
        flag = true;
        try {
            new Thread().sleep(8000);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("----------SecondAutoJob-----------count:"+count);
        flag = false;

    }

//    @Scheduled(cron = "0/1 * * * * *")
    public void prepareStart2() {

        logger.info("----------prepareStart2-----------2");


    }


}
