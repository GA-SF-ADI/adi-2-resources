package ly.generalassemb.drewmahrt.classes_lab;

public class Animal {
    int numLegs;
    int topSpeed;
    boolean isEndangered;
    String name;

    public Animal(int numLegs, int topSpeed, boolean isEndangered, String name){
        //Set properties here

        this.numLegs = numLegs;

        this.topSpeed = topSpeed;

        this.name = name;

        this.isEndangered = isEndangered;


    }

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
