package com.gouge.dao.mapperext;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.SwingNotepad;
import com.gouge.dao.entity.SwingUserRelation;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface SwingUserRelationMapperExt {


    Page<SwingUserRelation> getPageRelations(Map<String, Object> params, RowBounds rowBounds);

    List<SwingUserRelation> getRelationByUserId(Map<String, Object> params);
}