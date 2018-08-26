package com.gouge.quartz.util;

import org.springframework.util.Assert;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * spring工具类
 *
 * @author xianyongjie
 */
public final class SpringUtil {

    /**
     * applicationContext
     */
    public static WebApplicationContext applicationContext = ContextLoader
            .getCurrentWebApplicationContext();
    ;

    public void destroy() throws Exception {
        applicationContext = null;
    }

    /**
     * 获取applicationContext
     *
     * @return applicationContext
     */
    public static WebApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 获取实例
     *
     * @param name Bean名称
     * @return 实例
     */
    public static Object getBean(String name) {
        Assert.hasText(name);
        return applicationContext.getBean(name);
    }
    
    /**
     * 获取实例
     *
     * @param
     * @return 实例
     */
    public static <T> T getBean(Class<T> type) {
        return applicationContext.getBean(type);
    }

    /**
     * 获取实例
     *
     * @param name Bean名称
     * @param type Bean类型
     * @return 实例
     */
    public static <T> T getBean(String name, Class<T> type) {
        Assert.hasText(name);
        Assert.notNull(type);
        return applicationContext.getBean(name, type);
    }

    /**
     * 获取国际化消息
     *
     * @param code 代码
     * @param args 参数
     * @return 国际化消息
     */
    public static String getMessage(String code, Object... args) {
        LocaleResolver localeResolver = getBean("localeResolver",
                LocaleResolver.class);
        Locale locale = localeResolver.resolveLocale(null);
        return applicationContext.getMessage(code, args, locale);
    }

    /**
     * 代替spring mvc中的responseBody标签输出响应信息
     *
     * @param response
     * @param msg
     * @throws Exception
     */
    public static void writeResponseMsg(HttpServletResponse response, String msg)
            throws Exception {
        response.getWriter().write(msg);
    }

    /**
     * 检测类是否存在
     *
     * @param classPath
     * @return
     */
    public static boolean isClassExist(String classPath) {
        try {
            Class aClass = Class
                    .forName(classPath);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}