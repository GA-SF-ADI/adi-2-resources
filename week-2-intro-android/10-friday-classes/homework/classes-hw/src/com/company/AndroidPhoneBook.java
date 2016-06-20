package com.company;

import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 6/19/16.
 */
public class AndroidPhoneBook extends PhoneBook {
    private float androidVersion;
    private String type = "Android";


    public AndroidPhoneBook(float androidVersion){
        super();
        setPhoneBookType(type);
        this.androidVersion = androidVersion;
    }

    public AndroidPhoneBook(ArrayList<Contact> contactsList, float androidVersion, String phoneBookType) {
        super(contactsList);
        setPhoneBookType(type);
        this.androidVersion = androidVersion;


    }

    public void androidVersion(){

        if (androidVersion>4.0f){
            System.out.println("Your android version is supported");
        }else{
            System.out.print("Your android version is not supported");
        }
    }
}
