package com.huntech.pvs.model.services;

public class BaseServType {
    private Integer id;

    private Integer pid;

    private String tname;

    private Byte lawful;

    private Byte state;

    private Byte servType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Byte getLawful() {
        return lawful;
    }

    public void setLawful(Byte lawful) {
        this.lawful = lawful;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getServType() {
        return servType;
    }

    public void setServType(Byte servType) {
        this.servType = servType;
    }
}