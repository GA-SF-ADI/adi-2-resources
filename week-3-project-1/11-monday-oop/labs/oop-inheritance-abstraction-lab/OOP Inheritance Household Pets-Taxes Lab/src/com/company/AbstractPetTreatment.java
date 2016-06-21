package com.company;

/**
 * Created by LangstonSmith on 6/20/16.
 */
public abstract class AbstractPetTreatment{


    public abstract String feedPet();

    public abstract String playWithPet();

    public void brushPetTeeth(){

        System.out.println("Brushing in between all of the pet's" +
                " nooks and crannies.");

    }

    public abstract String groomPet();


}
