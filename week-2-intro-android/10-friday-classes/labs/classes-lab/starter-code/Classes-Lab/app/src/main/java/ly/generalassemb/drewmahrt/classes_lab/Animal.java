package ly.generalassemb.drewmahrt.classes_lab;

public class Animal {
    int numLegs;
    int topSpeed;
    boolean isEndangered;
    String name;

    public Animal(int numLegs, int topSpeed, boolean isEndangered, String name){
        //Set properties here
        this.numLegs = numLegs;
        this.topSpeed =topSpeed;
        this.isEndangered = isEndangered;
        this.name = name;
    }

    public void setNumLegs(int legs){
        numLegs = legs;


    }
    public void setTopSpeed(int speed){
        topSpeed=speed;
    }
    public void setEndangered(boolean endangered){
        isEndangered = endangered;
    }
    public  void setName(String animalName){
        name = animalName;
    }

    public int getNumLegs(){
        return  numLegs;
    }
    public  int getTopSpeed(){
        return topSpeed;
    }
    public boolean getEndangered(){
        return isEndangered;
    }
    public String getName(){
        return name;
    }
    public String getAnimalNameandSpeedPrint(){
        return "The " + name + " has a top speed of " + topSpeed + " mph!";
    }

    //Put getters and setters here
}
