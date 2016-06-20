package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by Jon Kim on 6/17/16.
 */
public class Mammal extends Animal {
    int weight;

    public Mammal(int numLegs, int topSpeed, boolean isEndangered, String name, int weight) {
        super(numLegs, topSpeed, isEndangered, name);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
