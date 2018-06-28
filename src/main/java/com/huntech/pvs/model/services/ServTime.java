package com.huntech.pvs.model.services;

public class ServTime {
    private Integer id;

    private String servTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServTime() {
        return servTime;
    }

    public void setServTime(String servTime) {
        this.servTime = servTime == null ? null : servTime.trim();
    }
}