package com.huntech.pvs.view.services;

import com.huntech.pvs.model.services.ServContent;
import sun.util.resources.ga.LocaleNames_ga;

import java.util.List;

public class ReleaseServRequest {


    private Long baseServTypeid;//baseServ-id
    private Long servType;//0-baseServ;1-selfServ
    private List<ServContent> servContents;
    private Long servTimeId;

    private String selfServ;//可能为id，也可能为文字


    public Long getBaseServTypeid() {
        return baseServTypeid;
    }

    public void setBaseServTypeid(Long baseServTypeid) {
        this.baseServTypeid = baseServTypeid;
    }

    public String getSelfServ() {
        return selfServ;
    }

    public void setSelfServ(String selfServ) {
        this.selfServ = selfServ;
    }

    public Long getServType() {
        return servType;
    }

    public void setServType(Long servType) {
        this.servType = servType;
    }

    public List<ServContent> getServContents() {
        return servContents;
    }

    public void setServContents(List<ServContent> servContents) {
        this.servContents = servContents;
    }

    public Long getServTimeId() {
        return servTimeId;
    }

    public void setServTimeId(Long servTimeId) {
        this.servTimeId = servTimeId;
    }
}
