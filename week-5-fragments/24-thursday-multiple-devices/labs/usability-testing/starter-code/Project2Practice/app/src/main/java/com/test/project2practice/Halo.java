package com.test.project2practice;

/**
 * Created by audreyeso on 7/7/16.
 */
public class Halo extends Diamond {

    private String cut;
    private String clarity;
    private String color;
    private String style = "halo";

    public Halo(String giaReportNum, String style, String cost, String cut, String clarity, String color) {
        super(giaReportNum, style, cost);
        this.cut = cut;
        this.clarity = clarity;
        this.color = color;
    }

    public String getClarity() {
        return clarity;
    }

    public void setClarity(String clarity) {
        this.clarity = clarity;
    }

    public String getCut() {
        return cut;
    }

    public void setCut(String cut) {
        this.cut = cut;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String getStyle() {
        return style;
    }

    @Override
    public void setStyle(String style) {
        this.style = style;
    }

}

