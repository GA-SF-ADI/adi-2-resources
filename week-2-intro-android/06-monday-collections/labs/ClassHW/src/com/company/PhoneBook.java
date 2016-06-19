package com.company;

import java.util.ArrayList;

/**
 * Created by sterlinggerritz on 6/19/16.
 */

public class PhoneBook {

    ArrayList contacts = new ArrayList();
    private ArrayList<Contacts> listOfContacts = new ArrayList<Contacts>();

    public String getPhoneBookType() {
        return phoneBookType;
    }

    public void setPhoneBookType(String phoneBookType) {
        this.phoneBookType = phoneBookType;
    }

    private String phoneBookType = "phonebook";

    public PhoneBook() {
    }

    public PhoneBook(ArrayList<Contacts> listOfContacts) {
        this.listOfContacts = listOfContacts;
    }

    public ArrayList<Contacts> getContactList(){
        return listOfContacts;

    }
    public void addContact(Contacts newContact){
        listOfContacts.add(newContact);

    }
    public void removeContact(Contacts selectedContact){ //taking in whatever object the user picks from the contact class
        listOfContacts.remove(selectedContact);

    }
}
