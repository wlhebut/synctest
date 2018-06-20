package com.huntech.pvs.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecommendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecommendExample() {
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

        public Criteria andServidIsNull() {
            addCriterion("SERVID is null");
            return (Criteria) this;
        }

        public Criteria andServidIsNotNull() {
            addCriterion("SERVID is not null");
            return (Criteria) this;
        }

        public Criteria andServidEqualTo(Long value) {
            addCriterion("SERVID =", value, "servid");
            return (Criteria) this;
        }

        public Criteria andServidNotEqualTo(Long value) {
            addCriterion("SERVID <>", value, "servid");
            return (Criteria) this;
        }

        public Criteria andServidGreaterThan(Long value) {
            addCriterion("SERVID >", value, "servid");
            return (Criteria) this;
        }

        public Criteria andServidGreaterThanOrEqualTo(Long value) {
            addCriterion("SERVID >=", value, "servid");
            return (Criteria) this;
        }

        public Criteria andServidLessThan(Long value) {
            addCriterion("SERVID <", value, "servid");
            return (Criteria) this;
        }

        public Criteria andServidLessThanOrEqualTo(Long value) {
            addCriterion("SERVID <=", value, "servid");
            return (Criteria) this;
        }

        public Criteria andServidIn(List<Long> values) {
            addCriterion("SERVID in", values, "servid");
            return (Criteria) this;
        }

        public Criteria andServidNotIn(List<Long> values) {
            addCriterion("SERVID not in", values, "servid");
            return (Criteria) this;
        }

        public Criteria andServidBetween(Long value1, Long value2) {
            addCriterion("SERVID between", value1, value2, "servid");
            return (Criteria) this;
        }

        public Criteria andServidNotBetween(Long value1, Long value2) {
            addCriterion("SERVID not between", value1, value2, "servid");
            return (Criteria) this;
        }

        public Criteria andRecommendDateIsNull() {
            addCriterion("RECOMMEND_DATE is null");
            return (Criteria) this;
        }

        public Criteria andRecommendDateIsNotNull() {
            addCriterion("RECOMMEND_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendDateEqualTo(Date value) {
            addCriterion("RECOMMEND_DATE =", value, "recommendDate");
            return (Criteria) this;
        }

        public Criteria andRecommendDateNotEqualTo(Date value) {
            addCriterion("RECOMMEND_DATE <>", value, "recommendDate");
            return (Criteria) this;
        }

        public Criteria andRecommendDateGreaterThan(Date value) {
            addCriterion("RECOMMEND_DATE >", value, "recommendDate");
            return (Criteria) this;
        }

        public Criteria andRecommendDateGreaterThanOrEqualTo(Date value) {
            addCriterion("RECOMMEND_DATE >=", value, "recommendDate");
            return (Criteria) this;
        }

        public Criteria andRecommendDateLessThan(Date value) {
            addCriterion("RECOMMEND_DATE <", value, "recommendDate");
            return (Criteria) this;
        }

        public Criteria andRecommendDateLessThanOrEqualTo(Date value) {
            addCriterion("RECOMMEND_DATE <=", value, "recommendDate");
            return (Criteria) this;
        }

        public Criteria andRecommendDateIn(List<Date> values) {
            addCriterion("RECOMMEND_DATE in", values, "recommendDate");
            return (Criteria) this;
        }

        public Criteria andRecommendDateNotIn(List<Date> values) {
            addCriterion("RECOMMEND_DATE not in", values, "recommendDate");
            return (Criteria) this;
        }

        public Criteria andRecommendDateBetween(Date value1, Date value2) {
            addCriterion("RECOMMEND_DATE between", value1, value2, "recommendDate");
            return (Criteria) this;
        }

        public Criteria andRecommendDateNotBetween(Date value1, Date value2) {
            addCriterion("RECOMMEND_DATE not between", value1, value2, "recommendDate");
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