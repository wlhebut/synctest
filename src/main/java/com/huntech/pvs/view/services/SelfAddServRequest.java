package com.huntech.pvs.view.services;

import com.huntech.pvs.model.services.ServContent;

import java.util.List;

public class SelfAddServRequest {


    private Long baseServTypeid;//baseServ-id
    private Byte servType;//0-baseServ;1-selfServ
    private Long servTimeId;

    private String selfServ;//可能为id，也可能为文字

    private String sname;
    private String stel;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
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

    public Byte getServType() {
        return servType;
    }

    public void setServType(Byte servType) {
        this.servType = servType;
    }


    public Long getServTimeId() {
        return servTimeId;
    }

    public void setServTimeId(Long servTimeId) {
        this.servTimeId = servTimeId;
    }
}
