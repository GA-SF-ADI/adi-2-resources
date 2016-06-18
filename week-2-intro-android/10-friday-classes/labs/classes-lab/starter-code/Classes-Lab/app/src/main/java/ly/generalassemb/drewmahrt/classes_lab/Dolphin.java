package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by LangstonSmith on 6/17/16.
 */
public class Dolphin extends Mammal {

    boolean blowhole;

    String dorsalFin;

    public Dolphin(int numLegs, int topSpeed, boolean isEndangered, String name, int numberOfOffSpring, String milk, boolean blowhole, String dorsalFin) {
        super(numLegs, topSpeed, isEndangered, name, numberOfOffSpring, milk);
        this.blowhole = blowhole;
        this.dorsalFin = dorsalFin;
    }

    public boolean isBlowhole() {
        return blowhole;
    }

    public void setBlowhole(boolean blowhole) {
        this.blowhole = blowhole;
    }

    public String getDorsalFin() {
        return dorsalFin;
    }

    public void setDorsalFin(String dorsalFin) {
        this.dorsalFin = dorsalFin;
    }
}
