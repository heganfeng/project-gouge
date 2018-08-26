package com.gouge.controller.swing.upload;

import com.gouge.controller.BaseController;
import com.gouge.controller.login.LoginController;
import com.gouge.dao.entity.SwingMusic;
import com.gouge.dao.params.main.IdParam;
import com.gouge.kit.UUIDUtils;
import com.gouge.kit.josn.JsonResult;
import com.gouge.service.SwingMainService;
import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

/**
 * Created by Godden
 * Datetime : 2018/8/8 20:02.
 */
@Controller
@RequestMapping(value = "/apis/swing/v1/upload")
public class UploadSwingController extends BaseController{
    private static final Logger logger = LogManager.getLogger(UploadSwingController.class);

    @Value("${music.path}")
    private String musicPath;
    @Value("${static.domain.name}")
    private String domainName;
    @Value("${image.path}")
    private String imagePath;
    @Autowired
    private SwingMainService swingMainService;

    @RequestMapping(value = "/uploadMusic", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadMusic(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        authorizedLogin(request);
        long startTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddd");
        byte[] bytes= Base64.getDecoder().decode(file.getOriginalFilename().replaceAll("@","/"));
        String fileName = null;
        String newName = null;
        try {
            fileName = new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Converter v = new Converter();
        String houz = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        //新wav名字
        newName =(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())).concat(".wav");
        //wav目录路径
        String path = musicPath.concat("/").concat(getSwingLoginUser(request).getUserCode()).concat("/").concat("wav").concat("/")
                .concat(sdf.format(new Date()));
        //wav文件
        String filePath = path.concat("/").concat(newName);
        String mp3Path = null;
        File pathfile = new File(path);
        if(!pathfile.exists()){
            pathfile.mkdirs();
        }
        if(houz.toLowerCase().equals(".mp3")){
             mp3Path = musicPath.concat("/").concat(getSwingLoginUser(request).getUserCode())
                    .concat("/").concat(sdf.format(new Date()));
            try {
                File mp3file = new File(mp3Path);
                if(!mp3file.exists()){
                    mp3file.mkdirs();
                }
                file.transferTo(new File(mp3Path.concat("/").concat(fileName)));
                v.convert(mp3Path.concat("/").concat(fileName), filePath);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }

        }else{
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SwingMusic music = new SwingMusic();
        music.setId(UUIDUtils.generateUUID());
        music.setUserId(getSwingLoginUser(request).getId());
        music.setMusicName(fileName.substring(0,fileName.lastIndexOf(".")));
        music.setAbsolutePath(filePath);
        music.setAccessPath(domainName.concat("/music/").concat(getSwingLoginUser(request).getUserCode()).concat("/").concat("wav").concat("/")
                .concat(sdf.format(new Date())).concat("/").concat(newName));
        music.setCrtDate(new Date());
        music.setMusicType(houz);
        if(mp3Path != null)
            music.setReplacePath(mp3Path.concat("/").concat(fileName));

        int record = swingMainService.insertSwingMusic(music);
        long endTime = System.currentTimeMillis();
        logger.info("上传音乐文件：{} 共耗时{}ms",fileName,String.valueOf(endTime - startTime));
        return new JsonResult(record);
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> handleException(MaxUploadSizeExceededException ex) {
        logger.info("=====================" + ex.getClass().getName());
        return ResponseEntity.ok("ok");
    }


    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult uploadImage(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        authorizedLogin(request);
        long startTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddd");
        byte[] bytes= Base64.getDecoder().decode(file.getOriginalFilename().replaceAll("@","/"));
        String fileName = null;
        String newName = null;
        try {
            fileName = new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String houz = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        newName =(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())).concat(houz);
        String path = imagePath.concat("/").concat(getSwingLoginUser(request).getUserCode()).concat("/")
                .concat(sdf.format(new Date()));
        String filePath = path.concat("/").concat(newName);
        File pathfile = new File(path);
        if(!pathfile.exists()){
            pathfile.mkdirs();
        }
        try {
            File imgFile = new File(filePath);
            file.transferTo(imgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer bf = new StringBuffer(domainName);
        bf.append("/images/").append(getSwingLoginUser(request).getUserCode()).append("/")
                .append(sdf.format(new Date())).append("/").append(newName);
        long endTime = System.currentTimeMillis();
        logger.info("上传音乐文件：{} 共耗时{}ms",fileName,String.valueOf(endTime - startTime));
        return new JsonResult(bf.toString());
    }
}