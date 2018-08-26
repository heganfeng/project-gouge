package com.gouge.interceptor;

import com.gouge.util.CharsetUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * Created by grandfen on 17/4/26.
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

    protected Logger log = LogManager.getLogger(BodyReaderHttpServletRequestWrapper.class);

    private  byte[] body;

    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        body = getBodyString(request).getBytes(Charset.forName(CharsetUtil.UTF8));
        try{
            log.warn("响应WEB:{},请求ip: {},uri = {},params = {},header = {}",
                    request.getServerName(),
                    request.getRemoteAddr(),
                    request.getRequestURI(),
                    new String(body,CharsetUtil.UTF8),
                    getHeader(request));
        }catch (Exception e){
           e.printStackTrace();
        }
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }


    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);

        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    private String getBodyString(ServletRequest request) {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = request.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(CharsetUtil.UTF8)));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            log.error("读取request请求中的body数据出错", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("关闭request请求中的输入流出错", e);
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    log.error("关闭request请求中的输入流的包装流BufferedReader出错", e);
                }
            }
        }
        return sb.toString();
    }

    private String getHeader(HttpServletRequest request){
        StringBuilder str = new StringBuilder();
        Enumeration<String> e = request.getHeaderNames();
        while (e.hasMoreElements()){
            String key = e.nextElement();
            str.append(key).append(":").append(request.getHeader(key)).append("||");
        }
        return str.toString();
    }
}
