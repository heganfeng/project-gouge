package com.gouge.quartz.startup;

import com.gouge.quartz.service.SchedulerStartupRegister;
import com.gouge.quartz.util.SpringHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *   Auto startup class
 *   @author zhu.ri.qing   
 * 
 */

@Component("BeanDefineConfigue") 
public class BeanDefineConfigue implements ApplicationListener<ContextRefreshedEvent> {
    
    private static final Logger logger = LogManager.getLogger(BeanDefineConfigue.class);
    
    private static int JOBS_START_FLAG = 0;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {       	 
    	if(JOBS_START_FLAG == 0)
    	{    		
    		logger.info("Starting to lunch jobs....");
    		
    		JOBS_START_FLAG = 1;
    		String group = null;
    		
    		SchedulerStartupRegister schedulerStartupRegister = SpringHelper.getBean(SchedulerStartupRegister.class);
    		
    		if(schedulerStartupRegister!=null){
    			schedulerStartupRegister.registerJobs(group);
    		}    		
    	}        	        	
   }    
}
