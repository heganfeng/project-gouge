package com.gouge.dao.mapper;

import com.gouge.dao.entity.SwingMenu;

public interface SwingMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(SwingMenu record);

    int insertSelective(SwingMenu record);

    SwingMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SwingMenu record);

    int updateByPrimaryKey(SwingMenu record);
}