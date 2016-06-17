package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by nolbertoarroyo on 6/17/16.
 */
public class Mammal extends Animal {
    private boolean fur;





    public Mammal(int numLegs, int topSpeed, boolean isEndangered, String name, boolean fur){
        super(numLegs,topSpeed,isEndangered,name);
        this.fur=fur;
    }

    public boolean isFur() {
        return fur;
    }

    public void setFur(boolean fur) {
        this.fur = fur;
    }
}
