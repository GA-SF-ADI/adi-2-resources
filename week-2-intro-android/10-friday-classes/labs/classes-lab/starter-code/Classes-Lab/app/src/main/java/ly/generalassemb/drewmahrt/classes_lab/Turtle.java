package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by Jon Kim on 6/17/16.
 */
public class Turtle extends Reptile {
    int lifeSpan;

    public Turtle(int numLegs, int topSpeed, boolean isEndangered, String name, boolean shell, int lifeSpan) {
        super(numLegs, topSpeed, isEndangered, name, shell);
        this.lifeSpan = lifeSpan;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }
}
