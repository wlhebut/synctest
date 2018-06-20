package com.huntech.pvs.model.services;

public class ServManGps {
    private Long id;

    private Long servManid;

    private String longitude;//经度

    private String latitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServManid() {
        return servManid;
    }

    public void setServManid(Long servManid) {
        this.servManid = servManid;
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
}