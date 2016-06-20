package ly.generalassemb.drewmahrt.subclassinglab;

import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/20/16.
 */

public class Zoo {
    private  static ArrayList<Animal> mAllAnimalsList;

    public Zoo() {
        mAllAnimalsList = new ArrayList<Animal>();
    }
    public static void addAnimal(Animal newAnimal){
        mAllAnimalsList.add(newAnimal);
    }
    public static void removeAnimal(Animal killAnimal){
        mAllAnimalsList.remove(killAnimal);
    }

    public static void setmAllAnimalsList(ArrayList<Animal> mAllAnimalsList) {
        Zoo.mAllAnimalsList = mAllAnimalsList;
    }

    public static ArrayList<Animal> getmAllAnimalsList() {

        return mAllAnimalsList;
    }
}
