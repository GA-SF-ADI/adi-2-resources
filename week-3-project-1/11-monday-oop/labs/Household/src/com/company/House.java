package com.company;

/**
 * Created by audreyeso on 6/20/16.
 */
public class House extends Home implements CareForPet {

    int numberOfAdults;
    int income;
    String pet;
    int food;
    int play;
    int groomInt;

    public House(int numberOfAdults, int income, String pet) {
        super(numberOfAdults, income, pet);
    }

    @Override
    public void location() {
        System.out.println("Location: Arizona");

    }

    @Override
    public void climate() {

        System.out.println("Climate: Dry, hot");
    }

    @Override
    public void feedPet(boolean moreFood) {
        if (moreFood) {
            System.out.println("You fed your pet.");
        } else {
            System.out.println("Your pet needs some food!");
        }


    }

    @Override
    public void playPet(boolean morePlay) {
        if (morePlay) {
            System.out.println("You've played with your pet.");
        } else {
            System.out.println("Your pet needs to play.");
        }


        }

    @Override
    public void groomPet(boolean groom) {
        if (groom) {
            System.out.println("You've groomed your pet.");
    } else {
            System.out.println("Your pet needs to be groomed!");
        }


}
}
