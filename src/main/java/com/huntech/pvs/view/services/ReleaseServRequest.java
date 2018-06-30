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

    private String servName;//私服名称
    private String openid;

    private String servNote;//私服备注


    public String getServNote() {
        return servNote;
    }

    public void setServNote(String servNote) {
        this.servNote = servNote;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getServName() {
        return servName;
    }

    public void setServName(String servName) {
        this.servName = servName;
    }

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
