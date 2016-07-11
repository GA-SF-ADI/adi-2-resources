package ly.generalassemb.espresso;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/25/16.
 */
public class Transaction implements Serializable {
    private String mDescription;
    private float mAmount;

    private static NumberFormat mFormat = NumberFormat.getCurrencyInstance();

    public Transaction(String description, float amount) {
        this.mDescription = description;
        this.mAmount = amount;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public float getAmount() {
        return mAmount;
    }

    public void setAmount(float mAmount) {
        this.mAmount = mAmount;
    }

    public String getFormattedAmount(){
        return mFormat.format(mAmount);
    }
}
