package com.huntech.pvs.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyServsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MyServsExample() {
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

        public Criteria andMyBaseservTypeidIsNull() {
            addCriterion("MY_BASESERV_TYPEID is null");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidIsNotNull() {
            addCriterion("MY_BASESERV_TYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidEqualTo(Long value) {
            addCriterion("MY_BASESERV_TYPEID =", value, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidNotEqualTo(Long value) {
            addCriterion("MY_BASESERV_TYPEID <>", value, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidGreaterThan(Long value) {
            addCriterion("MY_BASESERV_TYPEID >", value, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidGreaterThanOrEqualTo(Long value) {
            addCriterion("MY_BASESERV_TYPEID >=", value, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidLessThan(Long value) {
            addCriterion("MY_BASESERV_TYPEID <", value, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidLessThanOrEqualTo(Long value) {
            addCriterion("MY_BASESERV_TYPEID <=", value, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidIn(List<Long> values) {
            addCriterion("MY_BASESERV_TYPEID in", values, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidNotIn(List<Long> values) {
            addCriterion("MY_BASESERV_TYPEID not in", values, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidBetween(Long value1, Long value2) {
            addCriterion("MY_BASESERV_TYPEID between", value1, value2, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andMyBaseservTypeidNotBetween(Long value1, Long value2) {
            addCriterion("MY_BASESERV_TYPEID not between", value1, value2, "myBaseservTypeid");
            return (Criteria) this;
        }

        public Criteria andServNameIsNull() {
            addCriterion("SERV_NAME is null");
            return (Criteria) this;
        }

        public Criteria andServNameIsNotNull() {
            addCriterion("SERV_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andServNameEqualTo(String value) {
            addCriterion("SERV_NAME =", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameNotEqualTo(String value) {
            addCriterion("SERV_NAME <>", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameGreaterThan(String value) {
            addCriterion("SERV_NAME >", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_NAME >=", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameLessThan(String value) {
            addCriterion("SERV_NAME <", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameLessThanOrEqualTo(String value) {
            addCriterion("SERV_NAME <=", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameLike(String value) {
            addCriterion("SERV_NAME like", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameNotLike(String value) {
            addCriterion("SERV_NAME not like", value, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameIn(List<String> values) {
            addCriterion("SERV_NAME in", values, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameNotIn(List<String> values) {
            addCriterion("SERV_NAME not in", values, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameBetween(String value1, String value2) {
            addCriterion("SERV_NAME between", value1, value2, "servName");
            return (Criteria) this;
        }

        public Criteria andServNameNotBetween(String value1, String value2) {
            addCriterion("SERV_NAME not between", value1, value2, "servName");
            return (Criteria) this;
        }

        public Criteria andServTelIsNull() {
            addCriterion("SERV_TEL is null");
            return (Criteria) this;
        }

        public Criteria andServTelIsNotNull() {
            addCriterion("SERV_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andServTelEqualTo(String value) {
            addCriterion("SERV_TEL =", value, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelNotEqualTo(String value) {
            addCriterion("SERV_TEL <>", value, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelGreaterThan(String value) {
            addCriterion("SERV_TEL >", value, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_TEL >=", value, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelLessThan(String value) {
            addCriterion("SERV_TEL <", value, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelLessThanOrEqualTo(String value) {
            addCriterion("SERV_TEL <=", value, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelLike(String value) {
            addCriterion("SERV_TEL like", value, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelNotLike(String value) {
            addCriterion("SERV_TEL not like", value, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelIn(List<String> values) {
            addCriterion("SERV_TEL in", values, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelNotIn(List<String> values) {
            addCriterion("SERV_TEL not in", values, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelBetween(String value1, String value2) {
            addCriterion("SERV_TEL between", value1, value2, "servTel");
            return (Criteria) this;
        }

        public Criteria andServTelNotBetween(String value1, String value2) {
            addCriterion("SERV_TEL not between", value1, value2, "servTel");
            return (Criteria) this;
        }

        public Criteria andServAddressIsNull() {
            addCriterion("SERV_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andServAddressIsNotNull() {
            addCriterion("SERV_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andServAddressEqualTo(String value) {
            addCriterion("SERV_ADDRESS =", value, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressNotEqualTo(String value) {
            addCriterion("SERV_ADDRESS <>", value, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressGreaterThan(String value) {
            addCriterion("SERV_ADDRESS >", value, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_ADDRESS >=", value, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressLessThan(String value) {
            addCriterion("SERV_ADDRESS <", value, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressLessThanOrEqualTo(String value) {
            addCriterion("SERV_ADDRESS <=", value, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressLike(String value) {
            addCriterion("SERV_ADDRESS like", value, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressNotLike(String value) {
            addCriterion("SERV_ADDRESS not like", value, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressIn(List<String> values) {
            addCriterion("SERV_ADDRESS in", values, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressNotIn(List<String> values) {
            addCriterion("SERV_ADDRESS not in", values, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressBetween(String value1, String value2) {
            addCriterion("SERV_ADDRESS between", value1, value2, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServAddressNotBetween(String value1, String value2) {
            addCriterion("SERV_ADDRESS not between", value1, value2, "servAddress");
            return (Criteria) this;
        }

        public Criteria andServNoteIsNull() {
            addCriterion("SERV_NOTE is null");
            return (Criteria) this;
        }

        public Criteria andServNoteIsNotNull() {
            addCriterion("SERV_NOTE is not null");
            return (Criteria) this;
        }

        public Criteria andServNoteEqualTo(String value) {
            addCriterion("SERV_NOTE =", value, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteNotEqualTo(String value) {
            addCriterion("SERV_NOTE <>", value, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteGreaterThan(String value) {
            addCriterion("SERV_NOTE >", value, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteGreaterThanOrEqualTo(String value) {
            addCriterion("SERV_NOTE >=", value, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteLessThan(String value) {
            addCriterion("SERV_NOTE <", value, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteLessThanOrEqualTo(String value) {
            addCriterion("SERV_NOTE <=", value, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteLike(String value) {
            addCriterion("SERV_NOTE like", value, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteNotLike(String value) {
            addCriterion("SERV_NOTE not like", value, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteIn(List<String> values) {
            addCriterion("SERV_NOTE in", values, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteNotIn(List<String> values) {
            addCriterion("SERV_NOTE not in", values, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteBetween(String value1, String value2) {
            addCriterion("SERV_NOTE between", value1, value2, "servNote");
            return (Criteria) this;
        }

        public Criteria andServNoteNotBetween(String value1, String value2) {
            addCriterion("SERV_NOTE not between", value1, value2, "servNote");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("LONGITUDE like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("LONGITUDE not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("LATITUDE like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("LATITUDE not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andSdateIsNull() {
            addCriterion("SDATE is null");
            return (Criteria) this;
        }

        public Criteria andSdateIsNotNull() {
            addCriterion("SDATE is not null");
            return (Criteria) this;
        }

        public Criteria andSdateEqualTo(Date value) {
            addCriterion("SDATE =", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotEqualTo(Date value) {
            addCriterion("SDATE <>", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThan(Date value) {
            addCriterion("SDATE >", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateGreaterThanOrEqualTo(Date value) {
            addCriterion("SDATE >=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThan(Date value) {
            addCriterion("SDATE <", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateLessThanOrEqualTo(Date value) {
            addCriterion("SDATE <=", value, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateIn(List<Date> values) {
            addCriterion("SDATE in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotIn(List<Date> values) {
            addCriterion("SDATE not in", values, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateBetween(Date value1, Date value2) {
            addCriterion("SDATE between", value1, value2, "sdate");
            return (Criteria) this;
        }

        public Criteria andSdateNotBetween(Date value1, Date value2) {
            addCriterion("SDATE not between", value1, value2, "sdate");
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