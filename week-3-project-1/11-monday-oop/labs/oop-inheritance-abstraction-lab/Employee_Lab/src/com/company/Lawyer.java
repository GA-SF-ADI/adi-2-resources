package com.company;

/**
 * Created by kitty on 6/20/16.
 */
public class Lawyer extends Employee {

    public Lawyer() {
        super(130.75);
    }

    @Override
    public void primaryResponsibility() {
        System.out.println("Lawyer's primary responsibility is to take your money");
    }

    @Override
    public void secondaryResponsibility() {
        System.out.println("Lawyer's secondary responsibility is to BS");
    }
}
