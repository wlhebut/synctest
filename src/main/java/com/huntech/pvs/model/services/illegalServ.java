package com.huntech.pvs.model.services;

import java.util.Date;

public class illegalServ {
    private Long id;

    private String openid;

    private Long servManid;

    private Byte state;

    private Date ddate;

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

    public Long getServManid() {
        return servManid;
    }

    public void setServManid(Long servManid) {
        this.servManid = servManid;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }


    public illegalServ(String openid, Long servManid, Byte state) {
        this.openid = openid;
        this.servManid = servManid;
        this.state = state;
    }

    public illegalServ() {
    }
}