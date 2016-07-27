package com.test.contentproviderslab;

/**
 * Created by audreyeso on 7/27/16.
 */
public class Stock {
    private int id;
    private String name;
    private String stockSymbol;
    private int quantity;

    public Stock(int id, String name, String stockSymbol, int quantity) {
        this.id = id;
        this.name = name;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }
}
