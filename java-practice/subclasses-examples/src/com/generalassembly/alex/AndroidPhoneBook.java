package com.generalassembly.alex;

import java.util.ArrayList;

/**
 * Class model for an Android phone book which extends PhoneBook
 *
 * Created by alex on 3/5/16.
 */
public class AndroidPhoneBook extends PhoneBook {
    private float androidVersion;
    private static final String type = "Android";

    /**
     * Constructor for creating an Android phone book that at a minimum
     * requires a version of android to be passed in as an argument
     * @param androidVersion
     */
    public AndroidPhoneBook(float androidVersion){
        // call the super class constructor. ie PhoneBook's constructor
        super();
        setPhoneBookType(type);
        this.androidVersion = androidVersion;
    }

    /**
     * Constructor for creating an Android phone book that at a minimum
     * requires a version of android and an existing contactl ist to be
     * passed in as arguments
     * @param existingContacts
     */
    public AndroidPhoneBook(float androidVersion, ArrayList<Contact> existingContacts){
        // call the super class constructor. ie PhoneBook's constructor
        super(existingContacts);
        setPhoneBookType(type);
        this.androidVersion = androidVersion;
    }

    /**
     * Is this phoneBook supported?
     *
     * Return true if androidVersion is > 4.0
     * @return
     */
    public boolean isSupported(){
        if (androidVersion > 4.0f){
            return true;
        } else {
            return false;
        }
    }
}
