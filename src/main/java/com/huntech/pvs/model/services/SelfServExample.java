package com.huntech.pvs.model.services;

import java.util.ArrayList;
import java.util.List;

public class SelfServExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelfServExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidIsNull() {
            addCriterion("BASE_SERVTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidIsNotNull() {
            addCriterion("BASE_SERVTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidEqualTo(Long value) {
            addCriterion("BASE_SERVTYPEID =", value, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidNotEqualTo(Long value) {
            addCriterion("BASE_SERVTYPEID <>", value, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidGreaterThan(Long value) {
            addCriterion("BASE_SERVTYPEID >", value, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("BASE_SERVTYPEID >=", value, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidLessThan(Long value) {
            addCriterion("BASE_SERVTYPEID <", value, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidLessThanOrEqualTo(Long value) {
            addCriterion("BASE_SERVTYPEID <=", value, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidIn(List<Long> values) {
            addCriterion("BASE_SERVTYPEID in", values, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidNotIn(List<Long> values) {
            addCriterion("BASE_SERVTYPEID not in", values, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidBetween(Long value1, Long value2) {
            addCriterion("BASE_SERVTYPEID between", value1, value2, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andBaseServtypeidNotBetween(Long value1, Long value2) {
            addCriterion("BASE_SERVTYPEID not between", value1, value2, "baseServtypeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidIsNull() {
            addCriterion("SERV_TIMEID is null");
            return (Criteria) this;
        }

        public Criteria andServTimeidIsNotNull() {
            addCriterion("SERV_TIMEID is not null");
            return (Criteria) this;
        }

        public Criteria andServTimeidEqualTo(Long value) {
            addCriterion("SERV_TIMEID =", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidNotEqualTo(Long value) {
            addCriterion("SERV_TIMEID <>", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidGreaterThan(Long value) {
            addCriterion("SERV_TIMEID >", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidGreaterThanOrEqualTo(Long value) {
            addCriterion("SERV_TIMEID >=", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidLessThan(Long value) {
            addCriterion("SERV_TIMEID <", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidLessThanOrEqualTo(Long value) {
            addCriterion("SERV_TIMEID <=", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidIn(List<Long> values) {
            addCriterion("SERV_TIMEID in", values, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidNotIn(List<Long> values) {
            addCriterion("SERV_TIMEID not in", values, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidBetween(Long value1, Long value2) {
            addCriterion("SERV_TIMEID between", value1, value2, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidNotBetween(Long value1, Long value2) {
            addCriterion("SERV_TIMEID not between", value1, value2, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServtypeIsNull() {
            addCriterion("SERVTYPE is null");
            return (Criteria) this;
        }

        public Criteria andServtypeIsNotNull() {
            addCriterion("SERVTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServtypeEqualTo(Byte value) {
            addCriterion("SERVTYPE =", value, "servtype");
            return (Criteria) this;
        }

        public Criteria andServtypeNotEqualTo(Byte value) {
            addCriterion("SERVTYPE <>", value, "servtype");
            return (Criteria) this;
        }

        public Criteria andServtypeGreaterThan(Byte value) {
            addCriterion("SERVTYPE >", value, "servtype");
            return (Criteria) this;
        }

        public Criteria andServtypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("SERVTYPE >=", value, "servtype");
            return (Criteria) this;
        }

        public Criteria andServtypeLessThan(Byte value) {
            addCriterion("SERVTYPE <", value, "servtype");
            return (Criteria) this;
        }

        public Criteria andServtypeLessThanOrEqualTo(Byte value) {
            addCriterion("SERVTYPE <=", value, "servtype");
            return (Criteria) this;
        }

        public Criteria andServtypeIn(List<Byte> values) {
            addCriterion("SERVTYPE in", values, "servtype");
            return (Criteria) this;
        }

        public Criteria andServtypeNotIn(List<Byte> values) {
            addCriterion("SERVTYPE not in", values, "servtype");
            return (Criteria) this;
        }

        public Criteria andServtypeBetween(Byte value1, Byte value2) {
            addCriterion("SERVTYPE between", value1, value2, "servtype");
            return (Criteria) this;
        }

        public Criteria andServtypeNotBetween(Byte value1, Byte value2) {
            addCriterion("SERVTYPE not between", value1, value2, "servtype");
            return (Criteria) this;
        }

        public Criteria andSelfServIsNull() {
            addCriterion("SELF_SERV is null");
            return (Criteria) this;
        }

        public Criteria andSelfServIsNotNull() {
            addCriterion("SELF_SERV is not null");
            return (Criteria) this;
        }

        public Criteria andSelfServEqualTo(String value) {
            addCriterion("SELF_SERV =", value, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServNotEqualTo(String value) {
            addCriterion("SELF_SERV <>", value, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServGreaterThan(String value) {
            addCriterion("SELF_SERV >", value, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServGreaterThanOrEqualTo(String value) {
            addCriterion("SELF_SERV >=", value, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServLessThan(String value) {
            addCriterion("SELF_SERV <", value, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServLessThanOrEqualTo(String value) {
            addCriterion("SELF_SERV <=", value, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServLike(String value) {
            addCriterion("SELF_SERV like", value, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServNotLike(String value) {
            addCriterion("SELF_SERV not like", value, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServIn(List<String> values) {
            addCriterion("SELF_SERV in", values, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServNotIn(List<String> values) {
            addCriterion("SELF_SERV not in", values, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServBetween(String value1, String value2) {
            addCriterion("SELF_SERV between", value1, value2, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSelfServNotBetween(String value1, String value2) {
            addCriterion("SELF_SERV not between", value1, value2, "selfServ");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("SNAME is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("SNAME is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("SNAME =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("SNAME <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("SNAME >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("SNAME >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("SNAME <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("SNAME <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("SNAME like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("SNAME not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("SNAME in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("SNAME not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("SNAME between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("SNAME not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andStelIsNull() {
            addCriterion("STEL is null");
            return (Criteria) this;
        }

        public Criteria andStelIsNotNull() {
            addCriterion("STEL is not null");
            return (Criteria) this;
        }

        public Criteria andStelEqualTo(String value) {
            addCriterion("STEL =", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelNotEqualTo(String value) {
            addCriterion("STEL <>", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelGreaterThan(String value) {
            addCriterion("STEL >", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelGreaterThanOrEqualTo(String value) {
            addCriterion("STEL >=", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelLessThan(String value) {
            addCriterion("STEL <", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelLessThanOrEqualTo(String value) {
            addCriterion("STEL <=", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelLike(String value) {
            addCriterion("STEL like", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelNotLike(String value) {
            addCriterion("STEL not like", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelIn(List<String> values) {
            addCriterion("STEL in", values, "stel");
            return (Criteria) this;
        }

        public Criteria andStelNotIn(List<String> values) {
            addCriterion("STEL not in", values, "stel");
            return (Criteria) this;
        }

        public Criteria andStelBetween(String value1, String value2) {
            addCriterion("STEL between", value1, value2, "stel");
            return (Criteria) this;
        }

        public Criteria andStelNotBetween(String value1, String value2) {
            addCriterion("STEL not between", value1, value2, "stel");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("OPENID is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("OPENID is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("OPENID =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("OPENID <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("OPENID >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("OPENID >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("OPENID <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("OPENID <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("OPENID like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("OPENID not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("OPENID in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("OPENID not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("OPENID between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("OPENID not between", value1, value2, "openid");
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