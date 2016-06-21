package ly.generalassemb.drewmahrt.subclassinglab;

import java.util.ArrayList;

/**
 * Created by sterlinggerritz on 6/20/16.
 */
public class Zoo {
    private static Zoo zoo;

    private static ArrayList<Animal> animals;
    private Zoo() {
        animals = new ArrayList<>();
    }

    public static Zoo getInstance() {
        if(zoo ==null)
            zoo = new Zoo();
        return zoo;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }


}
