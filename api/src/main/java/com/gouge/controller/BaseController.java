package com.gouge.controller;


import com.gouge.dao.entity.SwingUser;
import com.gouge.dao.entity.TSysUser;
import com.gouge.exception.ApiException;
import com.gouge.redis.RedisCache;
import com.gouge.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;

public class BaseController extends XssController {

    @Qualifier(value = "redisCache")
    @Autowired
    private RedisCache redisCache;

    public RedisCache getRedisCache() {
        return redisCache;
    }

    /**

     * 检查登录
     * @param request
     * @return
     */
    protected boolean authorizedLogin(HttpServletRequest request){
        Boolean loginFlag = Boolean.valueOf(String.valueOf(request.getAttribute("isLogin")));
        if(!loginFlag){
            throw new ApiException("-99","登录超时或未登录，请重新登录！");
        }
        return true;
    }

    /**
     * 获取swing项目的登陆用户
     * @param request
     * @return
     */
    protected SwingUser getSwingLoginUser(HttpServletRequest request){
        String sessionId =  request.getHeader("jsessionid");
        if(sessionId == null)
            sessionId = request.getSession().getId();
        SwingUser user = null;
        if(getRedisCache().contains(RedisUtil.PREFIX+sessionId)){
            user = (SwingUser) redisCache.get(RedisUtil.PREFIX+sessionId);
        }
        return  user;
    }
}
