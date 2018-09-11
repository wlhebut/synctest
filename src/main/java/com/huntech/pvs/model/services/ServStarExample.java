package com.huntech.pvs.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServStarExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServStarExample() {
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

        public Criteria andServManidIsNull() {
            addCriterion("SERV_MANID is null");
            return (Criteria) this;
        }

        public Criteria andServManidIsNotNull() {
            addCriterion("SERV_MANID is not null");
            return (Criteria) this;
        }

        public Criteria andServManidEqualTo(String value) {
            addCriterion("SERV_MANID =", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidNotEqualTo(String value) {
            addCriterion("SERV_MANID <>", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidGreaterThan(String value) {
            addCriterion("SERV_MANID >", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_MANID >=", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidLessThan(String value) {
            addCriterion("SERV_MANID <", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidLessThanOrEqualTo(String value) {
            addCriterion("SERV_MANID <=", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidLike(String value) {
            addCriterion("SERV_MANID like", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidNotLike(String value) {
            addCriterion("SERV_MANID not like", value, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidIn(List<String> values) {
            addCriterion("SERV_MANID in", values, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidNotIn(List<String> values) {
            addCriterion("SERV_MANID not in", values, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidBetween(String value1, String value2) {
            addCriterion("SERV_MANID between", value1, value2, "servManid");
            return (Criteria) this;
        }

        public Criteria andServManidNotBetween(String value1, String value2) {
            addCriterion("SERV_MANID not between", value1, value2, "servManid");
            return (Criteria) this;
        }

        public Criteria andServStarIsNull() {
            addCriterion("SERV_STAR is null");
            return (Criteria) this;
        }

        public Criteria andServStarIsNotNull() {
            addCriterion("SERV_STAR is not null");
            return (Criteria) this;
        }

        public Criteria andServStarEqualTo(Integer value) {
            addCriterion("SERV_STAR =", value, "servStar");
            return (Criteria) this;
        }

        public Criteria andServStarNotEqualTo(Integer value) {
            addCriterion("SERV_STAR <>", value, "servStar");
            return (Criteria) this;
        }

        public Criteria andServStarGreaterThan(Integer value) {
            addCriterion("SERV_STAR >", value, "servStar");
            return (Criteria) this;
        }

        public Criteria andServStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERV_STAR >=", value, "servStar");
            return (Criteria) this;
        }

        public Criteria andServStarLessThan(Integer value) {
            addCriterion("SERV_STAR <", value, "servStar");
            return (Criteria) this;
        }

        public Criteria andServStarLessThanOrEqualTo(Integer value) {
            addCriterion("SERV_STAR <=", value, "servStar");
            return (Criteria) this;
        }

        public Criteria andServStarIn(List<Integer> values) {
            addCriterion("SERV_STAR in", values, "servStar");
            return (Criteria) this;
        }

        public Criteria andServStarNotIn(List<Integer> values) {
            addCriterion("SERV_STAR not in", values, "servStar");
            return (Criteria) this;
        }

        public Criteria andServStarBetween(Integer value1, Integer value2) {
            addCriterion("SERV_STAR between", value1, value2, "servStar");
            return (Criteria) this;
        }

        public Criteria andServStarNotBetween(Integer value1, Integer value2) {
            addCriterion("SERV_STAR not between", value1, value2, "servStar");
            return (Criteria) this;
        }

        public Criteria andServIdIsNull() {
            addCriterion("SERV_ID is null");
            return (Criteria) this;
        }

        public Criteria andServIdIsNotNull() {
            addCriterion("SERV_ID is not null");
            return (Criteria) this;
        }

        public Criteria andServIdEqualTo(Long value) {
            addCriterion("SERV_ID =", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotEqualTo(Long value) {
            addCriterion("SERV_ID <>", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThan(Long value) {
            addCriterion("SERV_ID >", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SERV_ID >=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThan(Long value) {
            addCriterion("SERV_ID <", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdLessThanOrEqualTo(Long value) {
            addCriterion("SERV_ID <=", value, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdIn(List<Long> values) {
            addCriterion("SERV_ID in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotIn(List<Long> values) {
            addCriterion("SERV_ID not in", values, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdBetween(Long value1, Long value2) {
            addCriterion("SERV_ID between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andServIdNotBetween(Long value1, Long value2) {
            addCriterion("SERV_ID not between", value1, value2, "servId");
            return (Criteria) this;
        }

        public Criteria andGdateIsNull() {
            addCriterion("GDATE is null");
            return (Criteria) this;
        }

        public Criteria andGdateIsNotNull() {
            addCriterion("GDATE is not null");
            return (Criteria) this;
        }

        public Criteria andGdateEqualTo(Date value) {
            addCriterion("GDATE =", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotEqualTo(Date value) {
            addCriterion("GDATE <>", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThan(Date value) {
            addCriterion("GDATE >", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateGreaterThanOrEqualTo(Date value) {
            addCriterion("GDATE >=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThan(Date value) {
            addCriterion("GDATE <", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateLessThanOrEqualTo(Date value) {
            addCriterion("GDATE <=", value, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateIn(List<Date> values) {
            addCriterion("GDATE in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotIn(List<Date> values) {
            addCriterion("GDATE not in", values, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateBetween(Date value1, Date value2) {
            addCriterion("GDATE between", value1, value2, "gdate");
            return (Criteria) this;
        }

        public Criteria andGdateNotBetween(Date value1, Date value2) {
            addCriterion("GDATE not between", value1, value2, "gdate");
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