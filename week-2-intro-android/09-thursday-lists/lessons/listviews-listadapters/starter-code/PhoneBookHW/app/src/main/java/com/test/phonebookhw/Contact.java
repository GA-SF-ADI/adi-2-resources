package com.test.phonebookhw;

/**
 * Created by audreyeso on 6/18/16.
 */
public class Contact {
//I was okay with this creating this class
    private String name;
    private String phoneNumber;

    public Contact(String name,String phoneNumber ) {

        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber () {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }


    }


