package com.huntech.pvs.view.sys;

import java.io.Serializable;

public class BaiduMapRightView implements Serializable{
    private Long sid;

    private String key;

    private String value;

    private Long orderby;

    private Long menuSid;

    private String unit;

    private String menuKey;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Long getOrderby() {
        return orderby;
    }

    public void setOrderby(Long orderby) {
        this.orderby = orderby;
    }

    public Long getMenuSid() {
        return menuSid;
    }

    public void setMenuSid(Long menuSid) {
        this.menuSid = menuSid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey == null ? null : menuKey.trim();
    }
}