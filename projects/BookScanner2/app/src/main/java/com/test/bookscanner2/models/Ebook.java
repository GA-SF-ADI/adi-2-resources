package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ebook {

    @SerializedName("formats")
    @Expose
    private Formats formats;
    @SerializedName("checkedout")
    @Expose
    private Boolean checkedout;
    @SerializedName("borrow_url")
    @Expose
    private String borrowUrl;
    @SerializedName("preview_url")
    @Expose
    private String previewUrl;
    @SerializedName("availability")
    @Expose
    private String availability;

    /**
     *
     * @return
     * The formats
     */
    public Formats getFormats() {
        return formats;
    }

    /**
     *
     * @param formats
     * The formats
     */
    public void setFormats(Formats formats) {
        this.formats = formats;
    }

    /**
     *
     * @return
     * The checkedout
     */
    public Boolean getCheckedout() {
        return checkedout;
    }

    /**
     *
     * @param checkedout
     * The checkedout
     */
    public void setCheckedout(Boolean checkedout) {
        this.checkedout = checkedout;
    }

    /**
     *
     * @return
     * The borrowUrl
     */
    public String getBorrowUrl() {
        return borrowUrl;
    }

    /**
     *
     * @param borrowUrl
     * The borrow_url
     */
    public void setBorrowUrl(String borrowUrl) {
        this.borrowUrl = borrowUrl;
    }

    /**
     *
     * @return
     * The previewUrl
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     *
     * @param previewUrl
     * The preview_url
     */
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    /**
     *
     * @return
     * The availability
     */
    public String getAvailability() {
        return availability;
    }

    /**
     *
     * @param availability
     * The availability
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

}