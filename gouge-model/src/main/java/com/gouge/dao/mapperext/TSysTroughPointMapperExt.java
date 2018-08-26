package com.gouge.dao.mapperext;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.ApiMenu;
import com.gouge.dao.entity.TSysTroughPoint;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TSysTroughPointMapperExt {

    List<TSysTroughPoint> getAll();

    Page<TSysTroughPoint> getAllByPage(RowBounds rowBounds);

}