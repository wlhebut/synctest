package com.huntech.pvs.model.services;

import java.util.Date;

public class MyBaseservType {
    private Long id;

    private String myServType;

    private String openid;

    private Byte state;

    private Date tdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMyServType() {
        return myServType;
    }

    public void setMyServType(String myServType) {
        this.myServType = myServType == null ? null : myServType.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }
}