package com.test.phonebookhw;

import java.util.ArrayList;

/**
 * Created by audreyeso on 6/18/16.
 */
    public class PhoneBook {
    private ArrayList<Contact> contactList;
    private String phoneBookType = "phonebook";
//This class was trickier because of the ArrayList... had to look it up// was not sure how to do it

    public PhoneBook() {
        //no contacts!
        contactList = new ArrayList<>();
    }

    public PhoneBook(ArrayList<Contact> contactList, String phoneBookType) {
        this.contactList = contactList;
        this.phoneBookType = phoneBookType;
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

    public void setPhoneBookType (String phoneBookType) {

    }

    public String getPhoneBookType () {
        return phoneBookType;
    }

}

