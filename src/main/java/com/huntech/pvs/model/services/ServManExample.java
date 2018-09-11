package com.huntech.pvs.model.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServManExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServManExample() {
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

        public Criteria andSageIsNull() {
            addCriterion("SAGE is null");
            return (Criteria) this;
        }

        public Criteria andSageIsNotNull() {
            addCriterion("SAGE is not null");
            return (Criteria) this;
        }

        public Criteria andSageEqualTo(Integer value) {
            addCriterion("SAGE =", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageNotEqualTo(Integer value) {
            addCriterion("SAGE <>", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageGreaterThan(Integer value) {
            addCriterion("SAGE >", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageGreaterThanOrEqualTo(Integer value) {
            addCriterion("SAGE >=", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageLessThan(Integer value) {
            addCriterion("SAGE <", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageLessThanOrEqualTo(Integer value) {
            addCriterion("SAGE <=", value, "sage");
            return (Criteria) this;
        }

        public Criteria andSageIn(List<Integer> values) {
            addCriterion("SAGE in", values, "sage");
            return (Criteria) this;
        }

        public Criteria andSageNotIn(List<Integer> values) {
            addCriterion("SAGE not in", values, "sage");
            return (Criteria) this;
        }

        public Criteria andSageBetween(Integer value1, Integer value2) {
            addCriterion("SAGE between", value1, value2, "sage");
            return (Criteria) this;
        }

        public Criteria andSageNotBetween(Integer value1, Integer value2) {
            addCriterion("SAGE not between", value1, value2, "sage");
            return (Criteria) this;
        }

        public Criteria andSsexIsNull() {
            addCriterion("SSEX is null");
            return (Criteria) this;
        }

        public Criteria andSsexIsNotNull() {
            addCriterion("SSEX is not null");
            return (Criteria) this;
        }

        public Criteria andSsexEqualTo(String value) {
            addCriterion("SSEX =", value, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexNotEqualTo(String value) {
            addCriterion("SSEX <>", value, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexGreaterThan(String value) {
            addCriterion("SSEX >", value, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexGreaterThanOrEqualTo(String value) {
            addCriterion("SSEX >=", value, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexLessThan(String value) {
            addCriterion("SSEX <", value, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexLessThanOrEqualTo(String value) {
            addCriterion("SSEX <=", value, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexLike(String value) {
            addCriterion("SSEX like", value, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexNotLike(String value) {
            addCriterion("SSEX not like", value, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexIn(List<String> values) {
            addCriterion("SSEX in", values, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexNotIn(List<String> values) {
            addCriterion("SSEX not in", values, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexBetween(String value1, String value2) {
            addCriterion("SSEX between", value1, value2, "ssex");
            return (Criteria) this;
        }

        public Criteria andSsexNotBetween(String value1, String value2) {
            addCriterion("SSEX not between", value1, value2, "ssex");
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

        public Criteria andIdentityCardIsNull() {
            addCriterion("IDENTITY_CARD is null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardIsNotNull() {
            addCriterion("IDENTITY_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityCardEqualTo(String value) {
            addCriterion("IDENTITY_CARD =", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotEqualTo(String value) {
            addCriterion("IDENTITY_CARD <>", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGreaterThan(String value) {
            addCriterion("IDENTITY_CARD >", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardGreaterThanOrEqualTo(String value) {
            addCriterion("IDENTITY_CARD >=", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardLessThan(String value) {
            addCriterion("IDENTITY_CARD <", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardLessThanOrEqualTo(String value) {
            addCriterion("IDENTITY_CARD <=", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardLike(String value) {
            addCriterion("IDENTITY_CARD like", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotLike(String value) {
            addCriterion("IDENTITY_CARD not like", value, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardIn(List<String> values) {
            addCriterion("IDENTITY_CARD in", values, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotIn(List<String> values) {
            addCriterion("IDENTITY_CARD not in", values, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardBetween(String value1, String value2) {
            addCriterion("IDENTITY_CARD between", value1, value2, "identityCard");
            return (Criteria) this;
        }

        public Criteria andIdentityCardNotBetween(String value1, String value2) {
            addCriterion("IDENTITY_CARD not between", value1, value2, "identityCard");
            return (Criteria) this;
        }

        public Criteria andSpicIsNull() {
            addCriterion("SPIC is null");
            return (Criteria) this;
        }

        public Criteria andSpicIsNotNull() {
            addCriterion("SPIC is not null");
            return (Criteria) this;
        }

        public Criteria andSpicEqualTo(String value) {
            addCriterion("SPIC =", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicNotEqualTo(String value) {
            addCriterion("SPIC <>", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicGreaterThan(String value) {
            addCriterion("SPIC >", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicGreaterThanOrEqualTo(String value) {
            addCriterion("SPIC >=", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicLessThan(String value) {
            addCriterion("SPIC <", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicLessThanOrEqualTo(String value) {
            addCriterion("SPIC <=", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicLike(String value) {
            addCriterion("SPIC like", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicNotLike(String value) {
            addCriterion("SPIC not like", value, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicIn(List<String> values) {
            addCriterion("SPIC in", values, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicNotIn(List<String> values) {
            addCriterion("SPIC not in", values, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicBetween(String value1, String value2) {
            addCriterion("SPIC between", value1, value2, "spic");
            return (Criteria) this;
        }

        public Criteria andSpicNotBetween(String value1, String value2) {
            addCriterion("SPIC not between", value1, value2, "spic");
            return (Criteria) this;
        }

        public Criteria andSLevelIsNull() {
            addCriterion("S_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andSLevelIsNotNull() {
            addCriterion("S_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andSLevelEqualTo(String value) {
            addCriterion("S_LEVEL =", value, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelNotEqualTo(String value) {
            addCriterion("S_LEVEL <>", value, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelGreaterThan(String value) {
            addCriterion("S_LEVEL >", value, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelGreaterThanOrEqualTo(String value) {
            addCriterion("S_LEVEL >=", value, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelLessThan(String value) {
            addCriterion("S_LEVEL <", value, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelLessThanOrEqualTo(String value) {
            addCriterion("S_LEVEL <=", value, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelLike(String value) {
            addCriterion("S_LEVEL like", value, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelNotLike(String value) {
            addCriterion("S_LEVEL not like", value, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelIn(List<String> values) {
            addCriterion("S_LEVEL in", values, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelNotIn(List<String> values) {
            addCriterion("S_LEVEL not in", values, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelBetween(String value1, String value2) {
            addCriterion("S_LEVEL between", value1, value2, "sLevel");
            return (Criteria) this;
        }

        public Criteria andSLevelNotBetween(String value1, String value2) {
            addCriterion("S_LEVEL not between", value1, value2, "sLevel");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("PROVINCE_CODE =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("PROVINCE_CODE <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("PROVINCE_CODE >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("PROVINCE_CODE <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("PROVINCE_CODE like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("PROVINCE_CODE not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("PROVINCE_CODE in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("PROVINCE_CODE not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("CITY_CODE =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("CITY_CODE <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("CITY_CODE >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_CODE >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("CITY_CODE <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CITY_CODE <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("CITY_CODE like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("CITY_CODE not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("CITY_CODE in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("CITY_CODE not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("CITY_CODE between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("CITY_CODE not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeIsNull() {
            addCriterion("TOWN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTownCodeIsNotNull() {
            addCriterion("TOWN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTownCodeEqualTo(String value) {
            addCriterion("TOWN_CODE =", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeNotEqualTo(String value) {
            addCriterion("TOWN_CODE <>", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeGreaterThan(String value) {
            addCriterion("TOWN_CODE >", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TOWN_CODE >=", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeLessThan(String value) {
            addCriterion("TOWN_CODE <", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeLessThanOrEqualTo(String value) {
            addCriterion("TOWN_CODE <=", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeLike(String value) {
            addCriterion("TOWN_CODE like", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeNotLike(String value) {
            addCriterion("TOWN_CODE not like", value, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeIn(List<String> values) {
            addCriterion("TOWN_CODE in", values, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeNotIn(List<String> values) {
            addCriterion("TOWN_CODE not in", values, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeBetween(String value1, String value2) {
            addCriterion("TOWN_CODE between", value1, value2, "townCode");
            return (Criteria) this;
        }

        public Criteria andTownCodeNotBetween(String value1, String value2) {
            addCriterion("TOWN_CODE not between", value1, value2, "townCode");
            return (Criteria) this;
        }

        public Criteria andServManGpsidIsNull() {
            addCriterion("SERV_MAN_GPSID is null");
            return (Criteria) this;
        }

        public Criteria andServManGpsidIsNotNull() {
            addCriterion("SERV_MAN_GPSID is not null");
            return (Criteria) this;
        }

        public Criteria andServManGpsidEqualTo(Long value) {
            addCriterion("SERV_MAN_GPSID =", value, "servManGpsid");
            return (Criteria) this;
        }

        public Criteria andServManGpsidNotEqualTo(Long value) {
            addCriterion("SERV_MAN_GPSID <>", value, "servManGpsid");
            return (Criteria) this;
        }

        public Criteria andServManGpsidGreaterThan(Long value) {
            addCriterion("SERV_MAN_GPSID >", value, "servManGpsid");
            return (Criteria) this;
        }

        public Criteria andServManGpsidGreaterThanOrEqualTo(Long value) {
            addCriterion("SERV_MAN_GPSID >=", value, "servManGpsid");
            return (Criteria) this;
        }

        public Criteria andServManGpsidLessThan(Long value) {
            addCriterion("SERV_MAN_GPSID <", value, "servManGpsid");
            return (Criteria) this;
        }

        public Criteria andServManGpsidLessThanOrEqualTo(Long value) {
            addCriterion("SERV_MAN_GPSID <=", value, "servManGpsid");
            return (Criteria) this;
        }

        public Criteria andServManGpsidIn(List<Long> values) {
            addCriterion("SERV_MAN_GPSID in", values, "servManGpsid");
            return (Criteria) this;
        }

        public Criteria andServManGpsidNotIn(List<Long> values) {
            addCriterion("SERV_MAN_GPSID not in", values, "servManGpsid");
            return (Criteria) this;
        }

        public Criteria andServManGpsidBetween(Long value1, Long value2) {
            addCriterion("SERV_MAN_GPSID between", value1, value2, "servManGpsid");
            return (Criteria) this;
        }

        public Criteria andServManGpsidNotBetween(Long value1, Long value2) {
            addCriterion("SERV_MAN_GPSID not between", value1, value2, "servManGpsid");
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

        public Criteria andEnableIsNull() {
            addCriterion("ENABLE is null");
            return (Criteria) this;
        }

        public Criteria andEnableIsNotNull() {
            addCriterion("ENABLE is not null");
            return (Criteria) this;
        }

        public Criteria andEnableEqualTo(String value) {
            addCriterion("ENABLE =", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotEqualTo(String value) {
            addCriterion("ENABLE <>", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThan(String value) {
            addCriterion("ENABLE >", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableGreaterThanOrEqualTo(String value) {
            addCriterion("ENABLE >=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThan(String value) {
            addCriterion("ENABLE <", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLessThanOrEqualTo(String value) {
            addCriterion("ENABLE <=", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableLike(String value) {
            addCriterion("ENABLE like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotLike(String value) {
            addCriterion("ENABLE not like", value, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableIn(List<String> values) {
            addCriterion("ENABLE in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotIn(List<String> values) {
            addCriterion("ENABLE not in", values, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableBetween(String value1, String value2) {
            addCriterion("ENABLE between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andEnableNotBetween(String value1, String value2) {
            addCriterion("ENABLE not between", value1, value2, "enable");
            return (Criteria) this;
        }

        public Criteria andDdateIsNull() {
            addCriterion("DDATE is null");
            return (Criteria) this;
        }

        public Criteria andDdateIsNotNull() {
            addCriterion("DDATE is not null");
            return (Criteria) this;
        }

        public Criteria andDdateEqualTo(Date value) {
            addCriterion("DDATE =", value, "ddate");
            return (Criteria) this;
        }

        public Criteria andDdateNotEqualTo(Date value) {
            addCriterion("DDATE <>", value, "ddate");
            return (Criteria) this;
        }

        public Criteria andDdateGreaterThan(Date value) {
            addCriterion("DDATE >", value, "ddate");
            return (Criteria) this;
        }

        public Criteria andDdateGreaterThanOrEqualTo(Date value) {
            addCriterion("DDATE >=", value, "ddate");
            return (Criteria) this;
        }

        public Criteria andDdateLessThan(Date value) {
            addCriterion("DDATE <", value, "ddate");
            return (Criteria) this;
        }

        public Criteria andDdateLessThanOrEqualTo(Date value) {
            addCriterion("DDATE <=", value, "ddate");
            return (Criteria) this;
        }

        public Criteria andDdateIn(List<Date> values) {
            addCriterion("DDATE in", values, "ddate");
            return (Criteria) this;
        }

        public Criteria andDdateNotIn(List<Date> values) {
            addCriterion("DDATE not in", values, "ddate");
            return (Criteria) this;
        }

        public Criteria andDdateBetween(Date value1, Date value2) {
            addCriterion("DDATE between", value1, value2, "ddate");
            return (Criteria) this;
        }

        public Criteria andDdateNotBetween(Date value1, Date value2) {
            addCriterion("DDATE not between", value1, value2, "ddate");
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