package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by audreyeso on 6/17/16.
 */
public class Chameleon extends Reptile {

    boolean changeColor;

    public Chameleon (int numLegs, int topSpeed, boolean isEndangered, String name, String habitat, String scalesOrShell, boolean changeColor) {
        super(numLegs,topSpeed, isEndangered, name, habitat, scalesOrShell);
        this.changeColor = changeColor;
    }

    public void isAChameleon () {
        System.out.println("Awesome! Chameleon!");
    }
}
