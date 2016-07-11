package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by michaeljeffress on 6/19/16.
 */
public class Reptile extends Animal {
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

