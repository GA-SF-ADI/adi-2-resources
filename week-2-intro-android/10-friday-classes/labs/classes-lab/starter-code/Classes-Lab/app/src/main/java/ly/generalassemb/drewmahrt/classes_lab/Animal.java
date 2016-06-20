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

    public String getName(){
        return name;
    }

    public int getTopSpeed(){
        return topSpeed;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setTopSpeed(int topSpeed){
        this.topSpeed = topSpeed;
    }


    //Put getters and setters here
}
