package com.huntech.pvs.view.services;

public class BaseServTypeView {
    private Integer id;
    private String tname;
    private Integer typeid;
    private Integer sumType;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getSumType() {
        return sumType;
    }

    public void setSumType(Integer sumType) {
        this.sumType = sumType;
    }
}
