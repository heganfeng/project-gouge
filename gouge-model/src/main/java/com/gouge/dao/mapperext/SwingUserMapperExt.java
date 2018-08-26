package com.gouge.dao.mapperext;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.SwingMenu;
import com.gouge.dao.entity.SwingUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface SwingUserMapperExt {

    SwingUser getUserByUserCode(String userCode);

    SwingUser loginOne(@Param("userCode") String userCode, @Param("password") String  passWord);

    Page<SwingUser>  getPageByUsers(Map<String, Object> params, RowBounds rowBounds);

    Page<SwingUser>  getPageCanAddRelationUsers(Map<String, Object> params, RowBounds rowBounds);

}