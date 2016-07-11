package com.company;

/**
 * Created by LangstonSmith on 6/20/16.
 */
public class DailyPetCare extends AbstractPetTreatment {


    @Override
    public String feedPet() {
        return "feeding the ";
    }

    @Override
    public String playWithPet() {
        return "playing with the ";
    }

    @Override
    public String groomPet() {
        return "grooming the ";
    }


    protected String totalPetCareTrifecta() {

            return feedPet() + ", " + playWithPet() + ", and " + groomPet();
        }

    }

