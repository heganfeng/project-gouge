package com.gouge.quartz.service.impl;

import com.gouge.dao.entity.TSysScheduleParam;
import com.gouge.dao.entity.TSysScheduleParamExample;
import com.gouge.dao.entity.TSysScheduleSet;
import com.gouge.dao.entity.TSysScheduleSetExample;
import com.gouge.dao.mapper.TSysScheduleParamMapper;
import com.gouge.dao.mapper.TSysScheduleSetMapper;
import com.gouge.quartz.service.SchedulerService;
import com.gouge.quartz.service.SchedulerStartupRegister;
import com.gouge.quartz.util.SpringHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class SchedulerStartupRegisterImpl implements SchedulerStartupRegister{
	protected Logger logger = LogManager.getLogger(SchedulerStartupRegisterImpl.class);
	
	@Resource
	TSysScheduleSetMapper scheduleSetMapper;
	
	@Resource
	TSysScheduleParamMapper scheduleParamMapper;
	
	//@Resource
	//SchedulerService schedulerService;
	
	private static final Byte IS_ENABLED = 0;
	
	public void registerJobs(String group) {
		logger.info("============================================");
		logger.info("Enter SchedulerStartupRegisterImpl, register all jobs");
		
		TSysScheduleSetExample scheduleSetExample = new TSysScheduleSetExample();
		TSysScheduleParamExample scheduleParamExample = new TSysScheduleParamExample();
		
		scheduleSetExample.createCriteria().andEnabledEqualTo(IS_ENABLED);					
		scheduleParamExample.createCriteria().andEnabledEqualTo(IS_ENABLED);
		
		SchedulerService schedulerService = SpringHelper.getBean(SchedulerService.class);
		
		List<TSysScheduleSet> scheduleSetList = scheduleSetMapper.selectByExample(scheduleSetExample);
		List<TSysScheduleParam> scheduleParamList = scheduleParamMapper.selectByExample(scheduleParamExample);
		int registerJobCount = 0;
		
		if(scheduleSetList != null && scheduleSetList.size() > 0){
			for(TSysScheduleSet scheduleSet: scheduleSetList){
				if(!StringUtils.isEmpty(scheduleSet.getCron())){
					List<TSysScheduleParam> params = getJobParams(scheduleParamList,scheduleSet.getId());
					schedulerService.startJob(scheduleSet,params);
					logger.info("#### register "+ scheduleSet.getName());
					registerJobCount++;						
				}else{
					logger.warn("$$$$ error expr + " + scheduleSet.getCron());
				}
			}
		}			
		logger.info("Complete SchedulerStartupRegisterImpl, register: " + registerJobCount + " Jobs");
		logger.info("============================================");
	}
	
	private List<TSysScheduleParam> getJobParams(List<TSysScheduleParam> scheduleParamList,Integer id){
		List<TSysScheduleParam> params = new ArrayList();
		if(scheduleParamList != null && scheduleParamList.size()>0){
			for(TSysScheduleParam scheduleParam : scheduleParamList){
				if(scheduleParam.getJobId() == id){
					params.add(scheduleParam);
				}
			}
		}
		return params;		
	}

}
