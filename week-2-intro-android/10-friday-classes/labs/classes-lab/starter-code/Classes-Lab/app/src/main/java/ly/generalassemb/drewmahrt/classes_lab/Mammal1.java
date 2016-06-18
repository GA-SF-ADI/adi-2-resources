package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by NehaRege on 6/17/16.
 */
public class Mammal1 extends Animal {

    int length;

    public Mammal1(int numLegs, int topSpeed, boolean isEndangered, String name, int length) {
        super(numLegs, topSpeed, isEndangered, name);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


    public void print(){
        System.out.println("The mammal1 name is: "+name+"\n Length: "+length);
    }

}
