package com.gouge.service.impl;

import com.gouge.dao.entity.TSysSync;
import com.gouge.dao.entity.TSysSyncImage;
import com.gouge.dao.mapper.TSysSyncImageMapper;
import com.gouge.dao.mapper.TSysSyncMapper;
import com.gouge.dao.mapperext.TSysSyncMapperExt;
import com.gouge.service.JsoupService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by grandfen on 17/7/20.
 */
@Service
public class JsoupServiceImpl implements JsoupService{

    private static final Logger logger = LogManager.getLogger(JsoupServiceImpl.class);

    @Autowired
    private TSysSyncMapper tSysSyncMapper;
    @Autowired
    private TSysSyncImageMapper tSysSyncImageMapper;
    @Autowired
    private TSysSyncMapperExt tSysSyncMapperExt;

    @Override
    public void selectUmei(String url,String chirdUrl) {
        try{
            Document document = Jsoup.connect(url+chirdUrl).post();
            Elements elements = document.getElementsByAttributeValue("class","TypeList").get(0).getElementsByClass("TypeBigPics");
            for ( int i = 0 ;i < elements.size();i++) {
                if(i > 15){
                    break;
                }
                Element element = elements.get(i);
                logger.info("处理{}",element.text());
                TSysSync qurerySync = tSysSyncMapperExt.getOneByTitle(element.text(),1);
                if (qurerySync == null){
                    TSysSync sysSync = new TSysSync();
                    String syncId = UUID.randomUUID().toString().replaceAll("-","");
                    sysSync.setRecId(syncId);
                    sysSync.setTitle(element.text());
                    sysSync.setCreateDate(new Date());
                    sysSync.setIsSync("1");
                    sysSync.setType(1);
                    tSysSyncMapper.insert(sysSync);
                    String pageUrl = element.attr("href").replace(url,"");
                    List<String> list = new ArrayList<>();
                    getUmeiImage(url,pageUrl,list);
                    saveImage(list, syncId);
                }else {
                    logger.info("{}已经存在取消执行！",element.text());
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void selectRank(int index,int page) {
        try{
            String baseUrl = "http://www.ttpaihang.com/";
            String url = baseUrl+"vote/rank.php?voteid=1089&page="+page;
            Document document = Jsoup.connect(url).userAgent("Mozilla").get();
            Document document1 = Jsoup.connect(baseUrl+"vote/"+document.getElementsByClass("main2_td").get(index-1).getElementsByTag("a").get(0).attr("href")).userAgent("Mozilla").get();
            Element bodyEl = document1.getElementsByAttributeValue("style","margin-top:5px;").get(0);
            String imgUrl = bodyEl.getElementsByTag("a").get(0).attr("href");
            String title = bodyEl.getElementsByTag("b").get(0).text();
            String text = bodyEl.getElementsByTag("div").get(1).text();
            Document document2 = Jsoup.connect(baseUrl+imgUrl).userAgent("Mozilla").get();
            Elements elements = document2.getElementById("eData").getElementsByTag("dl");
            List<String> urlList = new ArrayList<>();
            for (Element element : elements){
                urlList.add(baseUrl.substring(0,baseUrl.lastIndexOf("/"))+element.getElementsByTag("dd").get(0).text());
            }
            if(!CollectionUtils.isEmpty(urlList)){
                TSysSync qurerySync = tSysSyncMapperExt.getOneByTitle(title,2);
                if (qurerySync == null){
                    logger.info("处理{}",title);
                    TSysSync sysSync = new TSysSync();
                    String syncId = UUID.randomUUID().toString().replaceAll("-","");
                    sysSync.setRecId(syncId);
                    sysSync.setTitle(title);
                    sysSync.setTextContent(text);
                    sysSync.setCreateDate(new Date());
                    sysSync.setIsSync("1");
                    sysSync.setType(2);
                    tSysSyncMapper.insert(sysSync);
                    saveImage(urlList, syncId);
                }else{
                    logger.info("{}已经存在，取消保存！",title);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void saveImage(List<String> urlList, String syncId) {
        for (String imgurl : urlList){
            TSysSyncImage image = new TSysSyncImage();
            image.setRecId(UUID.randomUUID().toString().replaceAll("-",""));
            image.setPath(imgurl);
            image.setCreateDate(new Date());
            image.setSyncId(syncId);
            tSysSyncImageMapper.insert(image);
        }
    }

    private  void getUmeiImage(String url, String chirdUrl, List<String> imgList){
        try{
            Document document = Jsoup.connect(url+chirdUrl).post();
            String imgUrl = document.getElementsByClass("ImageBody").get(0).getElementsByTag("img").get(0).attr("src");
            imgList.add(imgUrl);
            Element element = document.getElementsByClass("NewPages").get(0).getElementsByTag("a").last();
            String nextHtml = element.attr("href");
            if (!nextHtml.equals("#")){
                getUmeiImage(url,nextHtml,imgList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
