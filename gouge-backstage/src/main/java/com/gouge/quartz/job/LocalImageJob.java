package com.gouge.quartz.job;

import com.gouge.dao.entity.TSysSyncImage;
import com.gouge.quartz.BaseJob;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.quartz.JobExecutionContext;
import org.quartz.UnableToInterruptJobException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */
@Component("localImageJob")
public class LocalImageJob extends BaseJob {

    protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(LocalImageJob.class);
    private boolean flag = true;
    @Override
    public void executeJob(JobExecutionContext context) throws Exception {
        if(flag){
            flag = false;
            List<TSysSyncImage> list = syncService.getNoLocalList();
            if(CollectionUtils.isEmpty(list)){
                logger.info("没有找到需要下载到本地的图片，取消执行！");
                return;
            }
            for (TSysSyncImage image : list){
                syncService.downloadImage(image);
            }
            flag = true;
        }
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        _interrupted = true;
    }

}
