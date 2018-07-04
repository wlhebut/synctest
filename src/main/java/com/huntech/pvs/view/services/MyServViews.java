package com.huntech.pvs.view.services;

import com.huntech.pvs.model.services.MyServs;

import java.util.List;

public class MyServViews {
    private Long myBaseservTypeid;

    private String myServType;

    private List<MyServs> myServs;

    public Long getMyBaseservTypeid() {
        return myBaseservTypeid;
    }

    public void setMyBaseservTypeid(Long myBaseservTypeid) {
        this.myBaseservTypeid = myBaseservTypeid;
    }

    public String getMyServType() {
        return myServType;
    }

    public void setMyServType(String myServType) {
        this.myServType = myServType;
    }

    public List<MyServs> getMyServs() {
        return myServs;
    }

    public void setMyServs(List<MyServs> myServs) {
        this.myServs = myServs;
    }
}
