package com.huntech.pvs.view.services;

import java.io.Serializable;

public class UserFrontView implements Serializable{

    private String openid;
    private String onLine;


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOnLine() {
        return onLine;
    }

    public void setOnLine(String onLine) {
        this.onLine = onLine;
    }
}
