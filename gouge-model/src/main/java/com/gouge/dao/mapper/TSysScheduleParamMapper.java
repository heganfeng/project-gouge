package com.gouge.dao.mapper;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.TSysScheduleParam;
import com.gouge.dao.entity.TSysScheduleParamExample;
import com.gouge.dao.entity.TSysScheduleParamKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface TSysScheduleParamMapper {
    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    int countByExample(TSysScheduleParamExample example);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    int deleteByExample(TSysScheduleParamExample example);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(TSysScheduleParamKey key);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    int insert(TSysScheduleParam record);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    int insertSelective(TSysScheduleParam record);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    List<TSysScheduleParam> selectByExample(TSysScheduleParamExample example);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    TSysScheduleParam selectByPrimaryKey(TSysScheduleParamKey key);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TSysScheduleParam record, @Param("example") TSysScheduleParamExample example);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TSysScheduleParam record, @Param("example") TSysScheduleParamExample example);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TSysScheduleParam record);

    /**
     * This method corresponds to the database table schedule_param
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TSysScheduleParam record);

    /**
     * 分页查询定时任务
     * @param params
     * @param rowBounds
     * @return
     */
    Page<TSysScheduleParam> queryByPage(Map<String, Object> params, RowBounds rowBounds);
}