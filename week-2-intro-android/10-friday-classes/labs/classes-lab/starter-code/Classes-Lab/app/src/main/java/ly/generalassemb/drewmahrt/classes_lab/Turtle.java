package ly.generalassemb.drewmahrt.classes_lab;


import static android.R.attr.x;

/**
 * Created by patrickcummins on 6/17/16.
 */

public class Turtle extends Reptile {
    String mTurtle;

    public Turtle(int numLegs, int topSpeed, boolean isEndangered, String name, String turtleType) {
        super(numLegs, topSpeed, isEndangered, name);
        this.mTurtle = turtleType;
    }

    public String getmTurtle() {
        return mTurtle;
    }

    public void setmTurtle(String mTurtle) {
        this.mTurtle = mTurtle;
    }

    @Override
    public String toString() {
        String thisAnimalEndangered;
        if (isEndangered){
            thisAnimalEndangered = "is";

        }else {
            thisAnimalEndangered = "is not";
        }
        return name + " the " + mTurtle+ " has a top speed of " + topSpeed + " mph! It " + thisAnimalEndangered + " endangered and it has " + numLegs + " legs!";

    }
}
