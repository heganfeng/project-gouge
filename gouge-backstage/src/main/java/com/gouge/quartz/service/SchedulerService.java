package com.gouge.quartz.service;

import com.gouge.dao.entity.TSysScheduleParam;
import com.gouge.dao.entity.TSysScheduleSet;
import org.quartz.Trigger.TriggerState;

import java.util.List;

/**
* crate by grandfen
 */
public interface SchedulerService {

	
	boolean startJob(int jobId);
	boolean stopJob(int jobId);
	
	boolean startJob(TSysScheduleSet scheduleSet, List<TSysScheduleParam> params);

	/**
	 * 启动任务一次。
	 * @param scheduleSet
	 * @param params
	 * @return
	 */
	boolean startOneTime(TSysScheduleSet scheduleSet, List<TSysScheduleParam> params);

	/**
	 *  停止计划
	 * @param jobDefId
	 * @param bean
	 * @param group
	 * @return
	 */
	boolean shutdownPlan(String jobDefId, String bean, String group);
		
	boolean startPlan(TSysScheduleSet scheduleSet);
	
	/**
	 * 返回计划的执行状态
	 * @param planId 计划的ID
	 * @param group 分组值
	 * @return 
	 * TriggerState
	 * @exception 
	 * @since  1.0.0
	 */
	TriggerState getTriggerState(String planId, String bean, String group);
	
	/**
	 * 启动Scheduler（由框架管理，开发人员不需要调用） 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	void startScheduler();
	
	/**
	 * 关闭Scheduler（由框架管理，开发人员不需要调用）
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	void shutdownScheduler();
}
