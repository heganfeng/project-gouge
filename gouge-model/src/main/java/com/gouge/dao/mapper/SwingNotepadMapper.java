package com.gouge.dao.mapper;

import com.gouge.dao.entity.SwingNotepad;

public interface SwingNotepadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SwingNotepad record);

    int insertSelective(SwingNotepad record);

    SwingNotepad selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SwingNotepad record);

    int updateByPrimaryKeyWithBLOBs(SwingNotepad record);

    int updateByPrimaryKey(SwingNotepad record);
}