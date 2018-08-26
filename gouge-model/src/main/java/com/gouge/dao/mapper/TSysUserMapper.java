package com.gouge.dao.mapper;

import com.gouge.dao.entity.TSysUser;

public interface TSysUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(TSysUser record);

    int insertSelective(TSysUser record);

    TSysUser selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(TSysUser record);

    int updateByPrimaryKey(TSysUser record);
}