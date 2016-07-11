package com.company;

/**
 * Created by kitty on 6/20/16.
 */
public class Poodle extends Dog{

    public Poodle(String name) {
        super(name);
    }

    @Override
    public void bark(){
        System.out.println(this.getName()+": I'm a poodle");

    }

}
