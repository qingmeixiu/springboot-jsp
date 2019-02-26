package com.sinaif.hoover.quartz;

import com.sinaif.hoover.utils.DateUtils;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 
 * @Description : 任务执行类
 * @Copyright   : Sinaif Software Co.,Ltd.Rights Reserved
 * @Company     : 海南新浪爱问普惠科技有限公司
 * @author      : Rainy
 * @version     : 1.0 Create Date : 2017年9月7日 下午5:52:07
 *
 */
@Component
public class QuartzJob implements Job{


	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
//		TaskModel taskDetail = (TaskModel) JsonUtils.json2Object(dataMap.get("taskDetail").toString(), TaskModel.class) ;
		System.out.println("-----------------"+ JSONObject.valueToString(dataMap));
		String taskId = dataMap.getString("taskId").toString();
		System.out.println("--------taskId-----------"+ DateUtils.dateToString(new Date()));
	}
}
 
