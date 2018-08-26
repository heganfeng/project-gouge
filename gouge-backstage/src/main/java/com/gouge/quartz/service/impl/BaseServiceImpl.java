package com.gouge.quartz.service.impl;

import com.gouge.dao.entity.TSysScheduleSet;
import com.gouge.dao.mapper.TSysScheduleSetMapper;
import com.gouge.quartz.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* create by grandfen
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private TSysScheduleSetMapper tSysScheduleSetMapper;

    @Override
    public int updateByPrimaryKey(TSysScheduleSet record) {
        return tSysScheduleSetMapper.updateByPrimaryKey(record);
    }
}
