package com.company;

public class Main {
    private PhoneBook iPhone;
    static AndroidPhoneBook android = new AndroidPhoneBook(4.0f);

    static Contacts currentContact = new Contacts("Sterling", 1234);

    public static void main(String[] args) {
        PhoneBook iPhoneList = new PhoneBook(currentContact);
        PhoneBook androidList = new PhoneBook();




        androidList.removeContact(currentContact);

        if(android.checkVersion(android.getVersion())){
        //Version is not supported, alert user
            System.out.println("version is not supported, sorry");
        }
        else{
            System.out.println("the iPhone list of contacts has been copied!");
            iPhoneList=androidList;
        }


    }
}