package com.test.phonebookhw;

import java.util.ArrayList;

/**
 * Created by audreyeso on 6/18/16.
 */
    public class PhoneBook {
    private ArrayList<Contact> contactList;
//This class was trickier because of the ArrayList... had to look it up// was not sure how to do it

    public PhoneBook() {
        //no contacts!
        contactList = new ArrayList<>();
    }

    public PhoneBook(ArrayList<Contact> contactList) {
        this.contactList = contactList;
        //has contacts
    }

    public void addNewContact (Contact newContact) {
        contactList.add(newContact);

    }

    public void removeContact (Contact oldContact) {
        contactList.remove(oldContact);

    }

    public ArrayList<Contact> getContactsList() {
        return contactList;
    }

}

