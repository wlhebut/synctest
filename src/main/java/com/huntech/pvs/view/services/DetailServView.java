package com.huntech.pvs.view.services;

import com.huntech.pvs.model.services.Label;
import com.huntech.pvs.model.services.ServContent;

import java.io.Serializable;
import java.util.List;

public class DetailServView implements Serializable {

    private Long id;
    private Long baseservTypeid;
    private Long servManid;
    private Long servContentid;
    private String sname;
    private String tname;
    private String servName;
    private String stel;

    private Double serverSatis;

    private String longitude;//经度
    private String latitude;

    private Double distance;//距离


    private Integer attention;

    private Integer totalAttentions;

    private String servTime;
    private String servNote;



    private Integer servTimeid;
    private Byte state;

    public String getServNote() {
        return servNote;
    }

    public void setServNote(String servNote) {
        this.servNote = servNote;
    }

    public String getServTime() {
        return servTime;
    }

    public void setServTime(String servTime) {
        this.servTime = servTime;
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

    public String getServName() {
        return servName;
    }

    public void setServName(String servName) {
        this.servName = servName;
    }

    public Integer getTotalAttentions() {
        return totalAttentions;
    }

    public void setTotalAttentions(Integer totalAttentions) {
        this.totalAttentions = totalAttentions;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Long getServContentid() {
        return servContentid;
    }

    public void setServContentid(Long servContentid) {
        this.servContentid = servContentid;
    }

    private List<ServContent> servContents;
    private List<Label> servLabels;

    public List<Label> getServLabels() {
        return servLabels;
    }

    public void setServLabels(List<Label> servLabels) {
        this.servLabels = servLabels;
    }

    public List<ServContent> getServContents() {
        return servContents;
    }

    public void setServContents(List<ServContent> servContents) {
        this.servContents = servContents;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBaseservTypeid() {
        return baseservTypeid;
    }

    public void setBaseservTypeid(Long baseservTypeid) {
        this.baseservTypeid = baseservTypeid;
    }

    public Long getServManid() {
        return servManid;
    }

    public void setServManid(Long servManid) {
        this.servManid = servManid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Double getServerSatis() {
        return serverSatis;
    }

    public void setServerSatis(Double serverSatis) {
        this.serverSatis = serverSatis;
    }
}
