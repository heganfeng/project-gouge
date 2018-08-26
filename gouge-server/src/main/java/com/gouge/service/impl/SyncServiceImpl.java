package com.gouge.service.impl;

import com.gouge.dao.entity.*;
import com.gouge.dao.mapper.*;
import com.gouge.dao.mapperext.TSysAttachmentMapperExt;
import com.gouge.dao.mapperext.TSysSyncImageMapperExt;
import com.gouge.dao.mapperext.TSysSyncMapperExt;
import com.gouge.kit.GenerateKey;
import com.gouge.service.SyncService;
import com.gouge.util.HttpURLConnectionUtil;
import com.gouge.util.SharePathUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by grandfen on 17/7/20.
 */
@Service
public class SyncServiceImpl implements SyncService {

    private static final Logger logger = LogManager.getLogger(SyncServiceImpl.class);

    @Autowired
    private TSysSyncMapperExt tSysSyncMapperExt;
    @Autowired
    private TSysSyncImageMapperExt tSysSyncImageMapperExt;
    @Autowired
    private TSysTroughPointMapper tSysTroughPointMapper;
    @Autowired
    private TSysAttachmentMapper tSysAttachmentMapper;
    @Autowired
    private TSysSyncMapper tSysSyncMapper;
    @Value("${file.path}")
    private String filePath;
    @Value("${domain.name}")
    private String domainname;
    @Autowired
    private TSysAttachmentMapperExt tSysAttachmentMapperExt;
    @Autowired
    private TSysSyncImageMapper tSysSyncImageMapper;
    @Autowired
    private TSysScheduleSetMapper tSysScheduleSetMapper;

    @Override
    public List<TSysSync> getSyncList() {
        return tSysSyncMapperExt.getByIsSync();
    }

    @Override
    public List<TSysSyncImage> getImageBySyncId(String syncId) {
        return tSysSyncImageMapperExt.getImageBySyncId(syncId);
    }

    @Override
    public int savePoint(TSysTroughPoint point) {
        return tSysTroughPointMapper.insert(point);
    }

    @Override
    public int saveAttachment(TSysAttachment attachment) {
        return tSysAttachmentMapper.insert(attachment);
    }

    @Override
    public int saveSync(TSysSync sysSync) {
        return tSysSyncMapper.insert(sysSync);
    }

    @Override
    public int updateSync(TSysSync sysSync) {
        return tSysSyncMapper.updateByPrimaryKeySelective(sysSync);
    }

    @Override
    public List<TSysSyncImage> getNoLocalList() {
        return tSysSyncImageMapperExt.getNoLocalList();
    }

    @Override
    public void downloadImage(TSysSyncImage image) {
        String dictory = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String path = filePath+ SharePathUtil.FILE_PATH + "/"+dictory+"/";
        if(!new File(path).exists())   {
           new File(path).mkdirs();
        }
        String prefix = image.getPath().substring(image.getPath().lastIndexOf("."),image.getPath().length());
        String fileName = GenerateKey.generate()+prefix;
        File file = new File(path+ fileName);
        try {
            file.createNewFile();
            HttpURLConnectionUtil.getImage(image.getPath(),file);
            Integer [] arr = HttpURLConnectionUtil.getImageSize(file);
            String returnPath = domainname+SharePathUtil.FILE_PATH + "/"+dictory+"/"+fileName;
            int count = tSysAttachmentMapperExt.updatPathToLocal(image.getPath(),returnPath,arr[0],arr[1]);
            logger.info("{}---{}---{}",count,arr[0],arr[1]);
            image.setLocalPath(returnPath);
            tSysSyncImageMapper.updateByPrimaryKeySelective(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int getRankingIndex(int jobId) {
        TSysScheduleSet set = tSysScheduleSetMapper.selectByPrimaryKey(jobId);
        if(set == null || set.getRemark() == null)
             return 0;
        int index = Integer.parseInt(set.getRemark());
        return index;
    }

    @Override
    public int updateSchSetRemark(int jobId, String remark) {
        TSysScheduleSet set = tSysScheduleSetMapper.selectByPrimaryKey(jobId);
        set.setRemark(remark);
        return tSysScheduleSetMapper.updateByPrimaryKeySelective(set);
    }
}
