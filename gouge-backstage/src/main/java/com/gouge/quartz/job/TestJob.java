package com.gouge.quartz.job;

import com.gouge.quartz.BaseJob;
import org.apache.logging.log4j.LogManager;
import org.quartz.JobExecutionContext;
import org.quartz.UnableToInterruptJobException;
import org.springframework.stereotype.Component;

/**
 * Created by grandfen on 17/3/24.
 */
@Component("testJob")
public class TestJob extends BaseJob {

    protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestJob.class);

    @Override
    public void executeJob(JobExecutionContext context) throws Exception {
        logger.info("======1111111111111==="+1);
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        _interrupted = true;
    }

}
