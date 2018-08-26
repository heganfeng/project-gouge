package com.gouge.interceptor;

import com.gouge.exception.ApiException;
import com.gouge.service.ApiAuthorizedService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 登录拦载
 *
 * @author ken
 */
public class LoginInterceptor extends HandlerInterceptorAdapter implements
        HandlerInterceptor {
    private static final  Logger log = LogManager.getLogger(LoginInterceptor.class);

    @Autowired
    private ApiAuthorizedService apiAuthorizedService;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        boolean isLogin = true;
        String platformtype = request.getHeader("platformtype");
        if(null != platformtype && platformtype.equals("SWING"))
            isLogin = apiAuthorizedService.apiAuthorizedSwingLogin(request);
        else
            isLogin = apiAuthorizedService.apiAuthorizedLogin(request);

        request.setAttribute("isLogin",isLogin);
        return true;
    }
}
