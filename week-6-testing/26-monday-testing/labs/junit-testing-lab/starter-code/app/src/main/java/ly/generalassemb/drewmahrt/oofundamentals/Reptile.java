package ly.generalassemb.drewmahrt.oofundamentals;

/**
 * Created by drewmahrt on 12/7/15.
 */
public abstract class Reptile extends Animal {
    boolean hasShell;

    public Reptile(boolean hasLegs, int topSpeed, boolean isEndangered, String name){
        super(topSpeed, isEndangered, name);
        this.hasShell = hasLegs;
    }

    public boolean getHasShell() {
        return hasShell;
    }

    public void setHasShell(boolean hasShell) {
        this.hasShell = hasShell;
    }
}
