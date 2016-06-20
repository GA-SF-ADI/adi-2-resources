package com.company;

import java.util.ArrayList;

/**
 * Created by nolbertoarroyo on 6/19/16.
 */
public class PhoneBook {
    private String phoneBookType= "phoneBook";


    public String getPhoneBookType() {
        return phoneBookType;
    }

    public void setPhoneBookType(String phoneBookType) {
        this.phoneBookType = phoneBookType;
    }

    private ArrayList<Contact> contactsList;


    public PhoneBook() {


        contactsList = new ArrayList<>();
    }

    public PhoneBook(ArrayList<Contact> contactsList) {

        this.contactsList = contactsList;

    }

    public void removeContact(Contact contact) {
        contactsList.remove(contact);

    }

    public void addContact(Contact contact) {
        contactsList.add(contact);
    }

    public ArrayList<Contact> getContactsList() {
        return contactsList;
    }
}
