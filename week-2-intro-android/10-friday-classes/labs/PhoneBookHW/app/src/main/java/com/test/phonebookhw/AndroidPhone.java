package com.test.phonebookhw;

import java.util.ArrayList;

/**
 * Created by audreyeso on 6/19/16.
 */

public class AndroidPhone extends PhoneBook {

    private float androidVersion;
    //private static final String type ="Android";

    public AndroidPhone(ArrayList<Contact> contactList, String phoneBookType,  float androidVersion) {
        super(contactList, phoneBookType);
        phoneBookType = "Android";
        this.androidVersion = androidVersion;

    }

    public float getAndroidVersion () {
        return androidVersion;
    }

    public void setAndroidVersion (float androidVersion) {
        this.androidVersion= androidVersion;
    }

    public boolean checkVersion () {
        if(androidVersion >= 4.0f) {
            return true;
        } else
        return false;
    }


}
