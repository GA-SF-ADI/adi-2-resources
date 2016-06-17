package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by LangstonSmith on 6/17/16.
 */
public class Reptile extends Animal {

    String scales;
    int eggs;

    public Reptile(int numLegs, int topSpeed, boolean isEndangered, String name, int eggs, String scales) {
        super(numLegs, topSpeed, isEndangered, name);
        this.eggs = eggs;
        this.scales = scales;

    }

    public String getScales() {
        return scales;
    }

    public void setScales(String scales) {
        this.scales = scales;
    }

    public int getEggs() {
        return eggs;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }
}
