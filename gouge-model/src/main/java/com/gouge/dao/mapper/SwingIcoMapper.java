package com.gouge.dao.mapper;

import com.gouge.dao.entity.SwingIco;

import java.util.List;

public interface SwingIcoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SwingIco record);

    int insertSelective(SwingIco record);

    SwingIco selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SwingIco record);

    int updateByPrimaryKey(SwingIco record);

    List<SwingIco> selectAll();
}