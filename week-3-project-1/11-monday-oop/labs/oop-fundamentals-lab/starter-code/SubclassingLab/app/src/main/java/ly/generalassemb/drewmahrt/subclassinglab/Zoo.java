package ly.generalassemb.drewmahrt.subclassinglab;

import java.util.ArrayList;

/**
 * Created by NehaRege on 6/20/16.
 */
public class Zoo {

    public static Zoo zoo;
    ArrayList<Animal> zooAnimalList;

    public Zoo(){
        zooAnimalList = new ArrayList<Animal>();
    }

    public static Zoo getInstance(){
        if (zoo==null){
            zoo = new Zoo();
        }
        return zoo;
    }

    public void addAnimal (Animal animalName){
        zooAnimalList.add(animalName);
    }


    public ArrayList<Animal> getZooAnimalList(){
        return zooAnimalList;
    }



}
