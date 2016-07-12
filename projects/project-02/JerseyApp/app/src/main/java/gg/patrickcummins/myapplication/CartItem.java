package gg.patrickcummins.myapplication;



/**
 * Created by patrickcummins on 7/12/16.
 */
public class CartItem {
    String playerName, color;
    int picture;
    double price;
    public CartItem(String playerName, String color, int picture, double price) {

        this.playerName = playerName;
        this.color = color;
        this.picture = picture;
        this.price = price;
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

    @Override
    public String toString() {
        return getPlayerName() + " " + getColor() + " " + getPrice();
    }
}
