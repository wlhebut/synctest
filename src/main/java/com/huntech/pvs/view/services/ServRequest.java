package com.huntech.pvs.view.services;

import com.huntech.pvs.view.request.PageRequest;

public class ServRequest extends PageRequest {

    private Long id;

    private Long baseservTypeid;//baseServ-id
    private Long servManid;
    private Long servType;//0-baseServ;1-selfServ
    private   Byte state;//状态1
    private String longitude;//经度

    private String latitude;//纬度

    private Integer zoom;//更改为用户距离：默认为

    private String  openid;

    private String reLocation;//重新定位--如果客户重新选择了定位，那么就用客户的定位（设置为1），这个值默认为0.

    public String getReLocation() {
        return reLocation;
    }

    public void setReLocation(String reLocation) {
        this.reLocation = reLocation;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
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

    public Integer getZoom() {
        return zoom;
    }

    public void setZoom(Integer zoom) {
        this.zoom = zoom;
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

    public Long getServType() {
        return servType;
    }

    public void setServType(Long servType) {
        this.servType = servType;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}
