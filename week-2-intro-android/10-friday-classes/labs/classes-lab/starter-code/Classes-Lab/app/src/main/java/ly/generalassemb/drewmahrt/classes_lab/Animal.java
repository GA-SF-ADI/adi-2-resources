package ly.generalassemb.drewmahrt.classes_lab;

import java.io.Serializable;

public class Animal implements Serializable {
    private int numLegs;
    private int topSpeed;
    private boolean isEndangered;
    private String name;

    public Animal(int numLegs, int topSpeed, boolean isEndangered, String name){
        //Set properties here

        this.numLegs = numLegs;

        this.topSpeed = topSpeed;

        this.name = name;

        this.isEndangered = isEndangered;


    }


    // Serialization
    private static final long serialVersionUID = 7526472295622776147L;


    //Put getters and setters here


    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEndangered() {
        return isEndangered;
    }

    public void setIsEndangered(boolean isEndangered) {
        this.isEndangered = isEndangered;
    }
}
