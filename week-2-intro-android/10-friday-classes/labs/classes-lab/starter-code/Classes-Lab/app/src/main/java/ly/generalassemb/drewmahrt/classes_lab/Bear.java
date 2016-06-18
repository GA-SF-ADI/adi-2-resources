package ly.generalassemb.drewmahrt.classes_lab;


/**
 * Created by LangstonSmith on 6/17/16.
 */
public class Bear extends Mammal {
    private String fur;

    private String claws;

    public Bear(int numLegs, int topSpeed, boolean isEndangered, String name, int numberOfOffSpring, String milk, String fur, String claws) {
        super(numLegs, topSpeed, isEndangered, name, numberOfOffSpring, milk);
        this.fur = fur;
        this.claws = claws;
    }

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    public String getClaws() {
        return claws;
    }

    public void setClaws(String claws) {
        this.claws = claws;
    }
}