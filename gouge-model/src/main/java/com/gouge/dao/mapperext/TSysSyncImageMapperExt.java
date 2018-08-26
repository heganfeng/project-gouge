package com.gouge.dao.mapperext;

import com.gouge.dao.entity.TSysSyncImage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysSyncImageMapperExt {

    List<TSysSyncImage> getImageBySyncId(@Param("syncId") String syncId);

    List<TSysSyncImage> getNoLocalList();
}