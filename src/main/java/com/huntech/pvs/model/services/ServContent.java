package com.huntech.pvs.model.services;

public class ServContent {
    private Long id;

    private Integer servid;//获取私服自增id

    private String name;//页面提交

    private Double unitMoney;//页面提交

    private String unit;//页面提交

    private String note;//页面提交

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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