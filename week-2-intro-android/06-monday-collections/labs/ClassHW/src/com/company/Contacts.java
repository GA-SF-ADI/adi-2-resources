package com.company;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by sterlinggerritz on 6/19/16.
 */
public class Contacts extends ArrayList<Contacts> {

    private String name;
    private int phoneNumber;

    public Contacts(String name, int phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    @Override
    public Stream<Contacts> stream() {
        return null;
    }
}
