package com.generalassembly.alex;

import java.util.ArrayList;

/**
 * Class modeling a phone book that holds contacts
 *
 * Created by alex on 3/5/16.
 */
public class PhoneBook {
    private ArrayList<Contact> contactsList;
    private String phoneBookType = "PhoneBook";

    /**
     * PhoneBook object constructor that does not require use to
     * input any contact list
     */
    public PhoneBook(){
        System.out.println("Created empty phone book!\n");
        // Make sure to allocate space for contact list
        contactsList = new ArrayList<>();
    }
    /**
     * PhoneBook object contstructor that requires us to input
     * a contact list
     *
     * @param contactsList
     */
    public PhoneBook(ArrayList<Contact> contactsList){
        // Set the incoming contact list to be our internal contact list
        this.contactsList = contactsList;
        System.out.println("Phone book created with: " + contactsList.size() + " contacts!\n");
    }

    /**
     * Add a new contact to our phone book
     * @param newContact Contact
     */
    public void addContact(Contact newContact){
        contactsList.add(newContact);
        System.out.println("Added new contact: " + newContact.getFirstName() + " " + newContact.getLastName());
    }

    /**
     * Remove an existing contact from our phone book
     * @param existingContact Contact
     */
    public void removeContact(Contact existingContact){
        contactsList.remove(existingContact);
        System.out.println("Removed existing contact: " + existingContact.getFirstName() + " " + existingContact.getLastName());
    }

    /**
     * Get the entire list of contacts for this phone book
     * @return ArrayList<Contact>
     */
    public ArrayList<Contact> getContactsList() {
        return contactsList;
    }

    /**
     * Set phone book type, ie Android or iOS
     * @return String
     */
    public String getPhoneBookType() {
        return phoneBookType;
    }

    /**
     * Get the phone book type, ie Android or iOS
     * @param phoneBookType String
     */
    public void setPhoneBookType(String phoneBookType) {
        this.phoneBookType = phoneBookType;
    }
}
