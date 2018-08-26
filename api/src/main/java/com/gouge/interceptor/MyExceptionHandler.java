package com.gouge.interceptor;

import com.alibaba.fastjson.JSON;
import com.gouge.exception.ApiException;
import com.gouge.kit.josn.JsonResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;


/**
 * SpringMVC 异常统一处理器
 *
 * @author ken
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    private static final Logger LOG = LogManager.getLogger(MyExceptionHandler.class);


    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        LOG.error("系统异常或错误：", ex);

        String accept = request.getHeader("Accept");
        String uri = request.getRequestURI();
        LOG.debug("uri = {}, accept = {}", uri, accept);

        JsonResult result = null;
        Writer out;
		try {
			out = response.getWriter();
			response.setCharacterEncoding("UTF-8");
			if(ex instanceof ApiException){
				ApiException b = (ApiException) ex;
				result = new JsonResult(b.getCode(),b.getMessage());
			}else if(ex instanceof NullPointerException){
				result = JsonResult.getFailResult("系统繁忙，请稍后再试！");
			}else {
				result = JsonResult.getFailResult("系统繁忙，请稍后再试！");
			}
	        out.write(JSON.toJSONString(result));
		} catch (IOException e) {
			LOG.error("",e);
		}
        
        return new ModelAndView();
    }

}
