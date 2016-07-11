package com.company;

import java.util.ArrayList;

/**
 * Created by kitty on 6/19/16.
 */
public class Android_PhoneBook extends PhoneBook {

    private float mVersion;

    public Android_PhoneBook(ArrayList<Contact> mContactList, float version) {
        super(mContactList);
        setPhoneBookType("Android");
        this.mVersion = version;
    }

    public float getVersion() {
        return mVersion;
    }

    public void setVersion(float version) {
        this.mVersion = version;
    }

    boolean isSupported (){
        if(mVersion>4.0f) {
            return true;
        } else return false;
    }
}
