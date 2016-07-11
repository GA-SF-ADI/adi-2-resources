package com.company;

import java.util.ArrayList;

/**
 * Created by NehaRege on 6/19/16.
 */
public class AndroidPhoneBook extends PhoneBook{
    private float androidVersion;

    public AndroidPhoneBook(ArrayList<Contact> contactList, float androidVersion) {
        super(contactList);
        setPhoneBookType("Android");
        this.androidVersion = androidVersion;
    }

    public AndroidPhoneBook(float androidVersion) {
        super();
        setPhoneBookType("Android");
        this.androidVersion = androidVersion;
    }

    public boolean isVersionSupported(){
        return (androidVersion>4.0f);
    }

}
