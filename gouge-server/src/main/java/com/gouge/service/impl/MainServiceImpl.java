package com.gouge.service.impl;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.TSysAttachment;
import com.gouge.dao.entity.TSysTroughPoint;
import com.gouge.dao.mapper.TSysTroughPointMapper;
import com.gouge.dao.mapperext.TSysAttachmentMapperExt;
import com.gouge.dao.mapperext.TSysTroughPointMapperExt;
import com.gouge.dao.params.main.IndexParam;
import com.gouge.dao.vo.PointDetailInfoVo;
import com.gouge.exception.ApiException;
import com.gouge.service.MainService;
import com.gouge.util.ObjectUtil;
import com.gouge.util.PageUtil;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by grandfen on 17/8/4.
 */
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private TSysTroughPointMapperExt tSysTroughPointMapperExt;
    @Autowired
    private TSysTroughPointMapper tSysTroughPointMapper;
    @Autowired
    private TSysAttachmentMapperExt  tSysAttachmentMapperExt;

    @Override
    public List<TSysTroughPoint> getPointByCondition() {
        return tSysTroughPointMapperExt.getAll();
    }

    @Override
    public Page<TSysTroughPoint> getPointByPage(IndexParam param) {
        Integer pageNo = ObjectUtil.getPageNoIntValue(param, PageUtil.PAGE_INDEX_STR, PageUtil.DEFAUL_PAGE_NO);
        Integer pageSize = ObjectUtil.getIntValue(param, PageUtil.PAGE_SIZE_STR, PageUtil.DEFAUL_PAGE_SIZE);

        return tSysTroughPointMapperExt.getAllByPage(new RowBounds(pageNo,pageSize));
    }

    @Override
    public PointDetailInfoVo getDetailInfo(String id) {
        TSysTroughPoint point = tSysTroughPointMapper.selectByPrimaryKey(id);
        if(point == null){
            throw new ApiException("找不到对应对象！");
        }
        List<TSysAttachment> imgList =  tSysAttachmentMapperExt.getImgByPointId(id);
        PointDetailInfoVo vo = new PointDetailInfoVo();
        vo.setPoint(point);
        vo.setImgList(vo.getImgList());
        return vo;
    }
}
