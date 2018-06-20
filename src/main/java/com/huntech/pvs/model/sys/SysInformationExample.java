package com.huntech.pvs.model.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysInformationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andSidIsNull() {
            addCriterion("SID is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("SID is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Long value) {
            addCriterion("SID =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Long value) {
            addCriterion("SID <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Long value) {
            addCriterion("SID >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Long value) {
            addCriterion("SID >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Long value) {
            addCriterion("SID <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Long value) {
            addCriterion("SID <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Long> values) {
            addCriterion("SID in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Long> values) {
            addCriterion("SID not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Long value1, Long value2) {
            addCriterion("SID between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Long value1, Long value2) {
            addCriterion("SID not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("CREATED_BY like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("CREATED_BY not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNull() {
            addCriterion("CREATED_DT is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNotNull() {
            addCriterion("CREATED_DT is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtEqualTo(Date value) {
            addCriterion("CREATED_DT =", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotEqualTo(Date value) {
            addCriterion("CREATED_DT <>", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThan(Date value) {
            addCriterion("CREATED_DT >", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DT >=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThan(Date value) {
            addCriterion("CREATED_DT <", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DT <=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIn(List<Date> values) {
            addCriterion("CREATED_DT in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotIn(List<Date> values) {
            addCriterion("CREATED_DT not in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtBetween(Date value1, Date value2) {
            addCriterion("CREATED_DT between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DT not between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("UPDATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("UPDATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("UPDATED_BY =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("UPDATED_BY <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("UPDATED_BY >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("UPDATED_BY <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("UPDATED_BY like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("UPDATED_BY not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("UPDATED_BY in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("UPDATED_BY not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("UPDATED_BY between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("UPDATED_BY not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtIsNull() {
            addCriterion("UPDATED_DT is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtIsNotNull() {
            addCriterion("UPDATED_DT is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtEqualTo(Date value) {
            addCriterion("UPDATED_DT =", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtNotEqualTo(Date value) {
            addCriterion("UPDATED_DT <>", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtGreaterThan(Date value) {
            addCriterion("UPDATED_DT >", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATED_DT >=", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtLessThan(Date value) {
            addCriterion("UPDATED_DT <", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtLessThanOrEqualTo(Date value) {
            addCriterion("UPDATED_DT <=", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtIn(List<Date> values) {
            addCriterion("UPDATED_DT in", values, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtNotIn(List<Date> values) {
            addCriterion("UPDATED_DT not in", values, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtBetween(Date value1, Date value2) {
            addCriterion("UPDATED_DT between", value1, value2, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtNotBetween(Date value1, Date value2) {
            addCriterion("UPDATED_DT not between", value1, value2, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andInfoNameIsNull() {
            addCriterion("INFO_NAME is null");
            return (Criteria) this;
        }

        public Criteria andInfoNameIsNotNull() {
            addCriterion("INFO_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andInfoNameEqualTo(String value) {
            addCriterion("INFO_NAME =", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotEqualTo(String value) {
            addCriterion("INFO_NAME <>", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameGreaterThan(String value) {
            addCriterion("INFO_NAME >", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_NAME >=", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameLessThan(String value) {
            addCriterion("INFO_NAME <", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameLessThanOrEqualTo(String value) {
            addCriterion("INFO_NAME <=", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameLike(String value) {
            addCriterion("INFO_NAME like", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotLike(String value) {
            addCriterion("INFO_NAME not like", value, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameIn(List<String> values) {
            addCriterion("INFO_NAME in", values, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotIn(List<String> values) {
            addCriterion("INFO_NAME not in", values, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameBetween(String value1, String value2) {
            addCriterion("INFO_NAME between", value1, value2, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoNameNotBetween(String value1, String value2) {
            addCriterion("INFO_NAME not between", value1, value2, "infoName");
            return (Criteria) this;
        }

        public Criteria andInfoSignIsNull() {
            addCriterion("INFO_SIGN is null");
            return (Criteria) this;
        }

        public Criteria andInfoSignIsNotNull() {
            addCriterion("INFO_SIGN is not null");
            return (Criteria) this;
        }

        public Criteria andInfoSignEqualTo(String value) {
            addCriterion("INFO_SIGN =", value, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignNotEqualTo(String value) {
            addCriterion("INFO_SIGN <>", value, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignGreaterThan(String value) {
            addCriterion("INFO_SIGN >", value, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_SIGN >=", value, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignLessThan(String value) {
            addCriterion("INFO_SIGN <", value, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignLessThanOrEqualTo(String value) {
            addCriterion("INFO_SIGN <=", value, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignLike(String value) {
            addCriterion("INFO_SIGN like", value, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignNotLike(String value) {
            addCriterion("INFO_SIGN not like", value, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignIn(List<String> values) {
            addCriterion("INFO_SIGN in", values, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignNotIn(List<String> values) {
            addCriterion("INFO_SIGN not in", values, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignBetween(String value1, String value2) {
            addCriterion("INFO_SIGN between", value1, value2, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoSignNotBetween(String value1, String value2) {
            addCriterion("INFO_SIGN not between", value1, value2, "infoSign");
            return (Criteria) this;
        }

        public Criteria andInfoValueIsNull() {
            addCriterion("INFO_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andInfoValueIsNotNull() {
            addCriterion("INFO_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andInfoValueEqualTo(String value) {
            addCriterion("INFO_VALUE =", value, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueNotEqualTo(String value) {
            addCriterion("INFO_VALUE <>", value, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueGreaterThan(String value) {
            addCriterion("INFO_VALUE >", value, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueGreaterThanOrEqualTo(String value) {
            addCriterion("INFO_VALUE >=", value, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueLessThan(String value) {
            addCriterion("INFO_VALUE <", value, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueLessThanOrEqualTo(String value) {
            addCriterion("INFO_VALUE <=", value, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueLike(String value) {
            addCriterion("INFO_VALUE like", value, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueNotLike(String value) {
            addCriterion("INFO_VALUE not like", value, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueIn(List<String> values) {
            addCriterion("INFO_VALUE in", values, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueNotIn(List<String> values) {
            addCriterion("INFO_VALUE not in", values, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueBetween(String value1, String value2) {
            addCriterion("INFO_VALUE between", value1, value2, "infoValue");
            return (Criteria) this;
        }

        public Criteria andInfoValueNotBetween(String value1, String value2) {
            addCriterion("INFO_VALUE not between", value1, value2, "infoValue");
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

        public Criteria andEnabledEqualTo(String value) {
            addCriterion("ENABLED =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(String value) {
            addCriterion("ENABLED <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(String value) {
            addCriterion("ENABLED >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(String value) {
            addCriterion("ENABLED >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(String value) {
            addCriterion("ENABLED <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(String value) {
            addCriterion("ENABLED <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLike(String value) {
            addCriterion("ENABLED like", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotLike(String value) {
            addCriterion("ENABLED not like", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<String> values) {
            addCriterion("ENABLED in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<String> values) {
            addCriterion("ENABLED not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(String value1, String value2) {
            addCriterion("ENABLED between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(String value1, String value2) {
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
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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