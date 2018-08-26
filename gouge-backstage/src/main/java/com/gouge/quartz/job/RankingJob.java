package com.gouge.quartz.job;

import com.gouge.quartz.BaseJob;
import com.gouge.quartz.util.JobConstants;
import org.apache.logging.log4j.LogManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.JobExecutionContext;
import org.quartz.UnableToInterruptJobException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grandfen on 17/7/21.
 */
@Component("rankingJob")
public class RankingJob extends BaseJob {

    protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestJob.class);

    @Override
    public void executeJob(JobExecutionContext context) throws Exception {
        int jobId = context.getJobDetail().getJobDataMap().getInt(JobConstants.EXECUTE.JOB_ID);
        int currIndex  = syncService.getRankingIndex(jobId);
        if(currIndex > 0){
            int page = 1;
            int index  = 0;
            if(currIndex <= 50){
                index = currIndex;
            }else{
                index = currIndex%50;
            }
            if(currIndex/50 == 0){
                page  = currIndex/50;
            }else{
                page  = currIndex/50 + 1;
            }
            jsoupService.selectRank(index,page);
            syncService.updateSchSetRemark(jobId,String.valueOf(currIndex+1));
        }
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        _interrupted = true;
    }

}
