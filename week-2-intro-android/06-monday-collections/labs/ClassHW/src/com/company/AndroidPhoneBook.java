package com.company;

import java.util.ArrayList;

/**
 * Created by sterlinggerritz on 6/19/16.
 */
public class AndroidPhoneBook extends PhoneBook {
    public float version;

    public AndroidPhoneBook(float version) {
        setPhoneBookType("Android");
        this.version = version;
    }


    public AndroidPhoneBook(ArrayList<Contacts> listOfContacts) {
        super(listOfContacts);
    }

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public boolean checkVersion(float version) {
        if (version >= 4.0f) {
            //Version is not supported
            return false;
        } else {
            return true;
        }
    }
}
