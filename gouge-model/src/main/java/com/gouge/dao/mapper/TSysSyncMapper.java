package com.gouge.dao.mapper;

import com.gouge.dao.entity.TSysSync;

public interface TSysSyncMapper {
    int deleteByPrimaryKey(String recId);

    int insert(TSysSync record);

    int insertSelective(TSysSync record);

    TSysSync selectByPrimaryKey(String recId);

    int updateByPrimaryKeySelective(TSysSync record);

    int updateByPrimaryKey(TSysSync record);
}