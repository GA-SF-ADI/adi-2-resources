package com.company;

public class Main {
    private PhoneBook iPhone, android;

    static Contacts currentContact = new Contacts("Sterling", 1234);

    public static void main(String[] args) {
        PhoneBook iPhoneList = new PhoneBook(currentContact);
        PhoneBook androidList = new PhoneBook();

        iPhoneList = androidList;


        androidList.removeContact(currentContact);

    }
}
