package com.huntech.pvs.model.services;

import java.util.ArrayList;
import java.util.List;

public class ServExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServExample() {
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

        public Criteria andServTypeIsNull() {
            addCriterion("SERV_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andServTypeIsNotNull() {
            addCriterion("SERV_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andServTypeEqualTo(String value) {
            addCriterion("SERV_TYPE =", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotEqualTo(String value) {
            addCriterion("SERV_TYPE <>", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeGreaterThan(String value) {
            addCriterion("SERV_TYPE >", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_TYPE >=", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeLessThan(String value) {
            addCriterion("SERV_TYPE <", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeLessThanOrEqualTo(String value) {
            addCriterion("SERV_TYPE <=", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeLike(String value) {
            addCriterion("SERV_TYPE like", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotLike(String value) {
            addCriterion("SERV_TYPE not like", value, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeIn(List<String> values) {
            addCriterion("SERV_TYPE in", values, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotIn(List<String> values) {
            addCriterion("SERV_TYPE not in", values, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeBetween(String value1, String value2) {
            addCriterion("SERV_TYPE between", value1, value2, "servType");
            return (Criteria) this;
        }

        public Criteria andServTypeNotBetween(String value1, String value2) {
            addCriterion("SERV_TYPE not between", value1, value2, "servType");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidIsNull() {
            addCriterion("BASESERV_TYPEID is null");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidIsNotNull() {
            addCriterion("BASESERV_TYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidEqualTo(Long value) {
            addCriterion("BASESERV_TYPEID =", value, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidNotEqualTo(Long value) {
            addCriterion("BASESERV_TYPEID <>", value, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidGreaterThan(Long value) {
            addCriterion("BASESERV_TYPEID >", value, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("BASESERV_TYPEID >=", value, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidLessThan(Long value) {
            addCriterion("BASESERV_TYPEID <", value, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidLessThanOrEqualTo(Long value) {
            addCriterion("BASESERV_TYPEID <=", value, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidIn(List<Long> values) {
            addCriterion("BASESERV_TYPEID in", values, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidNotIn(List<Long> values) {
            addCriterion("BASESERV_TYPEID not in", values, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidBetween(Long value1, Long value2) {
            addCriterion("BASESERV_TYPEID between", value1, value2, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andBaseservTypeidNotBetween(Long value1, Long value2) {
            addCriterion("BASESERV_TYPEID not between", value1, value2, "baseservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidIsNull() {
            addCriterion("SELFSERV_TYPEID is null");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidIsNotNull() {
            addCriterion("SELFSERV_TYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidEqualTo(Long value) {
            addCriterion("SELFSERV_TYPEID =", value, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidNotEqualTo(Long value) {
            addCriterion("SELFSERV_TYPEID <>", value, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidGreaterThan(Long value) {
            addCriterion("SELFSERV_TYPEID >", value, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("SELFSERV_TYPEID >=", value, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidLessThan(Long value) {
            addCriterion("SELFSERV_TYPEID <", value, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidLessThanOrEqualTo(Long value) {
            addCriterion("SELFSERV_TYPEID <=", value, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidIn(List<Long> values) {
            addCriterion("SELFSERV_TYPEID in", values, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidNotIn(List<Long> values) {
            addCriterion("SELFSERV_TYPEID not in", values, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidBetween(Long value1, Long value2) {
            addCriterion("SELFSERV_TYPEID between", value1, value2, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andSelfservTypeidNotBetween(Long value1, Long value2) {
            addCriterion("SELFSERV_TYPEID not between", value1, value2, "selfservTypeid");
            return (Criteria) this;
        }

        public Criteria andServManidIsNull() {
            addCriterion("SERV_MANID is null");
            return (Criteria) this;
        }

        public Criteria andServManidIsNotNull() {
            addCriterion("SERV_MANID is not null");
            return (Criteria) this;
        }

        public Criteria andServManidEqualTo(Long value) {
            addCriterion("SERV_MANID =", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidNotEqualTo(Long value) {
            addCriterion("SERV_MANID <>", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidGreaterThan(Long value) {
            addCriterion("SERV_MANID >", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidGreaterThanOrEqualTo(Long value) {
            addCriterion("SERV_MANID >=", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidLessThan(Long value) {
            addCriterion("SERV_MANID <", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidLessThanOrEqualTo(Long value) {
            addCriterion("SERV_MANID <=", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidIn(List<Long> values) {
            addCriterion("SERV_MANID in", values, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidNotIn(List<Long> values) {
            addCriterion("SERV_MANID not in", values, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidBetween(Long value1, Long value2) {
            addCriterion("SERV_MANID between", value1, value2, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidNotBetween(Long value1, Long value2) {
            addCriterion("SERV_MANID not between", value1, value2, "servManid");
            return (Criteria) this;
        }

        public Criteria andServContentidIsNull() {
            addCriterion("SERV_CONTENTID is null");
            return (Criteria) this;
        }

        public Criteria andServContentidIsNotNull() {
            addCriterion("SERV_CONTENTID is not null");
            return (Criteria) this;
        }

        public Criteria andServContentidEqualTo(Long value) {
            addCriterion("SERV_CONTENTID =", value, "servContentid");
            return (Criteria) this;
        }

        public Criteria andServContentidNotEqualTo(Long value) {
            addCriterion("SERV_CONTENTID <>", value, "servContentid");
            return (Criteria) this;
        }

        public Criteria andServContentidGreaterThan(Long value) {
            addCriterion("SERV_CONTENTID >", value, "servContentid");
            return (Criteria) this;
        }

        public Criteria andServContentidGreaterThanOrEqualTo(Long value) {
            addCriterion("SERV_CONTENTID >=", value, "servContentid");
            return (Criteria) this;
        }

        public Criteria andServContentidLessThan(Long value) {
            addCriterion("SERV_CONTENTID <", value, "servContentid");
            return (Criteria) this;
        }

        public Criteria andServContentidLessThanOrEqualTo(Long value) {
            addCriterion("SERV_CONTENTID <=", value, "servContentid");
            return (Criteria) this;
        }

        public Criteria andServContentidIn(List<Long> values) {
            addCriterion("SERV_CONTENTID in", values, "servContentid");
            return (Criteria) this;
        }

        public Criteria andServContentidNotIn(List<Long> values) {
            addCriterion("SERV_CONTENTID not in", values, "servContentid");
            return (Criteria) this;
        }

        public Criteria andServContentidBetween(Long value1, Long value2) {
            addCriterion("SERV_CONTENTID between", value1, value2, "servContentid");
            return (Criteria) this;
        }

        public Criteria andServContentidNotBetween(Long value1, Long value2) {
            addCriterion("SERV_CONTENTID not between", value1, value2, "servContentid");
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

        public Criteria andServTimeidEqualTo(Integer value) {
            addCriterion("SERV_TIMEID =", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidNotEqualTo(Integer value) {
            addCriterion("SERV_TIMEID <>", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidGreaterThan(Integer value) {
            addCriterion("SERV_TIMEID >", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERV_TIMEID >=", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidLessThan(Integer value) {
            addCriterion("SERV_TIMEID <", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidLessThanOrEqualTo(Integer value) {
            addCriterion("SERV_TIMEID <=", value, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidIn(List<Integer> values) {
            addCriterion("SERV_TIMEID in", values, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidNotIn(List<Integer> values) {
            addCriterion("SERV_TIMEID not in", values, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidBetween(Integer value1, Integer value2) {
            addCriterion("SERV_TIMEID between", value1, value2, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andServTimeidNotBetween(Integer value1, Integer value2) {
            addCriterion("SERV_TIMEID not between", value1, value2, "servTimeid");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("STATE not between", value1, value2, "state");
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