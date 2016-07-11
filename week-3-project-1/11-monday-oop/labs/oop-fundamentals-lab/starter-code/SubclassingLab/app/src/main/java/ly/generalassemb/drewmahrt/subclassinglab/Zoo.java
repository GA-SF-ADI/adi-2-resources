package ly.generalassemb.drewmahrt.subclassinglab;

import java.util.ArrayList;

/**
 * Created by kitty on 6/20/16.
 */
public class Zoo {

    private static Zoo zoo = null;
    private static ArrayList<Animal> animalList;

    public Zoo() {
        animalList = new ArrayList<>();
    }

    public static ArrayList<Animal> getAnimalList() {
        return animalList;
    }

    public static Zoo getInstance(){
        if(zoo == null) {
            zoo = new Zoo();
        }
        return zoo;
    }

    public void addAnimal(Animal animal){
        animalList.add(animal);
    }

    //remove the last added animal
    public void removeAnimal(){
        animalList.remove(animalList.size()-1);
    }

}
