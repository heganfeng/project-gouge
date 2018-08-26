package com.gouge.quartz;

import com.gouge.dao.entity.TSysScheduleSet;
import com.gouge.dao.mapper.TSysScheduleSetMapper;
import com.gouge.quartz.service.BaseService;
import com.gouge.quartz.startup.BeanDefineConfigue;
import com.gouge.quartz.util.DateConverter;
import com.gouge.quartz.util.JobConstants;
import com.gouge.quartz.util.JsonUtil;
import com.gouge.quartz.util.SpringHelper;
import com.gouge.service.JsoupService;
import com.gouge.service.SyncService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;

import java.util.Calendar;
import java.util.Date;

/**
 * Job base class
 *
 * @author Suoron
 */

@DisallowConcurrentExecution
public abstract class BaseJob implements InterruptableJob {
    private static final Logger log = LogManager.getLogger(BaseJob.class);

    public BaseJob() {

    }

    public abstract void executeJob(JobExecutionContext context) throws Exception;

    //job ID
    protected int jobId = 0;

    // has the job been interrupted?    
    protected boolean _interrupted = false;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        TSysScheduleSetMapper scheduleSetMapper = SpringHelper.getBean(TSysScheduleSetMapper.class);
        BaseService baseService = SpringHelper.getBean(BaseService.class);

        String jobName = context.getJobDetail().getKey().getName();
        String triggerName = getTriggerName(context);
        Date now = Calendar.getInstance().getTime();
        String nowString = DateConverter.toString(now);
        long ltime = now.getTime();
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        TSysScheduleSet record = null;
        try {
            this.jobId = jobDataMap.getInt(JobConstants.EXECUTE.JOB_ID);
            log.warn("开始执行任务，任务名：{}；触发器名：{}，开始时间 {} , {}", new Object[]{jobName, triggerName, nowString},JsonUtil.toJson(jobDataMap));
            executeJob(context);
            long ms = Calendar.getInstance().getTimeInMillis() - ltime;
            log.warn("结束执行任务，任务名：{};执行时间是：{} 毫秒", new Object[]{jobName,String.valueOf(ms)});

            /**
             *  Record the run state to db.
             *
             */
            if (record == null && scheduleSetMapper != null) {
                record = scheduleSetMapper.selectByPrimaryKey(jobId);
            }
            if (record != null) {
                record.setLastStatus(JobConstants.STATUS.RUNNING);
                record.setLastDealTime(new Date());
                int ret = baseService.updateByPrimaryKey(record);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (record != null) {
                record.setLastStatus(JobConstants.STATUS.EXCEPTION);
                record.setLastDealTime(new Date());
                int ret = baseService.updateByPrimaryKey(record);
            }
            log.error("执行任务出错，{}", new Object[]{e.getMessage()}, e);
        }

    }
    protected static JsoupService jsoupService;
    protected static SyncService syncService;

    static {
        jsoupService =  SpringHelper.getBean(JsoupService.class);
        syncService = SpringHelper.getBean(SyncService.class);
    }

    protected JobDataMap getJobDataMap(JobExecutionContext context) {
        return context.getJobDetail().getJobDataMap();
    }

    private String buildLog(JobExecutionContext context) {
        //TODO 构建日志内容
        return "";
    }

    private String getTriggerName(JobExecutionContext context) {
        String triggerName = "defaultDirectExec";

        Trigger trigger = context.getTrigger();
        if (trigger != null) {
            triggerName = trigger.getKey().getName();
        }
        return triggerName;
    }

    public abstract void interrupt() throws UnableToInterruptJobException;


}
