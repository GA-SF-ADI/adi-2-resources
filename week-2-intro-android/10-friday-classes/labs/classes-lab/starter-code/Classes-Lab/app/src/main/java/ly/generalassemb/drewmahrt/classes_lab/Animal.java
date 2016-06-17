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
        this.isEndangered = isEndangered;
        this.name = name;

    }

    //Put getters and setters here

    public int getTopSpeed() {

        return topSpeed;
    }

    public void setTopSpeed (int topSpeed) {
        this.topSpeed = topSpeed;
    }


    public int getNumLegs () {
        return numLegs;
    }

    public void setNumLegs (int numLegs) {
        this.numLegs = numLegs;
    }


    public boolean getEndangered () {
        return isEndangered;
    }

    public void setEndangered (boolean isEndangered) {
        this.isEndangered= isEndangered;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}


