package com.gouge.quartz.job;

import com.gouge.dao.entity.TSysAttachment;
import com.gouge.dao.entity.TSysSync;
import com.gouge.dao.entity.TSysSyncImage;
import com.gouge.dao.entity.TSysTroughPoint;
import com.gouge.kit.GenerateKey;
import com.gouge.quartz.BaseJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.UnableToInterruptJobException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by grandfen on 17/7/20.
 */
@Component("generatePointJob")
public class GeneratePointJob extends BaseJob {

    private static final Logger logger = LogManager.getLogger(GeneratePointJob.class);


    private boolean flag = true;

    @Override
    public void executeJob(JobExecutionContext context) throws Exception {
        if(flag){
            flag = false;
            List<TSysSync> list = syncService.getSyncList();
            if(CollectionUtils.isEmpty(list)){
                logger.info("没有找到需要同步的记录，取消执行！");
                return;
            }
            for (TSysSync sysSync : list){
                TSysTroughPoint point = new TSysTroughPoint();
                String id  = GenerateKey.generate();
                point.setId(id);
                point.setTitle(sysSync.getTitle());
                point.setType("1");
                point.setContext(sysSync.getTextContent());
                point.setSourcetype(1);
                point.setCreatedate(new Date());
                point.setIsdelete("N");
                point.setPushbaidu(0);
                point.setSubmitbaidu(0);
                point.setStatus(0);
                point.setBad(0);
                point.setGood(0);
                point.setReadcount(0);
                point.setComment(0);
                point.setCreateuser("admin");
                point.setSyncid(sysSync.getRecId());
                syncService.savePoint(point);
                List<TSysSyncImage> imageList = syncService.getImageBySyncId(sysSync.getRecId());
                if(!CollectionUtils.isEmpty(imageList)){
                    for (TSysSyncImage image : imageList){
                        TSysAttachment tSysAttachment = new TSysAttachment();
                        tSysAttachment.setId(GenerateKey.generate());
                        tSysAttachment.setRefid(id);
                        tSysAttachment.setType("TROUGH_POINT");
                        if(StringUtils.isEmpty(image.getLocalPath())){
                            tSysAttachment.setPath(image.getPath());
                        }else {
                            tSysAttachment.setPath(image.getLocalPath());
                        }
                        tSysAttachment.setFiletype(image.getPath().substring(image.getPath().lastIndexOf("."),image.getPath().length()));
                        tSysAttachment.setCreatedate(new Date());
                        tSysAttachment.setCreateuser("admin");
                        syncService.saveAttachment(tSysAttachment);
                    }
                }
                sysSync.setIsSync("0");
                syncService.updateSync(sysSync);
                logger.info("{}处理完成！",sysSync.getTitle());
            }
            flag = true;
        }
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        _interrupted = true;
    }

}