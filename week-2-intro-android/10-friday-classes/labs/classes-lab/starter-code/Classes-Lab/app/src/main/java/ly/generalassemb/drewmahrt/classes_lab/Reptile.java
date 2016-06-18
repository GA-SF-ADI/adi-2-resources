package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by kitty on 6/17/16.
 */
public class Reptile extends Animal {
    Boolean isUgly;
    Boolean isVenomous;

    public Reptile(int mLegs, int mSpeed, boolean endangered, String mName, Boolean isUgly, Boolean isVenomous) {
        super(mLegs, mSpeed, endangered, mName);
        this.isUgly = isUgly;
        this.isVenomous = isVenomous;
    }

    public Boolean getUgly() {
        return isUgly;
    }

    public void setUgly(Boolean ugly) {
        isUgly = ugly;
    }

    public Boolean getVenomous() {
        return isVenomous;
    }

    public void setVenomous(Boolean venomous) {
        isVenomous = venomous;
    }
}
