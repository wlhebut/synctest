package com.huntech.pvs.view.request;

public class MyServsDelRequest {

    private Long myBaseservTypeid;//类别
    private Long id;//私服员

    private String openid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Long getMyBaseservTypeid() {
        return myBaseservTypeid;
    }

    public void setMyBaseservTypeid(Long myBaseservTypeid) {
        this.myBaseservTypeid = myBaseservTypeid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
