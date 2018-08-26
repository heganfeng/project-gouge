package com.gouge.dao.mapper;

import com.gouge.dao.entity.TSysSyncImage;

public interface TSysSyncImageMapper {
    int deleteByPrimaryKey(String recId);

    int insert(TSysSyncImage record);

    int insertSelective(TSysSyncImage record);

    TSysSyncImage selectByPrimaryKey(String recId);

    int updateByPrimaryKeySelective(TSysSyncImage record);

    int updateByPrimaryKey(TSysSyncImage record);
}