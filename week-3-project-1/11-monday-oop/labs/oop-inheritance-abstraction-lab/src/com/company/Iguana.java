
package com.company;

/**
 * Created by sterlinggerritz on 6/20/16.
 */




public class Iguana implements PetInterface {

    @Override
    public void feed() {
        System.out.println("We feed the Iguana crickets and fresh fruit");
    }

    @Override
    public void play() {
        System.out.println("We play with the iguana by petting him");
    }

    @Override
    public void groom() {
        System.out.println("When we groom we scrape off the iguana's old scales");
    }
}
