package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Contact> iphoneContacts = new ArrayList<>();
        iphoneContacts.add(new Contact("Mike","9869235322"));
        iphoneContacts.add(new Contact("lisa","7926183627"));
        iphoneContacts.add(new Contact("Jordan","436891790"));
        iphoneContacts.add(new Contact("kate","1263962927"));
        
        PhoneBook iphone = new PhoneBook(iphoneContacts);
        PhoneBook android = new PhoneBook();

        iphone.toString();
        iphone.print(iphoneContacts);

        for(int i=0;i<iphoneContacts.size();i++){
            System.out.println("**"+iphoneContacts.get(i).getName()+":"+iphoneContacts.get(i).getPhoneNumber());
        }
// copying iphone contacts into android contacts

//        Contact contact;
//        for(int i =0;i<iphone.getListSize();i++){
//            contact=iphone.getContactList();
//            android.addContact(contact);
//

        for (Contact contact : iphone.getContactList()){
            android.addContact(contact);
        }

        //removing  iphone contacts

        for (int i=0;i<android.getListSize();i++){
            iphone.removeContact(android.getContact(i));
        }

        //2nd lab

        AndroidPhoneBook androidBook= new AndroidPhoneBook(7.0f);

        if(androidBook.isVersionSupported()){
            for (Contact contact: iphone.getContactList()) {
                androidBook.addContact(contact);
            }
        }
        else System.out.println("Version not supported");

    }
}
