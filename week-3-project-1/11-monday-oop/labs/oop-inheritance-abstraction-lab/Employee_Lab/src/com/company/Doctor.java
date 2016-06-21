package com.company;

/**
 * Created by kitty on 6/20/16.
 */
public class Doctor extends Employee {

    public Doctor() {
        super(99.99);
    }

    @Override
    public void primaryResponsibility() {
        System.out.println("Doctor's primary responsibility is to save lives");
    }

    @Override
    public void secondaryResponsibility() {
        System.out.println("Doctor's secondary responsibility is to wear a white coat");
    }

}
