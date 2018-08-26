package com.gouge.service.impl;

import com.gouge.dao.entity.SwingUser;
import com.gouge.dao.entity.TSysUser;
import com.gouge.redis.RedisCache;
import com.gouge.redis.RedisUtil;
import com.gouge.service.ApiAuthorizedService;
import com.gouge.util.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by grandfen on 17/4/20.
 */
public class ApiAuthorizedServiceImpl implements ApiAuthorizedService{

    @Qualifier(value = "redisCache")
    @Autowired
    private RedisCache redisCache;


    @Override
    public boolean apiAuthorizedLogin(HttpServletRequest request) {
//        String sessionId = request.getSession().getId();
        String sessionId = request.getHeader("jsessionid");
        if(sessionId == null){
            sessionId = request.getSession().getId();
        }
        if(sessionId == null){
            return false;
        }
        if(!redisCache.contains(RedisUtil.PREFIX+sessionId)){
            request.getSession().removeAttribute(LoginUtil.SESSION_LOGIN_NAME);
            return false;
        }else{
            if(request.getSession().getAttribute(LoginUtil.SESSION_LOGIN_NAME) == null){
                TSysUser redisUser = (TSysUser)redisCache.get(RedisUtil.PREFIX+sessionId);
                request.getSession().setAttribute(LoginUtil.SESSION_LOGIN_NAME,redisUser);
            }
        }
        //刷新缓存
        redisCache.expire(RedisUtil.PREFIX+sessionId,RedisUtil.LOGIN_EXPIRE);
        return true;
    }


    @Override
    public boolean apiAuthorizedSwingLogin(HttpServletRequest request) {
        String sessionId = request.getHeader("jsessionid");
        if(sessionId == null){
            sessionId = request.getSession().getId();
        }
        if(sessionId == null){
            return false;
        }
        if(!redisCache.contains(RedisUtil.PREFIX+sessionId)){
            request.getSession().removeAttribute(LoginUtil.SESSION_LOGIN_NAME);
            return false;
        }else{
            if(request.getSession().getAttribute(LoginUtil.SESSION_LOGIN_NAME) == null){
                SwingUser redisUser = (SwingUser)redisCache.get(RedisUtil.PREFIX+sessionId);
                request.getSession().setAttribute(LoginUtil.SESSION_LOGIN_NAME,redisUser);
            }
        }
        //刷新缓存
        redisCache.expire(RedisUtil.PREFIX+sessionId,RedisUtil.LOGIN_SWING_EXPIRE);
        return true;
    }
}
