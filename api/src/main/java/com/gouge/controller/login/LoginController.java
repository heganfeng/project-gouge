package com.gouge.controller.login;

import com.gouge.controller.BaseController;
import com.gouge.dao.entity.TSysUser;
import com.gouge.dao.params.login.LoginParam;
import com.gouge.exception.ApiException;
import com.gouge.kit.josn.JsonResult;
import com.gouge.redis.RedisCache;
import com.gouge.redis.RedisUtil;
import com.gouge.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by grandfen on 17/7/20.
 */
@Controller
@RequestMapping(value = "/apis/v1")
public class LoginController extends BaseController{

    private static final Logger logger = LogManager.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;
    @Qualifier(value = "redisCache")
    @Autowired
    private RedisCache redisCache;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        TSysUser user = loginService.loginOne(loginParam.getUsername(),loginParam.getPassword());
        if(user != null){
            String sessionId = request.getSession().getId();
            if(!redisCache.contains(RedisUtil.PREFIX+sessionId)){
                redisCache.put(RedisUtil.PREFIX+sessionId,user, RedisUtil.LOGIN_EXPIRE);
            }
        }else{
            throw new ApiException("登录失败！");
        }
        return new JsonResult(user);
    }
}
