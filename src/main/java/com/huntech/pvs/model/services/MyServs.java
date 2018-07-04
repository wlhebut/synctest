package com.huntech.pvs.model.services;

import com.huntech.pvs.view.request.PageRequest;

import java.util.Date;

public class MyServs {
    private Long id;//新增中如果是新的分类这个值设置为-1；

    private String openid;

    private Long myBaseservTypeid;

    private String servName;

    private String servTel;

    private String servAddress;

    private String servNote;

    private String longitude;

    private String latitude;

    private Date sdate;

    private Byte state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Long getMyBaseservTypeid() {
        return myBaseservTypeid;
    }

    public void setMyBaseservTypeid(Long myBaseservTypeid) {
        this.myBaseservTypeid = myBaseservTypeid;
    }

    public String getServName() {
        return servName;
    }

    public void setServName(String servName) {
        this.servName = servName == null ? null : servName.trim();
    }

    public String getServTel() {
        return servTel;
    }

    public void setServTel(String servTel) {
        this.servTel = servTel == null ? null : servTel.trim();
    }

    public String getServAddress() {
        return servAddress;
    }

    public void setServAddress(String servAddress) {
        this.servAddress = servAddress == null ? null : servAddress.trim();
    }

    public String getServNote() {
        return servNote;
    }

    public void setServNote(String servNote) {
        this.servNote = servNote == null ? null : servNote.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Date getSdate() {
        return sdate;
    }

    public void setSdate(Date sdate) {
        this.sdate = sdate;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}