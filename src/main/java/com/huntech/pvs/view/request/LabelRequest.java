package com.huntech.pvs.view.request;

public class LabelRequest {
    private String openid;
    private Long id;//对应列表的私服id

    private String servManid;

    private String labelContent;

    private int servStar;

    public int getServStar() {
        return servStar;
    }

    public void setServStar(int servStar) {
        this.servStar = servStar;
    }

    public String getLabelContent() {
        return labelContent;
    }

    public void setLabelContent(String labelContent) {
        this.labelContent = labelContent;
    }

    public String getServManid() {
        return servManid;
    }

    public void setServManid(String servManid) {
        this.servManid = servManid;
    }

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
        this.openid = openid;
    }
}
