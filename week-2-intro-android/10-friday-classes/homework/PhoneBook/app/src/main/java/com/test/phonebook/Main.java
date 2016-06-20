package com.test.phonebook;

import java.util.ArrayList;

/**
 * Created by Jon Kim on 6/19/16.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Contact> existingContacts = returnFakeContacts();

        PhoneBook iPhoneBook = new PhoneBook(existingContacts);

        AndroidPhoneBook androidBook = new AndroidPhoneBook(2.0f);

        boolean androidSupport = androidBook.support();

        if(androidSupport){
            for(Contact contact:iPhoneBook.getContactList()){
                androidBook.addContact(contact);
            }
        }else{
            System.out.println("Version not supported");
        }

        for (Contact contact : iPhoneBook.getContactList()) {
            androidBook.addContact(contact);
        }

        for (Contact contact : androidBook.getContactList()){
            iPhoneBook.removeContact(contact);
        }
    }


    private static ArrayList<Contact> returnFakeContacts() {
        ArrayList<Contact> fakeContactList = new ArrayList<>();

        fakeContactList.add(new Contact("Jon", "423 123 5634"));
        fakeContactList.add(new Contact("Tommy", "343 234 5345"));

        return fakeContactList;
    }
}
