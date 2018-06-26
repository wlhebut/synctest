package com.huntech.pvs.model.services;

import java.util.Date;

public class Label {
    private Long id;

    private String labelContent;

    private Long servManid;

    private Long servId;

    private String openid;

    private Date ldate;

    private Byte state;

    private Byte canSee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelContent() {
        return labelContent;
    }

    public void setLabelContent(String labelContent) {
        this.labelContent = labelContent == null ? null : labelContent.trim();
    }

    public Long getServManid() {
        return servManid;
    }

    public void setServManid(Long servManid) {
        this.servManid = servManid;
    }

    public Long getServId() {
        return servId;
    }

    public void setServId(Long servId) {
        this.servId = servId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Date getLdate() {
        return ldate;
    }

    public void setLdate(Date ldate) {
        this.ldate = ldate;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getCanSee() {
        return canSee;
    }

    public void setCanSee(Byte canSee) {
        this.canSee = canSee;
    }
}