/*
 * Copyright(C) 2015-2016 kooniao
 * All rights reserved.
 * 2016-10-09 14:53:09 created by mybatis-generator
 */
package com.gouge.dao.entity;

import java.io.Serializable;

public class TSysScheduleParamKey implements Serializable {

	/**
	 * This field corresponds to the database column schedule_param.JOB_ID
	 * Remarks: 任务ID
	 *
	 * @mbggenerated
	 */
	private Integer jobId;

	/**
	 * This field corresponds to the database column schedule_param.PARAM_KEY
	 * Remarks: 参数key值
	 *
	 * @mbggenerated
	 */
	private String paramKey;

	/**
	 * This field corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey == null ? null : paramKey.trim();
	}
}