package com.gouge.controller.swing.login;

import com.gouge.controller.BaseController;
import com.gouge.dao.entity.SwingUser;
import com.gouge.dao.entity.TSysUser;
import com.gouge.dao.params.login.LoginParam;
import com.gouge.exception.ApiException;
import com.gouge.kit.josn.JsonResult;
import com.gouge.redis.RedisCache;
import com.gouge.redis.RedisUtil;
import com.gouge.service.LoginService;
import com.gouge.service.SwingMainService;
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
 * Created by Administrator on 2018/8/7.
 */
@Controller
@RequestMapping(value = "/apis/swing/v1")
public class LoginSwingController extends BaseController{

    private static final Logger logger = LogManager.getLogger(LoginSwingController.class);

    @Autowired
    private SwingMainService swingMainService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(@RequestBody LoginParam loginParam, HttpServletRequest request) {
        SwingUser user = swingMainService.loginOne(loginParam.getUsername(),loginParam.getPassword());
        if(user != null){
            String sessionId =  request.getHeader("jsessionid");
            if(sessionId == null)
                sessionId = request.getSession().getId();
            if(!getRedisCache().contains(RedisUtil.PREFIX+sessionId)){
                getRedisCache().put(RedisUtil.PREFIX+sessionId,user, RedisUtil.LOGIN_SWING_EXPIRE);
            }
        }else{
            throw new ApiException("登录失败！");
        }
        return new JsonResult(user);
    }
}
