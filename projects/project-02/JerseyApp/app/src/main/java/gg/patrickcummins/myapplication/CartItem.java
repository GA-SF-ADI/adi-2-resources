package gg.patrickcummins.myapplication;



/**
 * Created by patrickcummins on 7/12/16.
 */
public class CartItem {
    String playerName, color, size;
    int picture, quantity;
    double price;
    public CartItem(String playerName, String color, int picture, double price, int quantity, String size) {

        this.playerName = playerName;
        this.color = color;
        this.picture = picture;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
    }
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getPlayerName() + " " + getColor() + " " + getPrice();
    }
}
