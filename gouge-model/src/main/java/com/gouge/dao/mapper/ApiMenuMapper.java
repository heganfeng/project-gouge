package com.gouge.dao.mapper;

import com.gouge.dao.entity.ApiMenu;

public interface ApiMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(ApiMenu record);

    int insertSelective(ApiMenu record);

    ApiMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ApiMenu record);

    int updateByPrimaryKey(ApiMenu record);
}