package com.huntech.pvs.model.services;

import java.util.Date;

public class Transmits {
    private Long id;

    private String openid;

    private Long servid;

    private Date tdate;

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

    public Long getServid() {
        return servid;
    }

    public void setServid(Long servid) {
        this.servid = servid;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }
}