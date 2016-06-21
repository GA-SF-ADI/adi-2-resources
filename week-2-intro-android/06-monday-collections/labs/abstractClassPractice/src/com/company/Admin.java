package com.company;

/**
 * Created by sterlinggerritz on 6/20/16.
 */
public class Admin extends  Employee {

   public Admin(double hourlywage){
       super(9);
   }

    @Override
    public void primaryResponsibility() {
        System.out.println("primary resonsiblity is doing admin work");
        System.out.println("hours worked at first admin stuff is " + hoursWorked);
    }


    @Override
    public void secondaryResponsibility(){
        System.out.println("secondary responsiblity is scheduling clients");
    }

    public static void type(){
        System.out.println("the receptionist is typing");
    }
}
