package com.gouge.dao.mapperext;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.SwingMusic;
import com.gouge.dao.entity.SwingNotepad;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface SwingNotepadMapperExt {


    Page<SwingNotepad> getPageNotepads(Map<String, Object> params, RowBounds rowBounds);

    List<SwingNotepad> getNotepadByUserId(Map<String, Object> params);
}