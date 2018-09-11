package com.huntech.pvs.model.services;

import java.util.Date;

public class ServStar {
    private Long id;

    private String servManid;

    private Integer servStar;

    private Long servId;

    private Date gdate;

    private Byte state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServManid() {
        return servManid;
    }

    public void setServManid(String servManid) {
        this.servManid = servManid == null ? null : servManid.trim();
    }

    public Integer getServStar() {
        return servStar;
    }

    public void setServStar(Integer servStar) {
        this.servStar = servStar;
    }

    public Long getServId() {
        return servId;
    }

    public void setServId(Long servId) {
        this.servId = servId;
    }

    public Date getGdate() {
        return gdate;
    }

    public void setGdate(Date gdate) {
        this.gdate = gdate;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}