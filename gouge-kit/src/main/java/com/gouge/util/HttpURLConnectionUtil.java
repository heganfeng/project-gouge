/**
 * Created by Administrator on 2017/7/20.
 */
package com.gouge.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionUtil {
    // 通过get请求得到读取器响应数据的数据流
    public static void getImage(String url ,File file) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url)
                    .openConnection();
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = conn.getInputStream();

                BufferedInputStream bis = new BufferedInputStream(inputStream);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                    bos.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer [] getImageSize( File file){
        try {
            BufferedImage image  = ImageIO.read(file);
            return new Integer []{image.getWidth(),image.getHeight()};
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}