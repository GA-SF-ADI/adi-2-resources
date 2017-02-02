package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Djvu {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("permission")
    @Expose
    private String permission;

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     *
     * @param permission
     * The permission
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

}