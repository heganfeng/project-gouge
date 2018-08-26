package com.gouge.interceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by grandfen on 17/7/20.
 */
public class ParameterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest.getCharacterEncoding() == null) {
            servletRequest.setCharacterEncoding("UTF-8");
        }
        HttpServletRequest hreq = (HttpServletRequest) servletRequest;
//        String uri = hreq.getRequestURI();
        String reqMethod = hreq.getMethod();
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        // 表明它允许"http://xxx"发起跨域请求
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
//        // 表明在xxx秒内，不需要再发送预检验请求，可以缓存该结果
        httpResponse.setHeader("Access-Control-Allow-Methods","POST, GET, DELETE, PUT");
//        // 表明它允许xxx的外域请求
        httpResponse.setHeader("Access-Control-Max-Age","3628800");
//        // 表明它允许跨域请求包含xxx头
        httpResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        if("POST".equals(reqMethod)){
            String uri = hreq.getRequestURI();
            if(uri.indexOf("/upload/upload") != -1){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(hreq);
                filterChain.doFilter(requestWrapper, servletResponse);
            }
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}