package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by audreyeso on 6/17/16.
 */
public class SeaOtter extends Mammals {

    String webbedFeet;

        public SeaOtter (int numLegs,int topSpeed, boolean isEndangered, String name, String habitat, String hairOrFur, String webbedFeet ) {
            super (numLegs, topSpeed, isEndangered, name, habitat,hairOrFur);
            this.webbedFeet = webbedFeet;

    }

    public void thisIsASeaOtter () {
        System.out.println("Sea Otter! Cool!");
    }
}
