package com.huntech.pvs.view.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.huntech.pvs.model.services.MyServs;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyServsRequest extends MyServs{
    private String newMyServType;

    public String getNewMyServType() {
        return newMyServType;
    }

    public void setNewMyServType(String newMyServType) {
        this.newMyServType = newMyServType;
    }
}
