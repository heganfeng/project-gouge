package com.gouge.dao.mapper;

import com.gouge.dao.entity.SwingUser;

public interface SwingUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SwingUser record);

    int insertSelective(SwingUser record);

    SwingUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SwingUser record);

    int updateByPrimaryKey(SwingUser record);
}