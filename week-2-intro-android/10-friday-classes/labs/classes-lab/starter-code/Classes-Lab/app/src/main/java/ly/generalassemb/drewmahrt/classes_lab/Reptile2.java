package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by NehaRege on 6/17/16.
 */
public class Reptile2 extends Reptile1 {
    int weight;

    public Reptile2(int numLegs, int topSpeed, boolean isEndangered, String name, String color, int weight) {
        super(numLegs, topSpeed, isEndangered, name, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void print(){
        System.out.println("The reptile2 name is: "+name+"\nColor: "+color+"\nWeight: "+weight);
    }


}
