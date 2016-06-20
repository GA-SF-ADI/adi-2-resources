package com.test.phonebook;

import java.util.ArrayList;

/**
 * Created by Jon Kim on 6/19/16.
 */
public class PhoneBook {
    private ArrayList<Contact> contactList;
    private String phoneBookType = "PhoneBook";

    public PhoneBook() {
        contactList = new ArrayList<>();
    }

    public PhoneBook(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public void addContact(Contact newContact){
        contactList.add(newContact);
    }

    public void removeContact(Contact existingContact){
        contactList.remove(existingContact);
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public String getPhoneBookType() {
        return phoneBookType;
    }

    public void setPhoneBookType(String phoneBookType) {
        this.phoneBookType = phoneBookType;
    }
}
