package ly.generalassemb.drewmahrt.classes_lab;

/**
 * Created by NehaRege on 6/17/16.
 */
public class Mammal2 extends Mammal1 {
    int age;

    public Mammal2(int numLegs, int topSpeed, boolean isEndangered, String name, int length, int age) {
        super(numLegs, topSpeed, isEndangered, name, length);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void print(){
        System.out.println("The mammal2 name is: "+name+"\nLength: "+length+"\n Age: "+age);
    }
}
