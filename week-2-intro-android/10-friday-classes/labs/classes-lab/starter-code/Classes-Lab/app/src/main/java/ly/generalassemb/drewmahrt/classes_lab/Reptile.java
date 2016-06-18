package ly.generalassemb.drewmahrt.classes_lab;


import java.io.Serializable;

/**
 * Created by LangstonSmith on 6/17/16.
 */
public class Reptile extends Animal{

    private Boolean scales;
    private int eggs;


    public Reptile(int numLegs, int topSpeed, boolean isEndangered, String name, Boolean scales, int eggs) {
        super(numLegs, topSpeed, isEndangered, name);
        this.scales = scales;
        this.eggs = eggs;
    }

    public Boolean getScales() {
        return scales;
    }

    public void setScales(Boolean scales) {
        this.scales = scales;
    }

    public int getEggs() {
        return eggs;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }
}



