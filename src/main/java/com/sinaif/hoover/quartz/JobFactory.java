package com.sinaif.hoover.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * @Description : Job工厂类，解决Job类不能依赖spring注入bean的问题
 * @Copyright   : Sinaif Software Co.,Ltd.Rights Reserved
 * @Company     : 海南新浪爱问普惠科技有限公司
 * @author      : Rainy
 * @version     : 1.0 Create Date : 2017年9月11日 下午8:53:05
 *
 */
@Component
public class JobFactory extends AdaptableJobFactory{
	
	@Autowired
    private AutowireCapableBeanFactory capableBeanFactory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        //调用父类的方法
        Object jobInstance = super.createJobInstance(bundle);
        //进行注入，这一步解决spring不能注入bean的问题
        capableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
 
