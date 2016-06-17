package ly.generalassemb.drewmahrt.classes_lab;

public class Animal{
    int numLegs;
    int topSpeed;
    boolean isEndangered;
    String name;

    public Animal(int numLegs,int topSpeed,boolean isEndangered,String name){
        this.numLegs = numLegs;
        this.topSpeed = topSpeed;
        this.isEndangered = isEndangered;
        this.name = name;
    }

    public int getNumLegs(){
        return numLegs;
    }

    public int getTopSpeed(){
        return topSpeed;
    }

    public boolean isEndangered(){
        return isEndangered;
    }

    public String getName(){
        return name;
    }

    public void setNumLegs(int numLegs){
        this.numLegs=numLegs;
    }

    public void setTopSpeed(int topSpeed){
        this.topSpeed=topSpeed;
    }

    public  void setIsEndangered(boolean isEndangered){
        this.isEndangered=isEndangered;
    }

    public void setName(String name){
        this.name=name;
    }

    public String printMyAnimalProperties(Animal animal) {

        return "Animal name is : " + name+". It has "+numLegs+" legs and a speed of "+topSpeed+" mph";
    }
}