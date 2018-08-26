package com.gouge.dao.mapperext;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.ApiMenu;
import com.gouge.dao.entity.SwingMenu;
import com.gouge.dao.entity.TSysTroughPoint;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface SwingMenuMapperExt {

    List<SwingMenu> getFirstMenus();

    List<SwingMenu> getMenuForParantId(String id);

    Page<SwingMenu> getPageMenus(Map<String,Object> params, RowBounds rowBounds);
}