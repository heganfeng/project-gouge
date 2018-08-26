package com.gouge.service;

import com.gouge.dao.entity.*;

import java.util.List;

/**
 * Created by grandfen on 17/7/20.
 */
public interface SyncService {

    List<TSysSync>  getSyncList();

    List<TSysSyncImage> getImageBySyncId(String syncId);

    int savePoint(TSysTroughPoint point);

    int saveAttachment(TSysAttachment attachment);

    int saveSync(TSysSync sysSync);

    int updateSync(TSysSync sysSync);

    List<TSysSyncImage> getNoLocalList();

    void downloadImage(TSysSyncImage image);

    int getRankingIndex(int jobId);

    int updateSchSetRemark(int jobId,String remark);
}
