package com.test.classesday10weekendhomework;

/**
 * Created by LangstonSmith on 6/18/16.
 */
public class Contact extends PhoneBook {

    private String name;

    private int phoneNumber;

    private String emailAddress;

    private String houseStreetName;

    public Contact(String name, int phoneNumber, String emailAddress, String houseStreetName) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.houseStreetName = houseStreetName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHouseStreetName() {
        return houseStreetName;
    }

    public void setHouseStreetName(String houseStreetName) {
        this.houseStreetName = houseStreetName;
    }
}
