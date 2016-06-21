package ly.generalassemb.drewmahrt.subclassinglab;

import java.util.ArrayList;

/**
 * Created by audreyeso on 6/20/16.
 */
public class Zoo {

    private static Zoo zoo = null;
    private static ArrayList<Animal> animals;

    public Zoo() {

    }

    public static Zoo getInstance() {
        if(zoo ==null) {
            zoo = new Zoo();
        }
        return zoo;
    }

    public void addAnimal (Animal animal) {
        animals.add(animal);

        //calls the .add method within zoo
        // to add it to array list within zoo
    }

    public ArrayList<Animal> getAnimals () {
        return animals;

        //will return all animals
    }
}

