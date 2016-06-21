package com.company;

/**
 * Created by sterlinggerritz on 6/20/16.
 */
public class IT extends Employee {

public IT(double hourlywage){
    super(6);
}


    @Override
    public void primaryResponsibility() {
        System.out.println("primary resonsiblity is doing admin work");
        hoursWorked += 9;
    }


    @Override
    public void secondaryResponsibility(){
        System.out.println("secondary responsiblity is scheduling clients");
    }

    public static void code() {
        System.out.println("the programmer is coding");
    }
}
