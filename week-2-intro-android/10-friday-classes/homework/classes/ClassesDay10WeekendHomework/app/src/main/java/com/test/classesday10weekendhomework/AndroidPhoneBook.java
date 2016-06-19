package com.test.classesday10weekendhomework;

import java.util.List;

/**
 * Created by LangstonSmith on 6/18/16.
 */
public class AndroidPhoneBook extends PhoneBook {


    private float androidVersion;

    public AndroidPhoneBook(List<Contact> listOfContacts, float androidVersion) {
        super(listOfContacts);
        this.androidVersion = androidVersion;
    }


    public float getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(float androidVersion) {
        this.androidVersion = androidVersion;
    }

    public boolean checkIfAndroidVersionIsSupported() {

        if (androidVersion > 4.0f) {

            return true;

        } else {
            return false;
        }


    }

}
