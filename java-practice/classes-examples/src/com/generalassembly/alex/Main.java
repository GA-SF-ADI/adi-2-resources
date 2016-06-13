package com.generalassembly.alex;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Contact> existingContacts = returnMockContacts();

        // Create iPhone phoneBook that has EXISTING contacts
        PhoneBook iPhoneBook = new PhoneBook(existingContacts);

        // Create Android phoneBook that has NO contacts
        PhoneBook androidBook = new PhoneBook();

        // Get iPhone contacts and copy them to Android phone book
        for (Contact contact : iPhoneBook.getContactsList()){
            androidBook.addContact(contact);
        }

        // Add new contact to Android phoneBook
        androidBook.addContact(new Contact("Andrew", "510-222-2222"));

        // Remove all copied iPhone contacts! We use the android contact list
        for (Contact contact : androidBook.getContactsList()){
            iPhoneBook.removeContact(contact);
        }
    }

    /**
     * Returns a list of fake contacts
     * @return ArrayList<Contact>
     */
    private static ArrayList<Contact> returnMockContacts(){
        ArrayList<Contact> mockContactList = new ArrayList<>();

        // Make a contact that has a last name. Constructor does not take last name so we use the setter.
        Contact contactWithLastName = new Contact("James", "007-007-0070");
        contactWithLastName.setLastName("Bond");
        mockContactList.add(contactWithLastName);

        // Make contacts WITHOUT last names
        mockContactList.add(new Contact("Noelle", "510-999-9999"));
        mockContactList.add(new Contact("Robert", "510-888-8888"));
        mockContactList.add(new Contact("Julia", "510-777-7777"));

        return mockContactList;
    }
}
