package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by kitty on 6/17/16.
 */
public class Bear extends Mammal {
    private boolean isCarnivorous;
    private int biteForce;

    public Bear(int mSpeed, boolean endangered, String mName, String mColor, boolean isCarnivorous, int mForce) {
        super(mSpeed, endangered, mName, mColor, true);
        this.isCarnivorous = isCarnivorous;
        this.biteForce = mForce;
    }

    public boolean isCarnivorous() {
        return isCarnivorous;
    }

    public void setCarnivorous(boolean carnivorous) {
        isCarnivorous = carnivorous;
    }

    public int getBiteForce() {
        return biteForce;
    }

    public void setBiteForce(int biteForce) {
        this.biteForce = biteForce;
    }

    @Override
    public String toString() {
        return "Bear: "+this.getName();
    }
}
