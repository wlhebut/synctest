package com.huntech.pvs.model.services;

import java.util.ArrayList;
import java.util.List;

public class SatisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SatisExample() {
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

        public Criteria andErversatisIsNull() {
            addCriterion("ERVERSATIS is null");
            return (Criteria) this;
        }

        public Criteria andErversatisIsNotNull() {
            addCriterion("ERVERSATIS is not null");
            return (Criteria) this;
        }

        public Criteria andErversatisEqualTo(Integer value) {
            addCriterion("ERVERSATIS =", value, "erversatis");
            return (Criteria) this;
        }

        public Criteria andErversatisNotEqualTo(Integer value) {
            addCriterion("ERVERSATIS <>", value, "erversatis");
            return (Criteria) this;
        }

        public Criteria andErversatisGreaterThan(Integer value) {
            addCriterion("ERVERSATIS >", value, "erversatis");
            return (Criteria) this;
        }

        public Criteria andErversatisGreaterThanOrEqualTo(Integer value) {
            addCriterion("ERVERSATIS >=", value, "erversatis");
            return (Criteria) this;
        }

        public Criteria andErversatisLessThan(Integer value) {
            addCriterion("ERVERSATIS <", value, "erversatis");
            return (Criteria) this;
        }

        public Criteria andErversatisLessThanOrEqualTo(Integer value) {
            addCriterion("ERVERSATIS <=", value, "erversatis");
            return (Criteria) this;
        }

        public Criteria andErversatisIn(List<Integer> values) {
            addCriterion("ERVERSATIS in", values, "erversatis");
            return (Criteria) this;
        }

        public Criteria andErversatisNotIn(List<Integer> values) {
            addCriterion("ERVERSATIS not in", values, "erversatis");
            return (Criteria) this;
        }

        public Criteria andErversatisBetween(Integer value1, Integer value2) {
            addCriterion("ERVERSATIS between", value1, value2, "erversatis");
            return (Criteria) this;
        }

        public Criteria andErversatisNotBetween(Integer value1, Integer value2) {
            addCriterion("ERVERSATIS not between", value1, value2, "erversatis");
            return (Criteria) this;
        }

        public Criteria andTransmitsIsNull() {
            addCriterion("TRANSMITS is null");
            return (Criteria) this;
        }

        public Criteria andTransmitsIsNotNull() {
            addCriterion("TRANSMITS is not null");
            return (Criteria) this;
        }

        public Criteria andTransmitsEqualTo(Integer value) {
            addCriterion("TRANSMITS =", value, "transmits");
            return (Criteria) this;
        }

        public Criteria andTransmitsNotEqualTo(Integer value) {
            addCriterion("TRANSMITS <>", value, "transmits");
            return (Criteria) this;
        }

        public Criteria andTransmitsGreaterThan(Integer value) {
            addCriterion("TRANSMITS >", value, "transmits");
            return (Criteria) this;
        }

        public Criteria andTransmitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("TRANSMITS >=", value, "transmits");
            return (Criteria) this;
        }

        public Criteria andTransmitsLessThan(Integer value) {
            addCriterion("TRANSMITS <", value, "transmits");
            return (Criteria) this;
        }

        public Criteria andTransmitsLessThanOrEqualTo(Integer value) {
            addCriterion("TRANSMITS <=", value, "transmits");
            return (Criteria) this;
        }

        public Criteria andTransmitsIn(List<Integer> values) {
            addCriterion("TRANSMITS in", values, "transmits");
            return (Criteria) this;
        }

        public Criteria andTransmitsNotIn(List<Integer> values) {
            addCriterion("TRANSMITS not in", values, "transmits");
            return (Criteria) this;
        }

        public Criteria andTransmitsBetween(Integer value1, Integer value2) {
            addCriterion("TRANSMITS between", value1, value2, "transmits");
            return (Criteria) this;
        }

        public Criteria andTransmitsNotBetween(Integer value1, Integer value2) {
            addCriterion("TRANSMITS not between", value1, value2, "transmits");
            return (Criteria) this;
        }

        public Criteria andCollectionsIsNull() {
            addCriterion("COLLECTIONS is null");
            return (Criteria) this;
        }

        public Criteria andCollectionsIsNotNull() {
            addCriterion("COLLECTIONS is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionsEqualTo(Integer value) {
            addCriterion("COLLECTIONS =", value, "collections");
            return (Criteria) this;
        }

        public Criteria andCollectionsNotEqualTo(Integer value) {
            addCriterion("COLLECTIONS <>", value, "collections");
            return (Criteria) this;
        }

        public Criteria andCollectionsGreaterThan(Integer value) {
            addCriterion("COLLECTIONS >", value, "collections");
            return (Criteria) this;
        }

        public Criteria andCollectionsGreaterThanOrEqualTo(Integer value) {
            addCriterion("COLLECTIONS >=", value, "collections");
            return (Criteria) this;
        }

        public Criteria andCollectionsLessThan(Integer value) {
            addCriterion("COLLECTIONS <", value, "collections");
            return (Criteria) this;
        }

        public Criteria andCollectionsLessThanOrEqualTo(Integer value) {
            addCriterion("COLLECTIONS <=", value, "collections");
            return (Criteria) this;
        }

        public Criteria andCollectionsIn(List<Integer> values) {
            addCriterion("COLLECTIONS in", values, "collections");
            return (Criteria) this;
        }

        public Criteria andCollectionsNotIn(List<Integer> values) {
            addCriterion("COLLECTIONS not in", values, "collections");
            return (Criteria) this;
        }

        public Criteria andCollectionsBetween(Integer value1, Integer value2) {
            addCriterion("COLLECTIONS between", value1, value2, "collections");
            return (Criteria) this;
        }

        public Criteria andCollectionsNotBetween(Integer value1, Integer value2) {
            addCriterion("COLLECTIONS not between", value1, value2, "collections");
            return (Criteria) this;
        }

        public Criteria andThumbsIsNull() {
            addCriterion("THUMBS is null");
            return (Criteria) this;
        }

        public Criteria andThumbsIsNotNull() {
            addCriterion("THUMBS is not null");
            return (Criteria) this;
        }

        public Criteria andThumbsEqualTo(Integer value) {
            addCriterion("THUMBS =", value, "thumbs");
            return (Criteria) this;
        }

        public Criteria andThumbsNotEqualTo(Integer value) {
            addCriterion("THUMBS <>", value, "thumbs");
            return (Criteria) this;
        }

        public Criteria andThumbsGreaterThan(Integer value) {
            addCriterion("THUMBS >", value, "thumbs");
            return (Criteria) this;
        }

        public Criteria andThumbsGreaterThanOrEqualTo(Integer value) {
            addCriterion("THUMBS >=", value, "thumbs");
            return (Criteria) this;
        }

        public Criteria andThumbsLessThan(Integer value) {
            addCriterion("THUMBS <", value, "thumbs");
            return (Criteria) this;
        }

        public Criteria andThumbsLessThanOrEqualTo(Integer value) {
            addCriterion("THUMBS <=", value, "thumbs");
            return (Criteria) this;
        }

        public Criteria andThumbsIn(List<Integer> values) {
            addCriterion("THUMBS in", values, "thumbs");
            return (Criteria) this;
        }

        public Criteria andThumbsNotIn(List<Integer> values) {
            addCriterion("THUMBS not in", values, "thumbs");
            return (Criteria) this;
        }

        public Criteria andThumbsBetween(Integer value1, Integer value2) {
            addCriterion("THUMBS between", value1, value2, "thumbs");
            return (Criteria) this;
        }

        public Criteria andThumbsNotBetween(Integer value1, Integer value2) {
            addCriterion("THUMBS not between", value1, value2, "thumbs");
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