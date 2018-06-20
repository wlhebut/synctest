package com.huntech.pvs.view.request;

public class PageRequest {
    /**
     * 页编号 : 第几页
     */
    protected int pageNo = 1;
    /**
     * 页大小 : 每页的数量
     */
    protected int pageSize = 10;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
