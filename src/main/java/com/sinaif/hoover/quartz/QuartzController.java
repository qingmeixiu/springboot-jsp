package com.sinaif.hoover.quartz;

        import javax.websocket.server.PathParam;

import org.junit.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.redis.core.RedisTemplate;
        import org.springframework.data.redis.core.ValueOperations;
        import org.springframework.scheduling.annotation.Scheduled;
        import org.springframework.stereotype.Component;
        import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuartzController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private QuartzManager quartzManager;

    @RequestMapping({"/quartz/add"})
    @ResponseBody
    public void redisTest2() {
        ValueOperations valOpt = redisTemplate.opsForValue();
        System.out.println("redis demo success"+(String) valOpt.get("number"));

        quartzManager.addJob(  "First","Q1001","0/5 * * * * ?");
    }
    
    @RequestMapping({"/quartz/remove/{taskId}"})
    @ResponseBody
    public void removeJob(@PathVariable("taskId") String taskId) {
    	System.out.println("remove job success-->  taskid:"+taskId);
    	quartzManager.removeJob( taskId );
    }

}
