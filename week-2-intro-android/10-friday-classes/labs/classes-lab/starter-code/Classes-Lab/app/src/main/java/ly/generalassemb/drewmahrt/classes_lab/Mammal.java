package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by LangstonSmith on 6/17/16.
 */
public class Mammal extends Animal {

    int numberOfOffSpring;

    String milk;

    public Mammal(int numLegs, int topSpeed, boolean isEndangered, String name, int numberOfOffSpring, String milk) {
        super(4, 25, isEndangered, name);
        this.numberOfOffSpring = numberOfOffSpring;
        this.milk = milk;
    }

    public int getNumberOfOffSpring() {
        return numberOfOffSpring;
    }

    public void setNumberOfOffSpring(int numberOfOffSpring) {
        this.numberOfOffSpring = numberOfOffSpring;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }
}
