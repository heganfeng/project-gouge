package com.gouge.quartz.job;

import com.gouge.quartz.BaseJob;
import org.apache.logging.log4j.LogManager;
import org.quartz.JobExecutionContext;
import org.quartz.UnableToInterruptJobException;
import org.springframework.stereotype.Component;

/**
 * Created by grandfen on 17/3/24.
 */
@Component("umeiJob")
public class UmeiJob extends BaseJob {

    protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(UmeiJob.class);

    @Override
    public void executeJob(JobExecutionContext context) throws Exception {
        String url = "http://www.umei.cc";
        String chirdUrl = "/meinvtupian/rentiyishu";
        jsoupService.selectUmei(url,chirdUrl);
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        _interrupted = true;
    }

}
