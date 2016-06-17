package ly.generalassemb.drewmahrt.classes_lab;

public class Animal {
    protected int numLegs;
    protected int topSpeed;
    protected boolean isEndangered;
    protected String name;
    protected String habitat;

    public Animal(int numLegs, int topSpeed, boolean isEndangered, String name, String habitat){
        //Set properties here

        this.numLegs = numLegs;
        this.topSpeed = topSpeed;
        this.isEndangered = isEndangered;
        this.name = name;
        this.habitat = habitat;


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

    public String getHabitat () {
        return habitat;
    }

    public void setHabitat () {
        this.habitat = habitat;
    }
}


