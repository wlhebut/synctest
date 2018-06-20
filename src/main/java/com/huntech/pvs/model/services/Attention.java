package com.huntech.pvs.model.services;

import java.util.Date;

public class Attention {
    private Long id;

    private String openid;

    private Long servid;

    private Date attentionDate;

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

    public Date getAttentionDate() {
        return attentionDate;
    }

    public void setAttentionDate(Date attentionDate) {
        this.attentionDate = attentionDate;
    }
}