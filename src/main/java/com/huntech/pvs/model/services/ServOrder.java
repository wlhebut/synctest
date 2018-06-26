package com.huntech.pvs.model.services;

import java.util.Date;

public class ServOrder {
    private Long id;

    private String openid;

    private Long serid;

    private Long contentid;

    private Date odate;

    private Long addressid;

    private Date servDate;

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

    public Long getSerid() {
        return serid;
    }

    public void setSerid(Long serid) {
        this.serid = serid;
    }

    public Long getContentid() {
        return contentid;
    }

    public void setContentid(Long contentid) {
        this.contentid = contentid;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    public Long getAddressid() {
        return addressid;
    }

    public void setAddressid(Long addressid) {
        this.addressid = addressid;
    }

    public Date getServDate() {
        return servDate;
    }

    public void setServDate(Date servDate) {
        this.servDate = servDate;
    }
}