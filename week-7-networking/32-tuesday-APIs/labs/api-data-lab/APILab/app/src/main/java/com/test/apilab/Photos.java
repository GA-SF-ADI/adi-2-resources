package com.test.apilab;

/**
 * Created by audreyeso on 7/19/16.
 */
public class Photos {
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Photo[] getPhoto() {
        return photo;
    }

    public void setPhoto(Photo[] photo) {
        this.photo = photo;
    }

    private int page;
    private int pages;
    private int perpage;
    private int total;
    private Photo [] photo;
}
