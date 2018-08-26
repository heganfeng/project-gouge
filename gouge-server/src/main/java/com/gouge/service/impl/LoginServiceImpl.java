package com.gouge.service.impl;

import com.gouge.dao.entity.TSysUser;
import com.gouge.dao.mapperext.TSysUserMapperExt;
import com.gouge.service.LoginService;
import com.gouge.tool.EncryptTool;
import com.gouge.util.StaticUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by grandfen on 17/7/20.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private TSysUserMapperExt tSysUserMapperExt;

    @Override
    public TSysUser loginOne(String userCode, String passWord) {
        String enPass =  null;
        try {
            enPass = EncryptTool.getEnCode(passWord, StaticUtils.key);
        }catch (Exception e){
            e.printStackTrace();
        }
        TSysUser user = tSysUserMapperExt.loginOne(userCode, enPass);
        return user;
    }
}
