package com.gouge.dao.mapperext;

import com.gouge.dao.entity.ApiMenu;
import com.gouge.dao.entity.TSysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApiMenuMapperExt {

    List<ApiMenu> getAll();

}