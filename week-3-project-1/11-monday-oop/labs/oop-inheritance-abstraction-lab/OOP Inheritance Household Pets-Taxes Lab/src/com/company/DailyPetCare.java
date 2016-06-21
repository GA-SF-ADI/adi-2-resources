package com.company;

/**
 * Created by LangstonSmith on 6/20/16.
 */
public class DailyPetCare extends AbstractPetTreatment {

    @Override
    public String feedPet() {
        return "feeding the pet";
    }

    @Override
    public String playWithPet() {
        return "playing with the pet";
    }

    @Override
    public String groomPet() {
        return "grooming the pet";
    }

    protected String totalPetCareTrifecta(){

        return feedPet() + ", " + playWithPet() + ", and " + groomPet() + " have all been done!";


    }


}
