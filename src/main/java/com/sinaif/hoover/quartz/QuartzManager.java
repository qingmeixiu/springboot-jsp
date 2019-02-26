package com.sinaif.hoover.quartz;

import com.sinaif.hoover.utils.DateUtils;
import org.quartz.*;
import org.quartz.DateBuilder.IntervalUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;



/**
 * 
 * @Description : 定时任务管理类 
 * @Copyright   : Sinaif Software Co.,Ltd.Rights Reserved
 * @Company     : 海南新浪爱问普惠科技有限公司
 * @author      : Rainy
 * @version     : 1.0 Create Date : 2017年9月7日 下午5:42:39
 *
 */
@Component("quartzManager")
public class QuartzManager {
	
	private Logger log = LoggerFactory.getLogger(QuartzManager.class);
	
	private static String JOB_NAME = "REPORT_";  //任务组名
    private static String JOB_GROUP_NAME = "REPORT_JOBGROUP_NAME";  //任务组名
    private static String TRIGGER_GROUP_NAME = "REPORT_TRIGGERGROUP_NAME";  //触发器组名
    
    @Autowired  
    private Scheduler scheduler; 
    
    /** 
     * 
     * @Description: 添加一个定时任务
     * @param : taskDetail 任务详细信息
     * @date  :	2017-9-8 下午03:47:44 
     * @version V1.0 
     */  
    public boolean addJob(String name,String taskid,String frequency) {
		try {


			// 获取当前时间的下一分钟
			Date runTime = evenMinuteDate(new Date());

			// 2、创建一个JobDetail实例，指定Quartz
			JobDetail job = newJob(QuartzJob.class).withIdentity(JOB_NAME + name, JOB_GROUP_NAME).build();
			//向Job执行类动态传递任务详细信息，避免execute方法中重复查询
//		        job.getJobDataMap().put("taskDetail", JsonUtils.obj2Json(taskDetail));
			job.getJobDataMap().put("taskId", taskid);

			// 3、定义触发器 增加：withMisfireHandlingInstructionDoNothing()方法 不触发立即执行 等待下次Cron触发频率到达时刻开始按照Cron频率依次执行
			Trigger trigger = newTrigger().withIdentity(JOB_NAME + taskid, TRIGGER_GROUP_NAME)
					.withSchedule(CronScheduleBuilder.cronSchedule(frequency).withMisfireHandlingInstructionDoNothing()).build();

			// 4、将job注册到调度器
			scheduler.scheduleJob(job, trigger);

			log.info(job.getKey() + " 开始执行时间: " + DateUtils.formatDate(runTime, "yyyy-mm-dd HH:mm:ss"));
			// 5、启动调度器
			log.info("isShutDown=======" + scheduler.isShutdown());
			if (scheduler.isShutdown()) {
				scheduler.start();
			}
			return true;
		} catch (SchedulerException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
     * 
     * @Description: 移除一个任务
     * @param : jobName 任务名称
     * @date 2017-9-8 下午03:47:44 
     * @version V1.0 
     */  
    public boolean removeJob(String taskId) {  
    	try {  
            TriggerKey triggerKey = TriggerKey.triggerKey(JOB_NAME + taskId, TRIGGER_GROUP_NAME);
            scheduler.pauseTrigger(triggerKey);// 停止触发器  
            scheduler.unscheduleJob(triggerKey);// 移除触发器  
            scheduler.deleteJob(JobKey.jobKey(JOB_NAME + taskId, JOB_GROUP_NAME));// 删除任务  
            return true;
        } catch (Exception e) {  
            e.printStackTrace();
            return false;
        }  
    }

    /**
     * 增加一个job
     * @param jobClass 任务实现类
     * @param jobName 任务名称
     *  @param jobGroupName 任务组名
     * @param jobTime 时间表达式 （如：0/5 * * * * ? ）
     */
    public  void addJob(Class<? extends Job> jobClass, String jobName,String jobGroupName,String jobTime) {
        try {
            //创建jobDetail实例，绑定Job实现类  
            //指明job的名称，所在组的名称，以及绑定job类
            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                            .withIdentity(jobName, jobGroupName)//任务名称和组构成任务key
                            .build();
            //定义调度触发规则  
            //使用cornTrigger规则 
            Trigger trigger = TriggerBuilder.newTrigger()
                        .withIdentity(jobName, jobGroupName)//触发器key
                        .startAt(DateBuilder.futureDate(1, IntervalUnit.SECOND))
                        .withSchedule(CronScheduleBuilder.cronSchedule(jobTime))
                        .startNow().build();
            //把作业和触发器注册到任务调度中
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()) {
            	scheduler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
 
