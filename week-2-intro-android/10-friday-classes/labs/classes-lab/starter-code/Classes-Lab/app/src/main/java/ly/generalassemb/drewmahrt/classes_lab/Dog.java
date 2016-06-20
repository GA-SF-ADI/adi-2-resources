package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by Jon Kim on 6/17/16.
 */
public class Dog extends Mammal {
    String breed;

    public Dog(int numLegs, int topSpeed, boolean isEndangered, String name, int weight, String breed) {
        super(numLegs, topSpeed, isEndangered, name, weight);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
