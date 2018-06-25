package com.huntech.pvs.model.services;

public class ServContent {
    private Long id;

    private Integer servid;

    private String cname;

    private Double unitMoney;

    private String unit;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getServid() {
        return servid;
    }

    public void setServid(Integer servid) {
        this.servid = servid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Double getUnitMoney() {
        return unitMoney;
    }

    public void setUnitMoney(Double unitMoney) {
        this.unitMoney = unitMoney;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}