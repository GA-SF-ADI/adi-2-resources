package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //creating contacts
        Contact contact1 = new Contact("John", "Smith", "123-445-6789", " ");
        Contact contact2 = new Contact("Jane", "Doe", "432-567-7654", "123-543-6754");

        //adding contacts to contact list
        ArrayList<Contact> iContactList = new ArrayList<>();
        iContactList.add(contact1);
        iContactList.add(contact2);

        ArrayList<Contact> androidContactList = new ArrayList<>();

        PhoneBook iPhone = new PhoneBook(iContactList);
        Android_PhoneBook androidPhone = new Android_PhoneBook(androidContactList, 2.0f);

        //print both PhoneBooks before copy and delete
        for (int i = 0; i < iPhone.getContactList().size(); i++) {
            System.out.println("iPhone Contact List item "+i+" "+iPhone.getContactList().get(i).getmFirstName()+" "+iPhone.getContactList().get(i).getmLastName());
        }

        for (int i = 0; i < androidPhone.getContactList().size(); i++) {
            System.out.println("androidPhone Contact List item "+i+" "+androidPhone.getContactList().get(i).getmFirstName()+" "+androidPhone.getContactList().get(i).getmLastName());
        }

        if(androidPhone.isSupported()) {
            //copying iPhone contacts to android phone
            for (int i = 0; i < iPhone.getContactList().size(); i++) {
                androidPhone.addContact(iPhone.getContactList().get(i));
            }

            //removing contacts in iPhone
            for (int i = iPhone.getContactList().size() - 1; i >= 0; i--) {
                iPhone.removeContact(i);
            }

            //print both PhoneBooks after copy and delete
            for (int i = 0; i < iPhone.getContactList().size(); i++) {
                System.out.println("iPhone Contact List item " + i + " " + iPhone.getContactList().get(i).getmFirstName() + " " + iPhone.getContactList().get(i).getmLastName());
            }

            for (int i = 0; i < androidPhone.getContactList().size(); i++) {
                System.out.println("androidPhone Contact List item " + i + " " + androidPhone.getContactList().get(i).getmFirstName() + " " + androidPhone.getContactList().get(i).getmLastName());
            }
        }    else {

            System.out.println("Version not supported.");
        }

    }
}
