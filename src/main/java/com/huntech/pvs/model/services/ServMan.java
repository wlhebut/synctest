package com.huntech.pvs.model.services;

public class ServMan {
    private Long id;

    private String sname;

    private Integer sage;

    private String ssex;

    private String stel;

    private String identityCard;

    private String spic;

    private String sLevel;

    private String provinceCode;

    private String cityCode;

    private String townCode;

    private Long servManGpsid;

    private Long baseservTypeid;//是否是没有用的。

    private Long selfservTypeid;//是否是没有用的。

    private String enable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex == null ? null : ssex.trim();
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel == null ? null : stel.trim();
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public String getSpic() {
        return spic;
    }

    public void setSpic(String spic) {
        this.spic = spic == null ? null : spic.trim();
    }

    public String getsLevel() {
        return sLevel;
    }

    public void setsLevel(String sLevel) {
        this.sLevel = sLevel == null ? null : sLevel.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode == null ? null : townCode.trim();
    }

    public Long getServManGpsid() {
        return servManGpsid;
    }

    public void setServManGpsid(Long servManGpsid) {
        this.servManGpsid = servManGpsid;
    }

    public Long getBaseservTypeid() {
        return baseservTypeid;
    }

    public void setBaseservTypeid(Long baseservTypeid) {
        this.baseservTypeid = baseservTypeid;
    }

    public Long getSelfservTypeid() {
        return selfservTypeid;
    }

    public void setSelfservTypeid(Long selfservTypeid) {
        this.selfservTypeid = selfservTypeid;
    }

    public String getEnable() {
        return enable;
    }

    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }
}