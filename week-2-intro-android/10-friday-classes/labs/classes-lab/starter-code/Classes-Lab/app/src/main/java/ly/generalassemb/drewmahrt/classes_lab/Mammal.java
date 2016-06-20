package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by michaeljeffress on 6/20/16.
 */
public class Mammal extends Animal {
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