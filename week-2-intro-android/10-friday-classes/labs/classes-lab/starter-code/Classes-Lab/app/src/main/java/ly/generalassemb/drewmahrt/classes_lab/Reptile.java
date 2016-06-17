package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by nolbertoarroyo on 6/17/16.
 */
public class Reptile  extends Animal{
    private boolean hasScales;
    private boolean isPoisonous;
    private String iSay;

    public Reptile(int numLegs, int topSpeed, boolean isEndangered, String name, String iSay,boolean hasScales, boolean isPoisonous) {
        super(numLegs, topSpeed, isEndangered, name);
        this.iSay = iSay;
        this.isPoisonous = isPoisonous;
        this.iSay = iSay;


    }


    public boolean isPoisonous() {
        return isPoisonous;
    }

    public void setPoisonous(boolean poisonous) {
        isPoisonous = poisonous;
    }

    public boolean isHasScales() {
        return hasScales;
    }

    public void setHasScales(boolean hasScales) {
        this.hasScales = hasScales;
    }

    public String getiSay() {
        return iSay;
    }

    public void setiSay(String iSay) {
        this.iSay = iSay;
    }
}
