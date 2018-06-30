package com.huntech.pvs.model.services;

public class Serv {
    private Long id;

    private String servName;

    private String servType;

    private Long baseservTypeid;

    private Long selfservTypeid;

    private Long servManid;

    private Long servContentid;

    private Integer servTimeid;

    private Byte state;

    private String servNote;

    public String getServNote() {
        return servNote;
    }

    public void setServNote(String servNote) {
        this.servNote = servNote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServName() {
        return servName;
    }

    public void setServName(String servName) {
        this.servName = servName == null ? null : servName.trim();
    }

    public String getServType() {
        return servType;
    }

    public void setServType(String servType) {
        this.servType = servType == null ? null : servType.trim();
    }

    public Long getBaseservTypeid() {
        return baseservTypeid;
    }

    public void setBaseservTypeid(Long baseservTypeid) {
        this.baseservTypeid = baseservTypeid;
    }

    public Long getSelfservTypeid() {
        return selfservTypeid;
    }

    public void setSelfservTypeid(Long selfservTypeid) {
        this.selfservTypeid = selfservTypeid;
    }

    public Long getServManid() {
        return servManid;
    }

    public void setServManid(Long servManid) {
        this.servManid = servManid;
    }

    public Long getServContentid() {
        return servContentid;
    }

    public void setServContentid(Long servContentid) {
        this.servContentid = servContentid;
    }

    public Integer getServTimeid() {
        return servTimeid;
    }

    public void setServTimeid(Integer servTimeid) {
        this.servTimeid = servTimeid;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}