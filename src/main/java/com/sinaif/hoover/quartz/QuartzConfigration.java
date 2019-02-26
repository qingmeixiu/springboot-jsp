package com.sinaif.hoover.quartz;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;



/**
 * 
 * @Description : 
 * @Copyright   : Sinaif Software Co.,Ltd.Rights Reserved
 * @Company     : 海南新浪爱问普惠科技有限公司
 * @author      : Rainy
 * @version     : 1.0 Create Date : 2017年9月12日 上午10:01:56
 *
 */
@Configuration
public class QuartzConfigration {
	
	 @Autowired  
     private JobFactory jobFactory;  //自定义的factory 
	 
	/**
	 * 获取工厂bean   
	 * @return
	 */
    @Bean  
    public SchedulerFactoryBean schedulerFactoryBean() {  
      SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();  
      try {  
        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        schedulerFactoryBean.setJobFactory(jobFactory);  
    } catch (IOException e) {  
        // TODO Auto-generated catch block  
        e.printStackTrace();  
    }  
      return schedulerFactoryBean;  
    } 
    
    /**
     * 指定quartz.properties  
     * @return
     * @throws IOException
     */
    @Bean  
    public Properties quartzProperties() throws IOException {  
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();  
//        propertiesFactoryBean.setLocation(new ClassPathResource("config/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();  
        return propertiesFactoryBean.getObject();  
    }
    
    /**
     * 创建schedule    
     * @return
     */
    @Bean(name = "scheduler")  
    public Scheduler scheduler() {
      return schedulerFactoryBean().getScheduler();
    } 
}
 
