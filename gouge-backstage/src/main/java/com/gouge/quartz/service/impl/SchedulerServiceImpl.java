package com.gouge.quartz.service.impl;

import com.gouge.dao.entity.TSysScheduleParam;
import com.gouge.dao.entity.TSysScheduleParamExample;
import com.gouge.dao.entity.TSysScheduleSet;
import com.gouge.dao.mapper.TSysScheduleParamMapper;
import com.gouge.dao.mapper.TSysScheduleSetMapper;
import com.gouge.quartz.BaseJob;
import com.gouge.quartz.ExecuteJob;
import com.gouge.quartz.service.SchedulerService;
import com.gouge.quartz.util.CronUtil;
import com.gouge.quartz.util.JobConstants;
import com.gouge.quartz.util.SpringHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.Trigger.TriggerState;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

@Service
public class SchedulerServiceImpl implements SchedulerService, InitializingBean {

    protected Logger logger = LogManager.getLogger(SchedulerServiceImpl.class);

    Scheduler scheduler;
    private final static String LOCK = "lock";


    @Resource
    TSysScheduleSetMapper scheduleSetMapper;

    @Resource
    TSysScheduleParamMapper scheduleParamMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
        scheduler.start();
    }

    @Override
    public boolean startJob(TSysScheduleSet scheduleSet, List<TSysScheduleParam> params) {
        boolean isStart = false;

        synchronized (StringUtils.isEmpty(scheduleSet.getId()) ? LOCK : scheduleSet.getId()) {
            logger.info("Enter start Job method，name=" + scheduleSet.getName());
            isStart = startPlan(scheduleSet);
            if (!isStart) {
                JobDetail jobDetail = getJobDetail(getKey(scheduleSet), scheduleSet.getJobGroup());
                BaseJob jobBean = null;
                boolean isClass = false;
                if (isClassName(scheduleSet)) {
                    try {
                        Class<?> clazz = Class.forName(scheduleSet.getClassImpl());
                        jobBean = (BaseJob) SpringHelper.getBean(clazz);
                        if (jobBean == null) {
                            jobBean = (BaseJob) clazz.newInstance();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        return false;
                    }
                } else {
                    jobBean = (BaseJob) SpringHelper.getBean(scheduleSet.getClassImpl());
                }

                if (scheduleSet.getClassMethod().equals("executeJob")) {
                    if (jobBean != null) {
                        jobDetail = newJob(jobBean.getClass()).withIdentity(getKey(scheduleSet), scheduleSet.getJobGroup()).storeDurably(false).build();
                    }
                } else {
                    if (jobDetail == null) {
                        ExecuteJob executeJob = SpringHelper.getBean(ExecuteJob.class);
                        jobDetail = newJob(executeJob.getClass()).withIdentity(getKey(scheduleSet), scheduleSet.getJobGroup()).storeDurably(false).build();
                        prepare(jobDetail, scheduleSet, params);
                    }
                }

                Map<String, Object> dataMap = buildDataMap(params, scheduleSet);
                jobDetail.getJobDataMap().putAll(dataMap);
                CronTrigger trigger = buildCronTrigger(getKey(scheduleSet), scheduleSet.getJobGroup(), scheduleSet.getCron());
                try {
                    isStart = startPlan(scheduleSet);
                    if (!isStart) {
                        deleteJob(getKey(scheduleSet), scheduleSet.getJobGroup());
                        scheduler.scheduleJob(jobDetail, trigger);
                        logger.info("Start Job Success:" + scheduleSet.getName());
                    }
                    return true;
                } catch (SchedulerException e) {
                    e.printStackTrace();
                    logger.error("Start Job Error:" + scheduleSet.getName() + " " + e.getMessage());
                    return false;
                }
            } else {
                if (!CronUtil.check(scheduleSet.getCron())) {
                    logger.info("Job Expr Error! :" + scheduleSet.getCron());
                } else {
                    logger.info("Job has run:" + scheduleSet.getCron());
                }
            }
        }

        return isStart;
    }

    @Override
    public boolean startOneTime(TSysScheduleSet scheduleSet, List<TSysScheduleParam> params) {
        logger.info("Enter startOneTime method，beanId=" + scheduleSet.getId() + "; group=" + scheduleSet.getJobGroup());
        JobDetail job = getJobDetail(scheduleSet.getClassImpl() + "_" + UUID.randomUUID(), scheduleSet.getJobGroup());
        boolean jobExist = true;
        if (job == null) {
            jobExist = false;
            job = buildJobDetail(scheduleSet, null, false);
        }

        if (job != null) {
            Map<String, Object> dataMap = buildDataMap(params, scheduleSet);
            job.getJobDataMap().putAll(dataMap);
        }
        try {
            SimpleTrigger trigger = buildSimpleTrigger(job);
            if (jobExist) {
                scheduler.scheduleJob(trigger);
            } else {
                scheduler.scheduleJob(job, trigger);
            }
            logger.info("startOneTime success!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("startOneTime error!" + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean shutdownPlan(String planId, String bean, String group) {
        TriggerKey triggerKey = new TriggerKey(getKey(bean, planId), group);
        JobDetail job = getJobDetail(bean + "_" + planId, group);
        try {

            boolean isStop = false;
            TriggerState state = scheduler.getTriggerState(triggerKey);

            if (job != null) {
                scheduler.interrupt(job.getKey());
            }

            if (state == TriggerState.NORMAL
                    || state == TriggerState.BLOCKED) {
                scheduler.pauseTrigger(triggerKey);

                isStop = true;
            }
            if (!isStop) {
                deleteJob(getKey(bean, planId), group);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void deleteJob(String key, String group) {
        JobKey jobKey = new JobKey(key, group);
        try {
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean startPlan(TSysScheduleSet scheduleSet) {
        TriggerKey triggerKey = new TriggerKey(getKey(scheduleSet.getClassImpl(), scheduleSet.getId().toString()), scheduleSet.getJobGroup());
        try {
            TriggerState state = scheduler.getTriggerState(triggerKey);
            if (state != null) {
                if (state == TriggerState.PAUSED || state == TriggerState.BLOCKED) {
                    scheduler.resumeTrigger(triggerKey);
                    return true;
                } else if (state == TriggerState.NONE || state == TriggerState.COMPLETE || state == TriggerState.ERROR) {
                    JobKey jobKey = new JobKey(getKey(scheduleSet.getClassImpl(), scheduleSet.getId().toString()), scheduleSet.getJobGroup());
                    scheduler.deleteJob(jobKey);
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public TriggerState getTriggerState(String planId, String bean, String group) {
        TriggerKey triggerKey = new TriggerKey(getKey(bean, planId), group);
        try {
            TriggerState state = scheduler.getTriggerState(triggerKey);
            return state;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void startScheduler() {
        try {
            init();
            if (!scheduler.isStarted()) {
                scheduler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void shutdownScheduler() {
        try {
            init();
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {

        if (scheduler == null) {
            scheduler = (Scheduler) SpringHelper.getBean("scheduler");
        }
        if (scheduler == null) {
            throw new RuntimeException("Can't get scheduler instance, please check spring-gouge-quartz.xml file.");
        }
    }

    private JobDetail getJobDetail(String beanId, String group) {
        JobKey jobKey = new JobKey(beanId, group);
        try {
            JobDetail jobDetail = scheduler.getJobDetail(jobKey);
            if (jobDetail != null) {
                return jobDetail;
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SimpleTrigger buildSimpleTrigger(JobDetail job) {
        SimpleTrigger trigger = (SimpleTrigger) newTrigger().forJob(job)
                .startAt(new Date()).withSchedule(simpleSchedule().withIntervalInSeconds(1)
                        .withRepeatCount(0)
                )
                .build();
        return trigger;
    }

    private CronTrigger buildCronTrigger(String planId, String group, String expr) {
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(planId, group)
                .withSchedule(CronScheduleBuilder.cronSchedule(expr)).build();
        return trigger;
    }

    private JobDetail buildJobDetail(TSysScheduleSet scheduleSet, List<TSysScheduleParam> params, boolean isDurable) {
        BaseJob jobBean = null;
        JobDetail jobDetail = null;

        if (isClassName(scheduleSet)) {
            try {
                Class<?> clazz = Class.forName(scheduleSet.getClassImpl());
                jobBean = (BaseJob) SpringHelper.getBean(clazz);
                if (jobBean == null) {
                    jobBean = (BaseJob) clazz.newInstance();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        } else {
            jobBean = (BaseJob) SpringHelper.getBean(scheduleSet.getClassImpl());
        }

        if (scheduleSet.getClassMethod().equals("executeJob")) {
            jobDetail = newJob(jobBean.getClass()).withIdentity(getKey(scheduleSet.getClassImpl(),
                    scheduleSet.getId().toString()), scheduleSet.getJobGroup()).storeDurably(isDurable).build();
        } else {
            ExecuteJob executeJob = SpringHelper.getBean(ExecuteJob.class);
            jobDetail = newJob(executeJob.getClass()).withIdentity(getKey(scheduleSet), scheduleSet.getJobGroup()).storeDurably(false).build();
            prepare(jobDetail, scheduleSet, params);
        }

        jobDetail.getJobDataMap().putAll(buildDataMap(params, scheduleSet));
        return jobDetail;
    }

    private Map<String, Object> buildDataMap(List<TSysScheduleParam> params, TSysScheduleSet scheduleSet) {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        if (scheduleSet != null)
            dataMap.put(JobConstants.EXECUTE.JOB_ID, scheduleSet.getId());

        if (params == null) {
            return dataMap;
        }
        for (TSysScheduleParam scheduleParam : params) {
            dataMap.put(scheduleParam.getParamKey(), scheduleParam.getParamValue());
        }
        return dataMap;
    }

    private void prepare(JobDetail jobDetail, TSysScheduleSet scheduleSet, List<TSysScheduleParam> params) {
        jobDetail.getJobDataMap().put(JobConstants.EXECUTE.JOB_ID, scheduleSet.getId());
        jobDetail.getJobDataMap().put(JobConstants.EXECUTE.TASK_NAME, scheduleSet.getName());
        jobDetail.getJobDataMap().put(JobConstants.EXECUTE.METHOD_NAME, scheduleSet.getClassMethod());
        jobDetail.getJobDataMap().put(JobConstants.EXECUTE.CLASS_NAME, scheduleSet.getClassImpl());
        if (params != null && params.size() > 0) {
            //jobDetail.getJobDataMap().put(EXECUTE.PARAMS, params);
            jobDetail.getJobDataMap().put(JobConstants.EXECUTE.PARAMS, buildDataMap(params, scheduleSet));
        }
    }

    private String getKey(TSysScheduleSet scheduleSet) {
        return scheduleSet.getClassImpl() + "_" + scheduleSet.getId();
    }

    private String getKey(String bean, String jobDefId) {
        return bean + "_" + jobDefId;
    }

    private boolean isClassName(TSysScheduleSet scheduleSet) {
        try {
            Class<?> clazz = Class.forName(scheduleSet.getClassImpl());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean startJob(int jobId) {
        TSysScheduleSet record = scheduleSetMapper.selectByPrimaryKey(jobId);
        if (record != null && record.getEnabled() == JobConstants.IS_ENABLED) {
            TSysScheduleParamExample example = new TSysScheduleParamExample();
            example.createCriteria().andJobIdEqualTo(jobId).andEnabledEqualTo(JobConstants.IS_ENABLED);
            List<TSysScheduleParam> params = scheduleParamMapper.selectByExample(example);
            if (record.getType() == JobConstants.PLAN_TYPE.ONE_TIME) {
                startOneTime(record, params);
            } else {
                startJob(record, params);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean stopJob(int jobId) {

        TSysScheduleSet record = scheduleSetMapper.selectByPrimaryKey(jobId);
        if (record != null && record.getEnabled() == JobConstants.IS_ENABLED) {
/*	    	ScheduleParamExample example = new ScheduleParamExample();
            example.createCriteria().andJobIdEqualTo(jobId).andEnabledEqualTo(JobConstants.IS_ENABLED);
	    	List<ScheduleParam> params = scheduleParamMapper.selectByExample(example);
*/
            return shutdownPlan(record.getId().toString(), record.getClassImpl(), record.getJobGroup());

        }
        return false;
    }
}
