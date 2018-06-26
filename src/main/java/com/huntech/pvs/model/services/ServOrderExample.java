package com.huntech.pvs.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServOrderExample() {
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

        public Criteria andSeridIsNull() {
            addCriterion("SERID is null");
            return (Criteria) this;
        }

        public Criteria andSeridIsNotNull() {
            addCriterion("SERID is not null");
            return (Criteria) this;
        }

        public Criteria andSeridEqualTo(Long value) {
            addCriterion("SERID =", value, "serid");
            return (Criteria) this;
        }

        public Criteria andSeridNotEqualTo(Long value) {
            addCriterion("SERID <>", value, "serid");
            return (Criteria) this;
        }

        public Criteria andSeridGreaterThan(Long value) {
            addCriterion("SERID >", value, "serid");
            return (Criteria) this;
        }

        public Criteria andSeridGreaterThanOrEqualTo(Long value) {
            addCriterion("SERID >=", value, "serid");
            return (Criteria) this;
        }

        public Criteria andSeridLessThan(Long value) {
            addCriterion("SERID <", value, "serid");
            return (Criteria) this;
        }

        public Criteria andSeridLessThanOrEqualTo(Long value) {
            addCriterion("SERID <=", value, "serid");
            return (Criteria) this;
        }

        public Criteria andSeridIn(List<Long> values) {
            addCriterion("SERID in", values, "serid");
            return (Criteria) this;
        }

        public Criteria andSeridNotIn(List<Long> values) {
            addCriterion("SERID not in", values, "serid");
            return (Criteria) this;
        }

        public Criteria andSeridBetween(Long value1, Long value2) {
            addCriterion("SERID between", value1, value2, "serid");
            return (Criteria) this;
        }

        public Criteria andSeridNotBetween(Long value1, Long value2) {
            addCriterion("SERID not between", value1, value2, "serid");
            return (Criteria) this;
        }

        public Criteria andContentidIsNull() {
            addCriterion("CONTENTID is null");
            return (Criteria) this;
        }

        public Criteria andContentidIsNotNull() {
            addCriterion("CONTENTID is not null");
            return (Criteria) this;
        }

        public Criteria andContentidEqualTo(Long value) {
            addCriterion("CONTENTID =", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotEqualTo(Long value) {
            addCriterion("CONTENTID <>", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidGreaterThan(Long value) {
            addCriterion("CONTENTID >", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidGreaterThanOrEqualTo(Long value) {
            addCriterion("CONTENTID >=", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidLessThan(Long value) {
            addCriterion("CONTENTID <", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidLessThanOrEqualTo(Long value) {
            addCriterion("CONTENTID <=", value, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidIn(List<Long> values) {
            addCriterion("CONTENTID in", values, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotIn(List<Long> values) {
            addCriterion("CONTENTID not in", values, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidBetween(Long value1, Long value2) {
            addCriterion("CONTENTID between", value1, value2, "contentid");
            return (Criteria) this;
        }

        public Criteria andContentidNotBetween(Long value1, Long value2) {
            addCriterion("CONTENTID not between", value1, value2, "contentid");
            return (Criteria) this;
        }

        public Criteria andOdateIsNull() {
            addCriterion("ODATE is null");
            return (Criteria) this;
        }

        public Criteria andOdateIsNotNull() {
            addCriterion("ODATE is not null");
            return (Criteria) this;
        }

        public Criteria andOdateEqualTo(Date value) {
            addCriterion("ODATE =", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotEqualTo(Date value) {
            addCriterion("ODATE <>", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThan(Date value) {
            addCriterion("ODATE >", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateGreaterThanOrEqualTo(Date value) {
            addCriterion("ODATE >=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThan(Date value) {
            addCriterion("ODATE <", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateLessThanOrEqualTo(Date value) {
            addCriterion("ODATE <=", value, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateIn(List<Date> values) {
            addCriterion("ODATE in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotIn(List<Date> values) {
            addCriterion("ODATE not in", values, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateBetween(Date value1, Date value2) {
            addCriterion("ODATE between", value1, value2, "odate");
            return (Criteria) this;
        }

        public Criteria andOdateNotBetween(Date value1, Date value2) {
            addCriterion("ODATE not between", value1, value2, "odate");
            return (Criteria) this;
        }

        public Criteria andAddressidIsNull() {
            addCriterion("ADDRESSID is null");
            return (Criteria) this;
        }

        public Criteria andAddressidIsNotNull() {
            addCriterion("ADDRESSID is not null");
            return (Criteria) this;
        }

        public Criteria andAddressidEqualTo(Long value) {
            addCriterion("ADDRESSID =", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotEqualTo(Long value) {
            addCriterion("ADDRESSID <>", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidGreaterThan(Long value) {
            addCriterion("ADDRESSID >", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidGreaterThanOrEqualTo(Long value) {
            addCriterion("ADDRESSID >=", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLessThan(Long value) {
            addCriterion("ADDRESSID <", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidLessThanOrEqualTo(Long value) {
            addCriterion("ADDRESSID <=", value, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidIn(List<Long> values) {
            addCriterion("ADDRESSID in", values, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotIn(List<Long> values) {
            addCriterion("ADDRESSID not in", values, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidBetween(Long value1, Long value2) {
            addCriterion("ADDRESSID between", value1, value2, "addressid");
            return (Criteria) this;
        }

        public Criteria andAddressidNotBetween(Long value1, Long value2) {
            addCriterion("ADDRESSID not between", value1, value2, "addressid");
            return (Criteria) this;
        }

        public Criteria andServDateIsNull() {
            addCriterion("SERV_DATE is null");
            return (Criteria) this;
        }

        public Criteria andServDateIsNotNull() {
            addCriterion("SERV_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andServDateEqualTo(Date value) {
            addCriterion("SERV_DATE =", value, "servDate");
            return (Criteria) this;
        }

        public Criteria andServDateNotEqualTo(Date value) {
            addCriterion("SERV_DATE <>", value, "servDate");
            return (Criteria) this;
        }

        public Criteria andServDateGreaterThan(Date value) {
            addCriterion("SERV_DATE >", value, "servDate");
            return (Criteria) this;
        }

        public Criteria andServDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SERV_DATE >=", value, "servDate");
            return (Criteria) this;
        }

        public Criteria andServDateLessThan(Date value) {
            addCriterion("SERV_DATE <", value, "servDate");
            return (Criteria) this;
        }

        public Criteria andServDateLessThanOrEqualTo(Date value) {
            addCriterion("SERV_DATE <=", value, "servDate");
            return (Criteria) this;
        }

        public Criteria andServDateIn(List<Date> values) {
            addCriterion("SERV_DATE in", values, "servDate");
            return (Criteria) this;
        }

        public Criteria andServDateNotIn(List<Date> values) {
            addCriterion("SERV_DATE not in", values, "servDate");
            return (Criteria) this;
        }

        public Criteria andServDateBetween(Date value1, Date value2) {
            addCriterion("SERV_DATE between", value1, value2, "servDate");
            return (Criteria) this;
        }

        public Criteria andServDateNotBetween(Date value1, Date value2) {
            addCriterion("SERV_DATE not between", value1, value2, "servDate");
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