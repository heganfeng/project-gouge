package com.gouge.dao.mapper;

import com.github.pagehelper.Page;
import com.gouge.dao.entity.TSysScheduleSet;
import com.gouge.dao.entity.TSysScheduleSetExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface TSysScheduleSetMapper {
    //更新job执行状态: 1-运行中；2-停止；3失败
    int updateJobStatus(@Param("status") int status, @Param("jobId") int jobId);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    int countByExample(TSysScheduleSetExample example);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    int deleteByExample(TSysScheduleSetExample example);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    int insert(TSysScheduleSet record);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    int insertSelective(TSysScheduleSet record);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    List<TSysScheduleSet> selectByExample(TSysScheduleSetExample example);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    TSysScheduleSet selectByPrimaryKey(Integer id);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") TSysScheduleSet record, @Param("example") TSysScheduleSetExample example);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") TSysScheduleSet record, @Param("example") TSysScheduleSetExample example);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TSysScheduleSet record);

    /**
     * This method corresponds to the database table schedule_set
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(TSysScheduleSet record);

    /**
     * 分页查询定时任务
     * @param params
     * @param rowBounds
     * @return
     */
    Page<TSysScheduleSet> queryByPage(Map<String, Object> params, RowBounds rowBounds);
}