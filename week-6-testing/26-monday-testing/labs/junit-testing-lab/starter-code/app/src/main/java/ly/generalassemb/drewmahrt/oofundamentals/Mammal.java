package ly.generalassemb.drewmahrt.oofundamentals;

/**
 * Created by drewmahrt on 12/7/15.
 */
public abstract class Mammal extends Animal {
    int mNumLegs;

    public Mammal(int numLegs, int topSpeed, boolean isEndangered, String name){
        super(topSpeed, isEndangered, name);
        this.mNumLegs = numLegs;
    }

    public int getNumLegs() {
        return mNumLegs;
    }

    public void setNumLegs(int numLegs) {
        this.mNumLegs = numLegs;
    }
}
