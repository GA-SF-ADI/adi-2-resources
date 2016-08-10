package com.example.michaeljeffress.contentproviderlab;

/**
 * Created by michaeljeffress on 7/27/16.
 */
public class Company {
    private int id;
    private String company;
    private int stockQuantity;

    public Company(int id, String company, int stockQuantity) {
        this.id = id;
        this.company = company;
        this.stockQuantity = stockQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
