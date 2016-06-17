package ly.generalassemb.drewmahrt.classes_lab;


import static android.R.attr.top;

/**
 * Created by patrickcummins on 6/17/16.
 */

public class Doggo extends Mammal {
    String mDoggo;
    public Doggo(int numLegs, int topSpeed, boolean isEndangered, String name, String doggo) {
        super(numLegs, topSpeed, isEndangered, name);
        this.mDoggo = doggo;
    }

    public String getmDoggo() {
        return mDoggo;
    }

    public void setmDoggo(String mDoggo) {
        this.mDoggo = mDoggo;
    }

    @Override
    public String toString() {
        String thisAnimalEndangered;
        if (isEndangered){
            thisAnimalEndangered = "is";

        }else {
            thisAnimalEndangered = "is not";
        }
        return name + " the " +mDoggo+ " has a top speed of " + topSpeed + " mph! It " + thisAnimalEndangered + " endangered and it has " + numLegs + " legs!";
    }
}
