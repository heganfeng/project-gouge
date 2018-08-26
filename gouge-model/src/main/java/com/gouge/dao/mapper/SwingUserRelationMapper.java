package com.gouge.dao.mapper;

import com.gouge.dao.entity.SwingUserRelation;

public interface SwingUserRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(SwingUserRelation record);

    int insertSelective(SwingUserRelation record);

    SwingUserRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SwingUserRelation record);

    int updateByPrimaryKey(SwingUserRelation record);
}