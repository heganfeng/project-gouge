/*
 * Copyright(C) 2015-2016 kooniao
 * All rights reserved.
 * 2016-10-09 14:52:50 created by mybatis-generator
 */
package com.gouge.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSysScheduleSetExample {

	/**
	 * This field corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	protected String orderByClause;

	/**
	 * This field corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	protected boolean distinct;

	/**
	 * This field corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	public TSysScheduleSetExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method corresponds to the database table schedule_set
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
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method corresponds to the database table schedule_set
	 *
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class corresponds to the database table schedule_set
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

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
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

		public Criteria andJobGroupIsNull() {
			addCriterion("JOB_GROUP is null");
			return (Criteria) this;
		}

		public Criteria andJobGroupIsNotNull() {
			addCriterion("JOB_GROUP is not null");
			return (Criteria) this;
		}

		public Criteria andJobGroupEqualTo(String value) {
			addCriterion("JOB_GROUP =", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupNotEqualTo(String value) {
			addCriterion("JOB_GROUP <>", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupGreaterThan(String value) {
			addCriterion("JOB_GROUP >", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupGreaterThanOrEqualTo(String value) {
			addCriterion("JOB_GROUP >=", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupLessThan(String value) {
			addCriterion("JOB_GROUP <", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupLessThanOrEqualTo(String value) {
			addCriterion("JOB_GROUP <=", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupLike(String value) {
			addCriterion("JOB_GROUP like", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupNotLike(String value) {
			addCriterion("JOB_GROUP not like", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupIn(List<String> values) {
			addCriterion("JOB_GROUP in", values, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupNotIn(List<String> values) {
			addCriterion("JOB_GROUP not in", values, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupBetween(String value1, String value2) {
			addCriterion("JOB_GROUP between", value1, value2, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupNotBetween(String value1, String value2) {
			addCriterion("JOB_GROUP not between", value1, value2, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andClassImplIsNull() {
			addCriterion("CLASS_IMPL is null");
			return (Criteria) this;
		}

		public Criteria andClassImplIsNotNull() {
			addCriterion("CLASS_IMPL is not null");
			return (Criteria) this;
		}

		public Criteria andClassImplEqualTo(String value) {
			addCriterion("CLASS_IMPL =", value, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplNotEqualTo(String value) {
			addCriterion("CLASS_IMPL <>", value, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplGreaterThan(String value) {
			addCriterion("CLASS_IMPL >", value, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplGreaterThanOrEqualTo(String value) {
			addCriterion("CLASS_IMPL >=", value, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplLessThan(String value) {
			addCriterion("CLASS_IMPL <", value, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplLessThanOrEqualTo(String value) {
			addCriterion("CLASS_IMPL <=", value, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplLike(String value) {
			addCriterion("CLASS_IMPL like", value, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplNotLike(String value) {
			addCriterion("CLASS_IMPL not like", value, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplIn(List<String> values) {
			addCriterion("CLASS_IMPL in", values, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplNotIn(List<String> values) {
			addCriterion("CLASS_IMPL not in", values, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplBetween(String value1, String value2) {
			addCriterion("CLASS_IMPL between", value1, value2, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassImplNotBetween(String value1, String value2) {
			addCriterion("CLASS_IMPL not between", value1, value2, "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassMethodIsNull() {
			addCriterion("CLASS_METHOD is null");
			return (Criteria) this;
		}

		public Criteria andClassMethodIsNotNull() {
			addCriterion("CLASS_METHOD is not null");
			return (Criteria) this;
		}

		public Criteria andClassMethodEqualTo(String value) {
			addCriterion("CLASS_METHOD =", value, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodNotEqualTo(String value) {
			addCriterion("CLASS_METHOD <>", value, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodGreaterThan(String value) {
			addCriterion("CLASS_METHOD >", value, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodGreaterThanOrEqualTo(String value) {
			addCriterion("CLASS_METHOD >=", value, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodLessThan(String value) {
			addCriterion("CLASS_METHOD <", value, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodLessThanOrEqualTo(String value) {
			addCriterion("CLASS_METHOD <=", value, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodLike(String value) {
			addCriterion("CLASS_METHOD like", value, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodNotLike(String value) {
			addCriterion("CLASS_METHOD not like", value, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodIn(List<String> values) {
			addCriterion("CLASS_METHOD in", values, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodNotIn(List<String> values) {
			addCriterion("CLASS_METHOD not in", values, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodBetween(String value1, String value2) {
			addCriterion("CLASS_METHOD between", value1, value2, "classMethod");
			return (Criteria) this;
		}

		public Criteria andClassMethodNotBetween(String value1, String value2) {
			addCriterion("CLASS_METHOD not between", value1, value2, "classMethod");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(Byte value) {
			addCriterion("TYPE =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Byte value) {
			addCriterion("TYPE <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Byte value) {
			addCriterion("TYPE >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("TYPE >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Byte value) {
			addCriterion("TYPE <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Byte value) {
			addCriterion("TYPE <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Byte> values) {
			addCriterion("TYPE in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Byte> values) {
			addCriterion("TYPE not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Byte value1, Byte value2) {
			addCriterion("TYPE between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("TYPE not between", value1, value2, "type");
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

		public Criteria andCronIsNull() {
			addCriterion("CRON is null");
			return (Criteria) this;
		}

		public Criteria andCronIsNotNull() {
			addCriterion("CRON is not null");
			return (Criteria) this;
		}

		public Criteria andCronEqualTo(String value) {
			addCriterion("CRON =", value, "cron");
			return (Criteria) this;
		}

		public Criteria andCronNotEqualTo(String value) {
			addCriterion("CRON <>", value, "cron");
			return (Criteria) this;
		}

		public Criteria andCronGreaterThan(String value) {
			addCriterion("CRON >", value, "cron");
			return (Criteria) this;
		}

		public Criteria andCronGreaterThanOrEqualTo(String value) {
			addCriterion("CRON >=", value, "cron");
			return (Criteria) this;
		}

		public Criteria andCronLessThan(String value) {
			addCriterion("CRON <", value, "cron");
			return (Criteria) this;
		}

		public Criteria andCronLessThanOrEqualTo(String value) {
			addCriterion("CRON <=", value, "cron");
			return (Criteria) this;
		}

		public Criteria andCronLike(String value) {
			addCriterion("CRON like", value, "cron");
			return (Criteria) this;
		}

		public Criteria andCronNotLike(String value) {
			addCriterion("CRON not like", value, "cron");
			return (Criteria) this;
		}

		public Criteria andCronIn(List<String> values) {
			addCriterion("CRON in", values, "cron");
			return (Criteria) this;
		}

		public Criteria andCronNotIn(List<String> values) {
			addCriterion("CRON not in", values, "cron");
			return (Criteria) this;
		}

		public Criteria andCronBetween(String value1, String value2) {
			addCriterion("CRON between", value1, value2, "cron");
			return (Criteria) this;
		}

		public Criteria andCronNotBetween(String value1, String value2) {
			addCriterion("CRON not between", value1, value2, "cron");
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

		public Criteria andLastStatusIsNull() {
			addCriterion("LAST_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andLastStatusIsNotNull() {
			addCriterion("LAST_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andLastStatusEqualTo(Byte value) {
			addCriterion("LAST_STATUS =", value, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastStatusNotEqualTo(Byte value) {
			addCriterion("LAST_STATUS <>", value, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastStatusGreaterThan(Byte value) {
			addCriterion("LAST_STATUS >", value, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastStatusGreaterThanOrEqualTo(Byte value) {
			addCriterion("LAST_STATUS >=", value, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastStatusLessThan(Byte value) {
			addCriterion("LAST_STATUS <", value, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastStatusLessThanOrEqualTo(Byte value) {
			addCriterion("LAST_STATUS <=", value, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastStatusIn(List<Byte> values) {
			addCriterion("LAST_STATUS in", values, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastStatusNotIn(List<Byte> values) {
			addCriterion("LAST_STATUS not in", values, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastStatusBetween(Byte value1, Byte value2) {
			addCriterion("LAST_STATUS between", value1, value2, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastStatusNotBetween(Byte value1, Byte value2) {
			addCriterion("LAST_STATUS not between", value1, value2, "lastStatus");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeIsNull() {
			addCriterion("LAST_DEAL_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeIsNotNull() {
			addCriterion("LAST_DEAL_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeEqualTo(Date value) {
			addCriterion("LAST_DEAL_TIME =", value, "lastDealTime");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeNotEqualTo(Date value) {
			addCriterion("LAST_DEAL_TIME <>", value, "lastDealTime");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeGreaterThan(Date value) {
			addCriterion("LAST_DEAL_TIME >", value, "lastDealTime");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LAST_DEAL_TIME >=", value, "lastDealTime");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeLessThan(Date value) {
			addCriterion("LAST_DEAL_TIME <", value, "lastDealTime");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeLessThanOrEqualTo(Date value) {
			addCriterion("LAST_DEAL_TIME <=", value, "lastDealTime");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeIn(List<Date> values) {
			addCriterion("LAST_DEAL_TIME in", values, "lastDealTime");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeNotIn(List<Date> values) {
			addCriterion("LAST_DEAL_TIME not in", values, "lastDealTime");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeBetween(Date value1, Date value2) {
			addCriterion("LAST_DEAL_TIME between", value1, value2, "lastDealTime");
			return (Criteria) this;
		}

		public Criteria andLastDealTimeNotBetween(Date value1, Date value2) {
			addCriterion("LAST_DEAL_TIME not between", value1, value2, "lastDealTime");
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

		public Criteria andNameLikeInsensitive(String value) {
			addCriterion("upper(NAME) like", value.toUpperCase(), "name");
			return (Criteria) this;
		}

		public Criteria andJobGroupLikeInsensitive(String value) {
			addCriterion("upper(JOB_GROUP) like", value.toUpperCase(), "jobGroup");
			return (Criteria) this;
		}

		public Criteria andClassImplLikeInsensitive(String value) {
			addCriterion("upper(CLASS_IMPL) like", value.toUpperCase(), "classImpl");
			return (Criteria) this;
		}

		public Criteria andClassMethodLikeInsensitive(String value) {
			addCriterion("upper(CLASS_METHOD) like", value.toUpperCase(), "classMethod");
			return (Criteria) this;
		}

		public Criteria andCommentLikeInsensitive(String value) {
			addCriterion("upper(COMMENT) like", value.toUpperCase(), "comment");
			return (Criteria) this;
		}

		public Criteria andCronLikeInsensitive(String value) {
			addCriterion("upper(CRON) like", value.toUpperCase(), "cron");
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
	 * This class corresponds to the database table schedule_set
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
	 * This class corresponds to the database table schedule_set
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