package com.gouge.dao.mapper;

import com.gouge.dao.entity.TSysTroughPoint;

public interface TSysTroughPointMapper {
    int deleteByPrimaryKey(String id);

    int insert(TSysTroughPoint record);

    int insertSelective(TSysTroughPoint record);

    TSysTroughPoint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSysTroughPoint record);

    int updateByPrimaryKey(TSysTroughPoint record);
}