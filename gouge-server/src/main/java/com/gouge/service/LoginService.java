package com.gouge.service;

import com.gouge.dao.entity.TSysUser;

/**
 * Created by grandfen on 17/7/20.
 */
public interface LoginService {

    TSysUser loginOne(String userCode,String passWord);
}
