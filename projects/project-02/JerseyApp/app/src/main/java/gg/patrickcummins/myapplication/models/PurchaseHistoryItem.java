package gg.patrickcummins.myapplication.models;

/**
 * Created by patrickcummins on 7/12/16.
 */
public class PurchaseHistoryItem {
    int history_ID;
    double price;
    String date;

    public PurchaseHistoryItem(int history_ID, double price, String date) {

        this.history_ID = history_ID;
        this.price = price;
        this.date = date;
    }

    public int getHistory_ID() {
        return history_ID;
    }

    public void setHistory_ID(int history_ID) {
        this.history_ID = history_ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return getPrice() + " " + getDate() + " ID:" + getHistory_ID();
    }
}
