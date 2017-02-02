package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class TableOfContent {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("pagenum")
    @Expose
    private String pagenum;
    @SerializedName("level")
    @Expose
    private Integer level;

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     * The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     *
     * @return
     * The pagenum
     */
    public String getPagenum() {
        return pagenum;
    }

    /**
     *
     * @param pagenum
     * The pagenum
     */
    public void setPagenum(String pagenum) {
        this.pagenum = pagenum;
    }

    /**
     *
     * @return
     * The level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     *
     * @param level
     * The level
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

}

