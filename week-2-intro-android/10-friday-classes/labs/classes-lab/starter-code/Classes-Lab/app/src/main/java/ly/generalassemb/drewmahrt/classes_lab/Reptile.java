package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by Jon Kim on 6/17/16.
 */
public class Reptile extends Animal{
    boolean shell;

    public Reptile(int numLegs, int topSpeed, boolean isEndangered, String name, boolean shell) {
        super(numLegs, topSpeed, isEndangered, name);
        this.shell = shell;
    }

    public boolean isShell() {
        return shell;
    }

    public void setShell(boolean shell) {
        this.shell = shell;
    }
}
