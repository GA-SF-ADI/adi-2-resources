package com.company;

import java.util.ArrayList;

/**
 * Created by NehaRege on 6/18/16.
 */
public class PhoneBook {

    private ArrayList<Contact> contactList = new ArrayList<Contact>();
    private String phoneBookType;

//    public PhoneBook(){
//        super();
//    }

    public PhoneBook(ArrayList<Contact> contactList) {
        this.contactList = contactList;
    }

    public PhoneBook() {}

    public void removeContact(Contact contactToRemove){
        contactList.remove(contactToRemove);
    }

    public void addContact(Contact contactToAdd){
        contactList.add(contactToAdd);
    }

    public ArrayList<Contact> getContactList(){
        return contactList;
    }

    public int getListSize(){
        return contactList.size();
    }

    public Contact getContact(int index){
        return contactList.get(index);
    }

    public void print(ArrayList<Contact> contactList){
        System.out.println(contactList);
    }

    public void print(){
        System.out.println(contactList);
    }

    @Override
    public String toString(){
        return "The list is:"+contactList+"";
    }

    public void setPhoneBookType(String phoneBookType){
        this.phoneBookType=phoneBookType;
    }

    public String getPhoneBookType(){
        return  phoneBookType;
    }

}
