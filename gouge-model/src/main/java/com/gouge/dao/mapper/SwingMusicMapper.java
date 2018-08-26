package com.gouge.dao.mapper;

import com.gouge.dao.entity.SwingMusic;

public interface SwingMusicMapper {
    int deleteByPrimaryKey(String id);

    int insert(SwingMusic record);

    int insertSelective(SwingMusic record);

    SwingMusic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SwingMusic record);

    int updateByPrimaryKey(SwingMusic record);
}