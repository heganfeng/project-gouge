package com.gouge.interceptor;

import com.gouge.kit.josn.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Controller请求参数输出日志
 *
 * @author Boren You
 * @dateTime 2016/11/4 1:42
 * @since 1.0.0
 */
public class RequestParametersLogAdvice implements MethodBeforeAdvice {

    private Logger logger = LogManager.getLogger(RequestParametersLogAdvice.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {

        StringBuilder path = new StringBuilder("");
        path.append(target.getClass());
        path.append(".");
        path.append(method.getName());
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        int i = 0;
        flag:
        for (Annotation[] annotations : parameterAnnotations) {
            Object arg = args[i];
            for (Annotation annotation : annotations) {
                if (annotation instanceof RequestBody) {
                    logger.info("请求控制器 : {} | params = {}", path.toString(), JsonUtil.toJson(arg));
                    break flag;
                }
            }
            i++;
        }
    }


}

