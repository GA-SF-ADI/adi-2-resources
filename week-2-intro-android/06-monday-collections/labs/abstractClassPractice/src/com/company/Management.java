package com.company;

/**
 * Created by sterlinggerritz on 6/20/16.
 */
public class Management extends Employee {

    public Management(double hourlywage){
        super(30);
    }
    @Override
    public void primaryResponsibility() {
        System.out.println("primary resonsiblity is doing admin work");
    }


    @Override
    public void secondaryResponsibility(){
        System.out.println("secondary responsiblity is scheduling clients");
    }

    public static void manage(){
        System.out.println("The manager is managing");

    }
}
