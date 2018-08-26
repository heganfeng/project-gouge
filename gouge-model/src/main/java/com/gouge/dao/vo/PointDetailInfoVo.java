package com.gouge.dao.vo;

import com.gouge.dao.entity.TSysAttachment;
import com.gouge.dao.entity.TSysTroughPoint;

import java.util.List;

/**
 * Created by Administrator on 2017/8/6.
 */
public class PointDetailInfoVo {
    private TSysTroughPoint point;

    private List<TSysAttachment> imgList;


    public TSysTroughPoint getPoint() {
        return point;
    }

    public void setPoint(TSysTroughPoint point) {
        this.point = point;
    }

    public List<TSysAttachment> getImgList() {
        return imgList;
    }

    public void setImgList(List<TSysAttachment> imgList) {
        this.imgList = imgList;
    }
}
