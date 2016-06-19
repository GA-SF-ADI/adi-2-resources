package ly.generalassemb.drewmahrt.classes_lab;

public class Animal {
    int mnumLegs;
    int mtopSpeed;
    boolean misEndangered;
    String mname;

    public Animal(int numLegs, int topSpeed, boolean isEndangered, String name) {
        //Set properties here

        this.mnumLegs = numLegs; //specific instance of animal we have created
        this.mtopSpeed = topSpeed;
        this.misEndangered = isEndangered;
        this.mname = name;

    }
    public void setNumLegs(int numLegs){
        this.mnumLegs = numLegs;
    }

    public int getNumLegs() {
        return mnumLegs;
    }

    public void setTopSpeed(int topSpeed) {
        this.mtopSpeed = topSpeed;
    }
    public int getTopSpeed(){
        return mtopSpeed;
    }
    public void setIsEndangered(boolean isEndangered) {
        this.misEndangered = isEndangered;
    }

    public boolean getIsEndangered(){
        return misEndangered;

    }

    public void setName(String name){
        this.mname = name;
    }

    public String getName(){
        return mname;
    }
}