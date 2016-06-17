package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by nolbertoarroyo on 6/17/16.
 */
public class Snake extends Reptile {
    private int length;
    private boolean rattles;


    public Snake(int numLegs, int topSpeed, boolean isEndangered, String name, String iSay, boolean hasScales, boolean isPoisonous,int length, boolean rattles) {
        super(numLegs, topSpeed, isEndangered, name, iSay, hasScales, isPoisonous);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isRattles() {
        return rattles;
    }

    public void setRattles(boolean rattles) {
        this.rattles = rattles;
    }
}
