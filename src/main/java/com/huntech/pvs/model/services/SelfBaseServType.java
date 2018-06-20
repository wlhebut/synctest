package com.huntech.pvs.model.services;

public class SelfBaseServType {
    private Long id;

    private Integer baseServTypeid;

    private String openid;

    private Byte state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBaseServTypeid() {
        return baseServTypeid;
    }

    public void setBaseServTypeid(Integer baseServTypeid) {
        this.baseServTypeid = baseServTypeid;
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
}