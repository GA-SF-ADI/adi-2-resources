package com.test.phonebook;

import java.util.ArrayList;

/**
 * Created by Jon Kim on 6/19/16.
 */
public class AndroidPhoneBook extends PhoneBook {
    private float androidVersion;
    private String type = "Android";


    public boolean support(){
        if (androidVersion > 4.0f){
            return true;
        } else {
            return false;
        }
    }

    public AndroidPhoneBook(float androidVersion) {
        super();
        setPhoneBookType(type);
        this.androidVersion = androidVersion;
    }

    public AndroidPhoneBook(float androidVersion, ArrayList<Contact> existingContacts){
        super(existingContacts);
        setPhoneBookType(type);
        this.androidVersion = androidVersion;
    }


}
