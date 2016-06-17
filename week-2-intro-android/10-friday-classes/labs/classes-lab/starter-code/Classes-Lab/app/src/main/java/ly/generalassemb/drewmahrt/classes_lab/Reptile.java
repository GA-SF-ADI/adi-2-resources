package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by audreyeso on 6/17/16.
 */
public class Reptile extends Animal {

    String scalesOrShell;

    public Reptile (int numLegs, int topSpeed, boolean isEndangered, String name, String habitat, String scalesOrShell) {
        super (numLegs, topSpeed, isEndangered, name, habitat);
        this.scalesOrShell = scalesOrShell;
    }

    public void isAReptile () {
        System.out.println("That is a mammal and it has " + scalesOrShell);
    }
}
