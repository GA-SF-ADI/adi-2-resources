package ly.generalassemb.drewmahrt.subclassinglab;

import java.util.ArrayList;

/**
 * Created by Jon Kim on 6/20/16.
 */
public class Zoo {
    private static Zoo zoo = null;
    private static ArrayList<Animal> animals;

    public static Zoo getInstance(){
        if(zoo == null){
            zoo = new Zoo();
        }
        return zoo;
    }

    public Zoo() {
        animals = new ArrayList<Animal>();
    }

    public static ArrayList<Animal> getAnimals() {
        return animals;
    }

    public static void setAnimals(ArrayList<Animal> animals) {
        Zoo.animals = animals;
    }

    public static void addAnimal(Animal animal){
        animals.add(animal);
    }




}




