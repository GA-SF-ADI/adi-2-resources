package com.generalassembly.alex;

/**
 * A Class modeling a phone book Contact that has:
 * - first name
 * - last name
 * - phone number
 * - email address
 *
 * Created by alex on 3/5/16.
 */
public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailNumber;

    /**
     * Constructor for creating a contact.
     *
     * At a minimum we require a contact's first name and
     * phone number
     */
    public Contact(String firstName, String phoneNumber){
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the first name of the contact
     * @return String first name of contact
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the contact
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the contact
     * @return String last name of contact
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the contact
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the phone number of the contact
     * @return String phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of the contact
     * @param phoneNumber String
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the email of the contact
     * @return String email of contact
     */
    public String getEmailNumber() {
        return emailNumber;
    }

    /**
     * Set the email of the contact
     * @param emailNumber String email
     */
    public void setEmailNumber(String emailNumber) {
        this.emailNumber = emailNumber;
    }
}
