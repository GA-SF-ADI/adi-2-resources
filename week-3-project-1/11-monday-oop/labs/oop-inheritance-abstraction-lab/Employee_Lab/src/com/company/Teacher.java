package com.company;

/**
 * Created by kitty on 6/20/16.
 */
public class Teacher extends Employee {

    public Teacher() {
        super(75.00);
    }

    @Override
    public void primaryResponsibility() {
        System.out.println("Teacher's primary responsibility is to educate youth");
    }

    @Override
    public void secondaryResponsibility() {
        System.out.println("Teacher's secondary responsibility is to take summer break");
    }

    public void thirdResponsibility() {
        System.out.println("Teacher's third responsibility is to play with kids");
    }

}
