package ly.generalassemb.drewmahrt.classes_lab;

public class Animal {
    int numLegs;
    int topSpeed;
    boolean isEndangered;
    String name;

    public Animal(int mLegs, int mSpeed, boolean endangered, String mName){
        //Set properties here
        this.numLegs = mLegs;
        this.topSpeed = mSpeed;
        this.isEndangered = endangered;
        this.name = mName;

    }

    //Put getters and setters here
    public int getNumLegs () {
        return this.numLegs;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public boolean isEndangered() {
        return isEndangered;
    }

    public String getName() {
        return name;
    }

    public void setIsEndangered(boolean endangered) {
        isEndangered = endangered;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
}
