package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Identifiers {

    @SerializedName("google")
    @Expose
    private List<String> google = new ArrayList<String>();
    @SerializedName("lccn")
    @Expose
    private List<String> lccn = new ArrayList<String>();
    @SerializedName("openlibrary")
    @Expose
    private List<String> openlibrary = new ArrayList<String>();
    @SerializedName("isbn_13")
    @Expose
    private List<String> isbn13 = new ArrayList<String>();
    @SerializedName("amazon")
    @Expose
    private List<String> amazon = new ArrayList<String>();
    @SerializedName("isbn_10")
    @Expose
    private List<String> isbn10 = new ArrayList<String>();
    @SerializedName("oclc")
    @Expose
    private List<String> oclc = new ArrayList<String>();
    @SerializedName("goodreads")
    @Expose
    private List<String> goodreads = new ArrayList<String>();
    @SerializedName("librarything")
    @Expose
    private List<String> librarything = new ArrayList<String>();

    /**
     *
     * @return
     * The google
     */
    public List<String> getGoogle() {
        return google;
    }

    /**
     *
     * @param google
     * The google
     */
    public void setGoogle(List<String> google) {
        this.google = google;
    }

    /**
     *
     * @return
     * The lccn
     */
    public List<String> getLccn() {
        return lccn;
    }

    /**
     *
     * @param lccn
     * The lccn
     */
    public void setLccn(List<String> lccn) {
        this.lccn = lccn;
    }

    /**
     *
     * @return
     * The openlibrary
     */
    public List<String> getOpenlibrary() {
        return openlibrary;
    }

    /**
     *
     * @param openlibrary
     * The openlibrary
     */
    public void setOpenlibrary(List<String> openlibrary) {
        this.openlibrary = openlibrary;
    }

    /**
     *
     * @return
     * The isbn13
     */
    public List<String> getIsbn13() {
        return isbn13;
    }

    /**
     *
     * @param isbn13
     * The isbn_13
     */
    public void setIsbn13(List<String> isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     *
     * @return
     * The amazon
     */
    public List<String> getAmazon() {
        return amazon;
    }

    /**
     *
     * @param amazon
     * The amazon
     */
    public void setAmazon(List<String> amazon) {
        this.amazon = amazon;
    }

    /**
     *
     * @return
     * The isbn10
     */
    public List<String> getIsbn10() {
        return isbn10;
    }

    /**
     *
     * @param isbn10
     * The isbn_10
     */
    public void setIsbn10(List<String> isbn10) {
        this.isbn10 = isbn10;
    }

    /**
     *
     * @return
     * The oclc
     */
    public List<String> getOclc() {
        return oclc;
    }

    /**
     *
     * @param oclc
     * The oclc
     */
    public void setOclc(List<String> oclc) {
        this.oclc = oclc;
    }

    /**
     *
     * @return
     * The goodreads
     */
    public List<String> getGoodreads() {
        return goodreads;
    }

    /**
     *
     * @param goodreads
     * The goodreads
     */
    public void setGoodreads(List<String> goodreads) {
        this.goodreads = goodreads;
    }

    /**
     *
     * @return
     * The librarything
     */
    public List<String> getLibrarything() {
        return librarything;
    }

    /**
     *
     * @param librarything
     * The librarything
     */
    public void setLibrarything(List<String> librarything) {
        this.librarything = librarything;
    }

}