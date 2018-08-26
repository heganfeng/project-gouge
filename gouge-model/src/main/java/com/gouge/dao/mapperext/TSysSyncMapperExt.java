package com.gouge.dao.mapperext;

import com.gouge.dao.entity.TSysSync;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysSyncMapperExt {

    TSysSync getOneByTitle(@Param("title") String title,@Param("type") Integer type);

    List<TSysSync> getByIsSync();
}