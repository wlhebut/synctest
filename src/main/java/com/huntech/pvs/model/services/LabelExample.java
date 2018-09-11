package com.huntech.pvs.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LabelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LabelExample() {
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

        public Criteria andLabelContentIsNull() {
            addCriterion("LABEL_CONTENT is null");
            return (Criteria) this;
        }

        public Criteria andLabelContentIsNotNull() {
            addCriterion("LABEL_CONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andLabelContentEqualTo(String value) {
            addCriterion("LABEL_CONTENT =", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentNotEqualTo(String value) {
            addCriterion("LABEL_CONTENT <>", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentGreaterThan(String value) {
            addCriterion("LABEL_CONTENT >", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentGreaterThanOrEqualTo(String value) {
            addCriterion("LABEL_CONTENT >=", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentLessThan(String value) {
            addCriterion("LABEL_CONTENT <", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentLessThanOrEqualTo(String value) {
            addCriterion("LABEL_CONTENT <=", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentLike(String value) {
            addCriterion("LABEL_CONTENT like", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentNotLike(String value) {
            addCriterion("LABEL_CONTENT not like", value, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentIn(List<String> values) {
            addCriterion("LABEL_CONTENT in", values, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentNotIn(List<String> values) {
            addCriterion("LABEL_CONTENT not in", values, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentBetween(String value1, String value2) {
            addCriterion("LABEL_CONTENT between", value1, value2, "labelContent");
            return (Criteria) this;
        }

        public Criteria andLabelContentNotBetween(String value1, String value2) {
            addCriterion("LABEL_CONTENT not between", value1, value2, "labelContent");
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

        public Criteria andLdateIsNull() {
            addCriterion("LDATE is null");
            return (Criteria) this;
        }

        public Criteria andLdateIsNotNull() {
            addCriterion("LDATE is not null");
            return (Criteria) this;
        }

        public Criteria andLdateEqualTo(Date value) {
            addCriterion("LDATE =", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateNotEqualTo(Date value) {
            addCriterion("LDATE <>", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateGreaterThan(Date value) {
            addCriterion("LDATE >", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateGreaterThanOrEqualTo(Date value) {
            addCriterion("LDATE >=", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateLessThan(Date value) {
            addCriterion("LDATE <", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateLessThanOrEqualTo(Date value) {
            addCriterion("LDATE <=", value, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateIn(List<Date> values) {
            addCriterion("LDATE in", values, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateNotIn(List<Date> values) {
            addCriterion("LDATE not in", values, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateBetween(Date value1, Date value2) {
            addCriterion("LDATE between", value1, value2, "ldate");
            return (Criteria) this;
        }

        public Criteria andLdateNotBetween(Date value1, Date value2) {
            addCriterion("LDATE not between", value1, value2, "ldate");
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

        public Criteria andCanSeeIsNull() {
            addCriterion("CAN_SEE is null");
            return (Criteria) this;
        }

        public Criteria andCanSeeIsNotNull() {
            addCriterion("CAN_SEE is not null");
            return (Criteria) this;
        }

        public Criteria andCanSeeEqualTo(Byte value) {
            addCriterion("CAN_SEE =", value, "canSee");
            return (Criteria) this;
        }

        public Criteria andCanSeeNotEqualTo(Byte value) {
            addCriterion("CAN_SEE <>", value, "canSee");
            return (Criteria) this;
        }

        public Criteria andCanSeeGreaterThan(Byte value) {
            addCriterion("CAN_SEE >", value, "canSee");
            return (Criteria) this;
        }

        public Criteria andCanSeeGreaterThanOrEqualTo(Byte value) {
            addCriterion("CAN_SEE >=", value, "canSee");
            return (Criteria) this;
        }

        public Criteria andCanSeeLessThan(Byte value) {
            addCriterion("CAN_SEE <", value, "canSee");
            return (Criteria) this;
        }

        public Criteria andCanSeeLessThanOrEqualTo(Byte value) {
            addCriterion("CAN_SEE <=", value, "canSee");
            return (Criteria) this;
        }

        public Criteria andCanSeeIn(List<Byte> values) {
            addCriterion("CAN_SEE in", values, "canSee");
            return (Criteria) this;
        }

        public Criteria andCanSeeNotIn(List<Byte> values) {
            addCriterion("CAN_SEE not in", values, "canSee");
            return (Criteria) this;
        }

        public Criteria andCanSeeBetween(Byte value1, Byte value2) {
            addCriterion("CAN_SEE between", value1, value2, "canSee");
            return (Criteria) this;
        }

        public Criteria andCanSeeNotBetween(Byte value1, Byte value2) {
            addCriterion("CAN_SEE not between", value1, value2, "canSee");
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