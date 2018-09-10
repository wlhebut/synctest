package com.huntech.pvs.model.address;

import java.util.Date;

public class Address {
    private Long id;

    private String openid;///

    private String addr;//具体的楼

    private Byte addrType;

    private Date ddate;

    private String longitude;//

    private String latitude;//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Byte getAddrType() {
        return addrType;
    }

    public void setAddrType(Byte addrType) {
        this.addrType = addrType;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", addr='" + addr + '\'' +
                ", addrType=" + addrType +
                ", ddate=" + ddate +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}