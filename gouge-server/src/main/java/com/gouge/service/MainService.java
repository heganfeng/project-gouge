package com.gouge.service;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.TSysTroughPoint;
import com.gouge.dao.params.main.IndexParam;
import com.gouge.dao.vo.PointDetailInfoVo;

import java.util.List;

/**
 * Created by grandfen on 17/8/4.
 */
public interface MainService {

    List<TSysTroughPoint> getPointByCondition();

    Page<TSysTroughPoint> getPointByPage(IndexParam param);

    PointDetailInfoVo getDetailInfo(String id);
}
