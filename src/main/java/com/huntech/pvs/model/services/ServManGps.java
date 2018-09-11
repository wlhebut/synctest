package com.huntech.pvs.model.services;

import java.util.Date;

public class ServManGps {
    private Long id;

    private String servManid;

    private String longitude;

    private String latitude;

    private Date ddate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServManid() {
        return servManid;
    }

    public void setServManid(String servManid) {
        this.servManid = servManid == null ? null : servManid.trim();
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

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }
}