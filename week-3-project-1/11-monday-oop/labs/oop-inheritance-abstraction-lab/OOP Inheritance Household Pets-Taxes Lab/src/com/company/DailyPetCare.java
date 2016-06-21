package com.company;

/**
 * Created by LangstonSmith on 6/20/16.
 */
public class DailyPetCare extends AbstractPetTreatment {

    @Override
    public String feedPet() {
        return "Feeding pet";
    }

    @Override
    public String playWithPet() {
        return "Playing with pet";
    }

    @Override
    public String groomPet() {
        return "Grooming the pet";
    }
}
