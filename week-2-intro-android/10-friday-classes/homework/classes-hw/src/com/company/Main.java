package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //created an arrayList of contacts for iphone
        ArrayList<Contact> iContacts = new ArrayList<>();
        iContacts.add(new Contact("Robert", "650-704-2233"));
        iContacts.add(new Contact("bert", "650-231-4543"));
        iContacts.add(new Contact("Al", "650-702-3434"));
        iContacts.add(new Contact("Maria", "650-707-3322"));
        iContacts.add(new Contact("Vanessa", "650-707-2211"));


        //changed android contacts from Phonebook to AndroidPhoneBook
	    AndroidPhoneBook androidContacts = new AndroidPhoneBook(2.0f);
        androidContacts.androidVersion();// checking if android version is supported

        // madde iphone phonebook passing it an arraylist of contacts
        PhoneBook iPhoneContacts = new PhoneBook(iContacts);

        //cloned  the iphone contacts to the android contacts
        ArrayList<Contact> droidContacts= (ArrayList<Contact>)iContacts.clone();


        for (Contact contact : androidContacts.getContactsList()){
            iPhoneContacts.removeContact(contact);




        }
    }
}





