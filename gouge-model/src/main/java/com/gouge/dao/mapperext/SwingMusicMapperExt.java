package com.gouge.dao.mapperext;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.SwingMenu;
import com.gouge.dao.entity.SwingMusic;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface SwingMusicMapperExt {


    Page<SwingMusic> getPageMusic(Map<String, Object> params, RowBounds rowBounds);

    List<SwingMusic> getMusicByUserId(Map<String, Object> params);
}