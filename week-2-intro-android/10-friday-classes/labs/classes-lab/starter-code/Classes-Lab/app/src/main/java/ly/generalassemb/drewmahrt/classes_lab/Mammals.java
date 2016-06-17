package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by audreyeso on 6/17/16.
 */
public class Mammals extends Animal {

    String hairOrFur;

    public Mammals (int numLegs,int topSpeed, boolean isEndangered, String name, String habitat, String hairOrFur ) {
        super (numLegs, topSpeed, isEndangered, name, habitat);
        this.hairOrFur = hairOrFur;
    }

    public void thatIsAMammal () {
        System.out.println("That is a mammal and it has " + hairOrFur);
    }
}
