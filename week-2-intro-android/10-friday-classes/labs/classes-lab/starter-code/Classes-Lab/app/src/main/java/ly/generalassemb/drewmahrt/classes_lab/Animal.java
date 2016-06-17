package ly.generalassemb.drewmahrt.classes_lab;

public class Animal {
    int numLegs;
    int topSpeed;
    boolean isEndangered;
    String name;

    public Animal(int numLegs, int topSpeed, boolean isEndangered, String name){

        this.numLegs = numLegs;
        this.topSpeed = topSpeed;
        this.isEndangered = isEndangered;
        this.name = name;

    }//created setters and getters to set and get variables
    public int getNumLegs(){
        return numLegs;
    }
    public void setNumLegs(int numLegs){
        this.numLegs=numLegs;
    }
    public int getTopSpeed(){
        return topSpeed;
    }
    public void setTopSpeed(int topSpeed){
        this.topSpeed=topSpeed;
    }
    public boolean isEndangered(){
        return isEndangered;
    }
    public void setisEndangered(boolean endangered ){
        this.isEndangered=endangered;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

}