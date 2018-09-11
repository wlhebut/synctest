package com.huntech.pvs.view.services;

import java.io.Serializable;

public class ServView implements  Comparable ,Serializable {

    private static final long serialVersionUID = -2765147794959359589L;
    private Long id;
    private Long baseservTypeid;
    private String servManid;
    private String sname;
    private String servName;
    private String tname;
    private String stel;

    private Integer serverSatis;
    private Integer servTimeid;
    private Long servContentid;
    private Byte state;

    private String longitude;//经度
    private String latitude;

    private Double distance;//距离
    private String servTime;
    private String servAddress;//位置

    @Override
    public String toString() {
        return "ServView{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", servName='" + servName + '\'' +
                ", tname='" + tname + '\'' +
                ", stel='" + stel + '\'' +
                ", serverSatis=" + serverSatis +
                ", servTimeid=" + servTimeid +
                ", servContentid=" + servContentid +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", distance=" + distance +
                ", servTime='" + servTime + '\'' +
                ", servAddress='" + servAddress + '\'' +
                '}';
    }

    public String getServAddress() {
        return servAddress;
    }

    public void setServAddress(String servAddress) {
        this.servAddress = servAddress;
    }

    public String getServTime() {
        return servTime;
    }

    public void setServTime(String servTime) {
        this.servTime = servTime;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getServTimeid() {
        return servTimeid;
    }

    public void setServTimeid(Integer servTimeid) {
        this.servTimeid = servTimeid;
    }

    public Long getServContentid() {
        return servContentid;
    }

    public void setServContentid(Long servContentid) {
        this.servContentid = servContentid;
    }

    public String getServName() {
        return servName;
    }

    public void setServName(String servName) {
        this.servName = servName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBaseservTypeid() {
        return baseservTypeid;
    }

    public void setBaseservTypeid(Long baseservTypeid) {
        this.baseservTypeid = baseservTypeid;
    }

    public String getServManid() {
        return servManid;
    }

    public void setServManid(String servManid) {
        this.servManid = servManid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getServerSatis() {
        return serverSatis;
    }

    public void setServerSatis(Integer serverSatis) {
        this.serverSatis = serverSatis;
    }

    @Override
    public int compareTo(Object o) {
        return ((ServView)o).getServerSatis()-this.getServerSatis();
    }
}
