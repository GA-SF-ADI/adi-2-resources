package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by NehaRege on 6/17/16.
 */
public class Reptile1 extends Animal{
    String color;

    public Reptile1(int numLegs, int topSpeed, boolean isEndangered, String name, String color) {
        super(numLegs, topSpeed, isEndangered, name);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public void print(){
        System.out.println("The reptile1 name is: "+name+"\nColor: "+color);
    }


}
