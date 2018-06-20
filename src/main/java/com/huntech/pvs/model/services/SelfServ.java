package com.huntech.pvs.model.services;

public class SelfServ {
    private Long id;

    private Long baseServtypeid;

    private Long servTimeid;

    private Byte servtype;

    private String selfServ;

    private String sname;

    private String stel;

    private String openid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBaseServtypeid() {
        return baseServtypeid;
    }

    public void setBaseServtypeid(Long baseServtypeid) {
        this.baseServtypeid = baseServtypeid;
    }

    public Long getServTimeid() {
        return servTimeid;
    }

    public void setServTimeid(Long servTimeid) {
        this.servTimeid = servTimeid;
    }

    public Byte getServtype() {
        return servtype;
    }

    public void setServtype(Byte servtype) {
        this.servtype = servtype;
    }

    public String getSelfServ() {
        return selfServ;
    }

    public void setSelfServ(String selfServ) {
        this.selfServ = selfServ == null ? null : selfServ.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel == null ? null : stel.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }
}