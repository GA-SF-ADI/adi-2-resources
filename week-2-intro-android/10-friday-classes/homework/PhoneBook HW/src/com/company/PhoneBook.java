package com.company;

import java.util.ArrayList;

/**
 * Created by kitty on 6/19/16.
 */
public class PhoneBook {

    private ArrayList<Contact> mContactList;
    private String phoneBookType;

    public PhoneBook(ArrayList<Contact> mContactList) {
        this.mContactList = mContactList;
        this.phoneBookType = "phoneBook";
    }

    public ArrayList<Contact> getContactList() {
        return mContactList;
    }

    public void removeContact(int contactInt) {
        mContactList.remove(contactInt);
    }

    public void addContact(Contact toAdd){
        mContactList.add(toAdd);
    }

    public void addContact(String firstName, String lastName, String mobile, String home){
        Contact toAdd = new Contact(" ", " ", " ", " ");
        toAdd.setmFirstName(firstName);
        toAdd.setmLastName(lastName);
        toAdd.setmMobile(mobile);
        toAdd.setmHome(home);
    }

    public String getPhoneBookType() {
        return phoneBookType;
    }

    public void setPhoneBookType(String phoneBookType) {
        this.phoneBookType = phoneBookType;
    }
}
