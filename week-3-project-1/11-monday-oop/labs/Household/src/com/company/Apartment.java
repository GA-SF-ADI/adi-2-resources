package com.company;

/**
 * Created by audreyeso on 6/20/16.
 */
public class Apartment extends Home implements CareForPet {

    int numberOfAdults;
    int income;
    String pet;
    boolean moreFood;
    boolean morePlay;
    int food;
    int play;
    int groomInt;

    public Apartment(int numberOfAdults, int income, String pet) {
        super(numberOfAdults, income, pet);
    }

    @Override
    public void location() {
        System.out.println("Location: New York");
    }

    @Override
    public void climate() {

        System.out.println("Climate: all seasons");

    }


    @Override
    public void feedPet(boolean moreFood) {
        if (moreFood) {
            food++;
        } else {
            food--;
        }


    }

    @Override
    public void playPet(boolean morePlay) {
        if(morePlay) {
            play++;
        } else {
            play--;
        }


    }

    @Override
    public void groomPet(boolean groom) {
        if(groom) {
            groomInt++;
        } else {
            groomInt++;
        }
    }
}