package com.huntech.pvs.view.request;


/**
* servid	必填项	对应列表id
 disserv		 （喜欢：1，不喜欢0）
 attention		红心（关注：1，不关注0 ）
 illegal		违法内容 illegal  （违法：1，不违法0）
 classification		（分类错误1，没错误0）
 openid		用户的openid
*/
public class OptServRequest {
    private Long servid;
    private  Integer disserv;
    private  Integer attention;
    private  Integer illegal;
    private  Integer classification;
    private String openid;


    public Long getServid() {
        return servid;
    }

    public void setServid(Long servid) {
        this.servid = servid;
    }

    public Integer getDisserv() {
        return disserv;
    }

    public void setDisserv(Integer disserv) {
        this.disserv = disserv;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getIllegal() {
        return illegal;
    }

    public void setIllegal(Integer illegal) {
        this.illegal = illegal;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
