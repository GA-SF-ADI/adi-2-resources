package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by michaeljeffress on 6/20/16.
 */
public class Reptile extends Animal {
    boolean hasScales;

    public Reptile(boolean hasLegs, int topSpeed, boolean isEndangered, String name){
        super(topSpeed, isEndangered, name);
        this.hasScales = hasLegs;
    }

    public boolean getHasScales() {
        return hasScales;
    }

    public void setHasScales(boolean hasScales) {
        this.hasScales = hasScales;
    }
}
