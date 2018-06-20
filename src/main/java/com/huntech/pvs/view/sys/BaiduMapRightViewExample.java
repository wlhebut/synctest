package com.huntech.pvs.view.sys;

import java.util.ArrayList;
import java.util.List;

public class BaiduMapRightViewExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaiduMapRightViewExample() {
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

        public Criteria andKeyIsNull() {
            addCriterion("KEY is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("KEY is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("KEY =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("KEY <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("KEY >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("KEY >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("KEY <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("KEY <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("KEY like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("KEY not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("KEY in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("KEY not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("KEY between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("KEY not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("VALUE is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("VALUE =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("VALUE <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("VALUE >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("VALUE >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("VALUE <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("VALUE <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("VALUE like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("VALUE not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("VALUE in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("VALUE not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("VALUE between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("VALUE not between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNull() {
            addCriterion("ORDERBY is null");
            return (Criteria) this;
        }

        public Criteria andOrderbyIsNotNull() {
            addCriterion("ORDERBY is not null");
            return (Criteria) this;
        }

        public Criteria andOrderbyEqualTo(Long value) {
            addCriterion("ORDERBY =", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotEqualTo(Long value) {
            addCriterion("ORDERBY <>", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThan(Long value) {
            addCriterion("ORDERBY >", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyGreaterThanOrEqualTo(Long value) {
            addCriterion("ORDERBY >=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThan(Long value) {
            addCriterion("ORDERBY <", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyLessThanOrEqualTo(Long value) {
            addCriterion("ORDERBY <=", value, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyIn(List<Long> values) {
            addCriterion("ORDERBY in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotIn(List<Long> values) {
            addCriterion("ORDERBY not in", values, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyBetween(Long value1, Long value2) {
            addCriterion("ORDERBY between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andOrderbyNotBetween(Long value1, Long value2) {
            addCriterion("ORDERBY not between", value1, value2, "orderby");
            return (Criteria) this;
        }

        public Criteria andMenuSidIsNull() {
            addCriterion("MENU_SID is null");
            return (Criteria) this;
        }

        public Criteria andMenuSidIsNotNull() {
            addCriterion("MENU_SID is not null");
            return (Criteria) this;
        }

        public Criteria andMenuSidEqualTo(Long value) {
            addCriterion("MENU_SID =", value, "menuSid");
            return (Criteria) this;
        }

        public Criteria andMenuSidNotEqualTo(Long value) {
            addCriterion("MENU_SID <>", value, "menuSid");
            return (Criteria) this;
        }

        public Criteria andMenuSidGreaterThan(Long value) {
            addCriterion("MENU_SID >", value, "menuSid");
            return (Criteria) this;
        }

        public Criteria andMenuSidGreaterThanOrEqualTo(Long value) {
            addCriterion("MENU_SID >=", value, "menuSid");
            return (Criteria) this;
        }

        public Criteria andMenuSidLessThan(Long value) {
            addCriterion("MENU_SID <", value, "menuSid");
            return (Criteria) this;
        }

        public Criteria andMenuSidLessThanOrEqualTo(Long value) {
            addCriterion("MENU_SID <=", value, "menuSid");
            return (Criteria) this;
        }

        public Criteria andMenuSidIn(List<Long> values) {
            addCriterion("MENU_SID in", values, "menuSid");
            return (Criteria) this;
        }

        public Criteria andMenuSidNotIn(List<Long> values) {
            addCriterion("MENU_SID not in", values, "menuSid");
            return (Criteria) this;
        }

        public Criteria andMenuSidBetween(Long value1, Long value2) {
            addCriterion("MENU_SID between", value1, value2, "menuSid");
            return (Criteria) this;
        }

        public Criteria andMenuSidNotBetween(Long value1, Long value2) {
            addCriterion("MENU_SID not between", value1, value2, "menuSid");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andMenuKeyIsNull() {
            addCriterion("MENU_KEY is null");
            return (Criteria) this;
        }

        public Criteria andMenuKeyIsNotNull() {
            addCriterion("MENU_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andMenuKeyEqualTo(String value) {
            addCriterion("MENU_KEY =", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyNotEqualTo(String value) {
            addCriterion("MENU_KEY <>", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyGreaterThan(String value) {
            addCriterion("MENU_KEY >", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyGreaterThanOrEqualTo(String value) {
            addCriterion("MENU_KEY >=", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyLessThan(String value) {
            addCriterion("MENU_KEY <", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyLessThanOrEqualTo(String value) {
            addCriterion("MENU_KEY <=", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyLike(String value) {
            addCriterion("MENU_KEY like", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyNotLike(String value) {
            addCriterion("MENU_KEY not like", value, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyIn(List<String> values) {
            addCriterion("MENU_KEY in", values, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyNotIn(List<String> values) {
            addCriterion("MENU_KEY not in", values, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyBetween(String value1, String value2) {
            addCriterion("MENU_KEY between", value1, value2, "menuKey");
            return (Criteria) this;
        }

        public Criteria andMenuKeyNotBetween(String value1, String value2) {
            addCriterion("MENU_KEY not between", value1, value2, "menuKey");
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