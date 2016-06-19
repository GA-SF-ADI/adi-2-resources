package com.test.classesday10weekendhomework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LangstonSmith on 6/18/16.
 */
public class PhoneBook {

    private String phoneBookType = "phoneBook";



    private List<Contact> listOfContacts = new ArrayList<Contact>();

//    constructor that takes a contact list

    public PhoneBook(List<Contact> listOfContacts) {
        this.listOfContacts = listOfContacts;
    }


//    constructor that takes no contact list

    public PhoneBook() {

    }

//    3 required methods

    public void removeContact(Contact currentContact) {

        listOfContacts.remove(currentContact);
    }


    public void addContact(Contact newContact) {

        listOfContacts.add(newContact);

    }

    public List<Contact> getContactsList() {
        return listOfContacts;
    }

    public String getPhoneBookType() {
        return phoneBookType;
    }

    public void setPhoneBookType(String phoneBookType) {
        this.phoneBookType = phoneBookType;
    }
}
