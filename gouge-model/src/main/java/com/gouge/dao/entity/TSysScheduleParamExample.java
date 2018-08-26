/*
 * Copyright(C) 2015-2016 kooniao
 * All rights reserved.
 * 2016-10-09 14:53:09 created by mybatis-generator
 */
package com.gouge.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSysScheduleParamExample {

	/**
	 * This field corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	protected String orderByClause;

	/**
	 * This field corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	protected boolean distinct;

	/**
	 * This field corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public TSysScheduleParamExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method corresponds to the database table schedule_param
	 *
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class corresponds to the database table schedule_param
	 * Remarks: 
	 *
	 * @mbggenerated
	 */
	protected abstract static class GeneratedCriteria {

		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andJobIdIsNull() {
			addCriterion("JOB_ID is null");
			return (Criteria) this;
		}

		public Criteria andJobIdIsNotNull() {
			addCriterion("JOB_ID is not null");
			return (Criteria) this;
		}

		public Criteria andJobIdEqualTo(Integer value) {
			addCriterion("JOB_ID =", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotEqualTo(Integer value) {
			addCriterion("JOB_ID <>", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdGreaterThan(Integer value) {
			addCriterion("JOB_ID >", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("JOB_ID >=", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdLessThan(Integer value) {
			addCriterion("JOB_ID <", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdLessThanOrEqualTo(Integer value) {
			addCriterion("JOB_ID <=", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdIn(List<Integer> values) {
			addCriterion("JOB_ID in", values, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotIn(List<Integer> values) {
			addCriterion("JOB_ID not in", values, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdBetween(Integer value1, Integer value2) {
			addCriterion("JOB_ID between", value1, value2, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotBetween(Integer value1, Integer value2) {
			addCriterion("JOB_ID not between", value1, value2, "jobId");
			return (Criteria) this;
		}

		public Criteria andParamKeyIsNull() {
			addCriterion("PARAM_KEY is null");
			return (Criteria) this;
		}

		public Criteria andParamKeyIsNotNull() {
			addCriterion("PARAM_KEY is not null");
			return (Criteria) this;
		}

		public Criteria andParamKeyEqualTo(String value) {
			addCriterion("PARAM_KEY =", value, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyNotEqualTo(String value) {
			addCriterion("PARAM_KEY <>", value, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyGreaterThan(String value) {
			addCriterion("PARAM_KEY >", value, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_KEY >=", value, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyLessThan(String value) {
			addCriterion("PARAM_KEY <", value, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyLessThanOrEqualTo(String value) {
			addCriterion("PARAM_KEY <=", value, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyLike(String value) {
			addCriterion("PARAM_KEY like", value, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyNotLike(String value) {
			addCriterion("PARAM_KEY not like", value, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyIn(List<String> values) {
			addCriterion("PARAM_KEY in", values, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyNotIn(List<String> values) {
			addCriterion("PARAM_KEY not in", values, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyBetween(String value1, String value2) {
			addCriterion("PARAM_KEY between", value1, value2, "paramKey");
			return (Criteria) this;
		}

		public Criteria andParamKeyNotBetween(String value1, String value2) {
			addCriterion("PARAM_KEY not between", value1, value2, "paramKey");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andCommentIsNull() {
			addCriterion("COMMENT is null");
			return (Criteria) this;
		}

		public Criteria andCommentIsNotNull() {
			addCriterion("COMMENT is not null");
			return (Criteria) this;
		}

		public Criteria andCommentEqualTo(String value) {
			addCriterion("COMMENT =", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentNotEqualTo(String value) {
			addCriterion("COMMENT <>", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentGreaterThan(String value) {
			addCriterion("COMMENT >", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentGreaterThanOrEqualTo(String value) {
			addCriterion("COMMENT >=", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentLessThan(String value) {
			addCriterion("COMMENT <", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentLessThanOrEqualTo(String value) {
			addCriterion("COMMENT <=", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentLike(String value) {
			addCriterion("COMMENT like", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentNotLike(String value) {
			addCriterion("COMMENT not like", value, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentIn(List<String> values) {
			addCriterion("COMMENT in", values, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentNotIn(List<String> values) {
			addCriterion("COMMENT not in", values, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentBetween(String value1, String value2) {
			addCriterion("COMMENT between", value1, value2, "comment");
			return (Criteria) this;
		}

		public Criteria andCommentNotBetween(String value1, String value2) {
			addCriterion("COMMENT not between", value1, value2, "comment");
			return (Criteria) this;
		}

		public Criteria andParamValueIsNull() {
			addCriterion("PARAM_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andParamValueIsNotNull() {
			addCriterion("PARAM_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andParamValueEqualTo(String value) {
			addCriterion("PARAM_VALUE =", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotEqualTo(String value) {
			addCriterion("PARAM_VALUE <>", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueGreaterThan(String value) {
			addCriterion("PARAM_VALUE >", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_VALUE >=", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueLessThan(String value) {
			addCriterion("PARAM_VALUE <", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueLessThanOrEqualTo(String value) {
			addCriterion("PARAM_VALUE <=", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueLike(String value) {
			addCriterion("PARAM_VALUE like", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotLike(String value) {
			addCriterion("PARAM_VALUE not like", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueIn(List<String> values) {
			addCriterion("PARAM_VALUE in", values, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotIn(List<String> values) {
			addCriterion("PARAM_VALUE not in", values, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueBetween(String value1, String value2) {
			addCriterion("PARAM_VALUE between", value1, value2, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotBetween(String value1, String value2) {
			addCriterion("PARAM_VALUE not between", value1, value2, "paramValue");
			return (Criteria) this;
		}

		public Criteria andEnabledIsNull() {
			addCriterion("ENABLED is null");
			return (Criteria) this;
		}

		public Criteria andEnabledIsNotNull() {
			addCriterion("ENABLED is not null");
			return (Criteria) this;
		}

		public Criteria andEnabledEqualTo(Byte value) {
			addCriterion("ENABLED =", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledNotEqualTo(Byte value) {
			addCriterion("ENABLED <>", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledGreaterThan(Byte value) {
			addCriterion("ENABLED >", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledGreaterThanOrEqualTo(Byte value) {
			addCriterion("ENABLED >=", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledLessThan(Byte value) {
			addCriterion("ENABLED <", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledLessThanOrEqualTo(Byte value) {
			addCriterion("ENABLED <=", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledIn(List<Byte> values) {
			addCriterion("ENABLED in", values, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledNotIn(List<Byte> values) {
			addCriterion("ENABLED not in", values, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledBetween(Byte value1, Byte value2) {
			addCriterion("ENABLED between", value1, value2, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledNotBetween(Byte value1, Byte value2) {
			addCriterion("ENABLED not between", value1, value2, "enabled");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("REMARK is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("REMARK =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("REMARK <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("REMARK >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("REMARK >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("REMARK <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("REMARK <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("REMARK like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("REMARK not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("REMARK in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("REMARK not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("REMARK between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("REMARK not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andCreatorIsNull() {
			addCriterion("CREATOR is null");
			return (Criteria) this;
		}

		public Criteria andCreatorIsNotNull() {
			addCriterion("CREATOR is not null");
			return (Criteria) this;
		}

		public Criteria andCreatorEqualTo(String value) {
			addCriterion("CREATOR =", value, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorNotEqualTo(String value) {
			addCriterion("CREATOR <>", value, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorGreaterThan(String value) {
			addCriterion("CREATOR >", value, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorGreaterThanOrEqualTo(String value) {
			addCriterion("CREATOR >=", value, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorLessThan(String value) {
			addCriterion("CREATOR <", value, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorLessThanOrEqualTo(String value) {
			addCriterion("CREATOR <=", value, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorLike(String value) {
			addCriterion("CREATOR like", value, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorNotLike(String value) {
			addCriterion("CREATOR not like", value, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorIn(List<String> values) {
			addCriterion("CREATOR in", values, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorNotIn(List<String> values) {
			addCriterion("CREATOR not in", values, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorBetween(String value1, String value2) {
			addCriterion("CREATOR between", value1, value2, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatorNotBetween(String value1, String value2) {
			addCriterion("CREATOR not between", value1, value2, "creator");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNull() {
			addCriterion("CREATED_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIsNotNull() {
			addCriterion("CREATED_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeEqualTo(Date value) {
			addCriterion("CREATED_TIME =", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotEqualTo(Date value) {
			addCriterion("CREATED_TIME <>", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThan(Date value) {
			addCriterion("CREATED_TIME >", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATED_TIME >=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThan(Date value) {
			addCriterion("CREATED_TIME <", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATED_TIME <=", value, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeIn(List<Date> values) {
			addCriterion("CREATED_TIME in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotIn(List<Date> values) {
			addCriterion("CREATED_TIME not in", values, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeBetween(Date value1, Date value2) {
			addCriterion("CREATED_TIME between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATED_TIME not between", value1, value2, "createdTime");
			return (Criteria) this;
		}

		public Criteria andReviserIsNull() {
			addCriterion("REVISER is null");
			return (Criteria) this;
		}

		public Criteria andReviserIsNotNull() {
			addCriterion("REVISER is not null");
			return (Criteria) this;
		}

		public Criteria andReviserEqualTo(String value) {
			addCriterion("REVISER =", value, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserNotEqualTo(String value) {
			addCriterion("REVISER <>", value, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserGreaterThan(String value) {
			addCriterion("REVISER >", value, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserGreaterThanOrEqualTo(String value) {
			addCriterion("REVISER >=", value, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserLessThan(String value) {
			addCriterion("REVISER <", value, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserLessThanOrEqualTo(String value) {
			addCriterion("REVISER <=", value, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserLike(String value) {
			addCriterion("REVISER like", value, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserNotLike(String value) {
			addCriterion("REVISER not like", value, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserIn(List<String> values) {
			addCriterion("REVISER in", values, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserNotIn(List<String> values) {
			addCriterion("REVISER not in", values, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserBetween(String value1, String value2) {
			addCriterion("REVISER between", value1, value2, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviserNotBetween(String value1, String value2) {
			addCriterion("REVISER not between", value1, value2, "reviser");
			return (Criteria) this;
		}

		public Criteria andReviseTimeIsNull() {
			addCriterion("REVISE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andReviseTimeIsNotNull() {
			addCriterion("REVISE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andReviseTimeEqualTo(Date value) {
			addCriterion("REVISE_TIME =", value, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andReviseTimeNotEqualTo(Date value) {
			addCriterion("REVISE_TIME <>", value, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andReviseTimeGreaterThan(Date value) {
			addCriterion("REVISE_TIME >", value, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andReviseTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("REVISE_TIME >=", value, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andReviseTimeLessThan(Date value) {
			addCriterion("REVISE_TIME <", value, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andReviseTimeLessThanOrEqualTo(Date value) {
			addCriterion("REVISE_TIME <=", value, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andReviseTimeIn(List<Date> values) {
			addCriterion("REVISE_TIME in", values, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andReviseTimeNotIn(List<Date> values) {
			addCriterion("REVISE_TIME not in", values, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andReviseTimeBetween(Date value1, Date value2) {
			addCriterion("REVISE_TIME between", value1, value2, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andReviseTimeNotBetween(Date value1, Date value2) {
			addCriterion("REVISE_TIME not between", value1, value2, "reviseTime");
			return (Criteria) this;
		}

		public Criteria andParamKeyLikeInsensitive(String value) {
			addCriterion("upper(PARAM_KEY) like", value.toUpperCase(), "paramKey");
			return (Criteria) this;
		}

		public Criteria andNameLikeInsensitive(String value) {
			addCriterion("upper(NAME) like", value.toUpperCase(), "name");
			return (Criteria) this;
		}

		public Criteria andCommentLikeInsensitive(String value) {
			addCriterion("upper(COMMENT) like", value.toUpperCase(), "comment");
			return (Criteria) this;
		}

		public Criteria andParamValueLikeInsensitive(String value) {
			addCriterion("upper(PARAM_VALUE) like", value.toUpperCase(), "paramValue");
			return (Criteria) this;
		}

		public Criteria andRemarkLikeInsensitive(String value) {
			addCriterion("upper(REMARK) like", value.toUpperCase(), "remark");
			return (Criteria) this;
		}

		public Criteria andCreatorLikeInsensitive(String value) {
			addCriterion("upper(CREATOR) like", value.toUpperCase(), "creator");
			return (Criteria) this;
		}

		public Criteria andReviserLikeInsensitive(String value) {
			addCriterion("upper(REVISER) like", value.toUpperCase(), "reviser");
			return (Criteria) this;
		}
	}

	/**
	 * This class corresponds to the database table schedule_param
	 * Remarks: 
	 *
	 * @mbggenerated do_not_delete_during_merge
	 */
	public static class Criteria extends GeneratedCriteria {


		protected Criteria() {
			super();
		}
	}

	/**
	 * This class corresponds to the database table schedule_param
	 * Remarks: 
	 *
	 * @mbggenerated
	 */
	public static class Criterion {

		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}