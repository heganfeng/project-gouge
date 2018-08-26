package com.gouge.dao.mapperext;

import com.gouge.dao.entity.TSysUser;
import org.apache.ibatis.annotations.Param;

public interface TSysUserMapperExt {

    TSysUser loginOne(@Param("userCode") String userCode,@Param("passWord") String  passWord);

}