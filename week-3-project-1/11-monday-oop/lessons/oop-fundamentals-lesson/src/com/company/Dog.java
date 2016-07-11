package com.company;

/**
 * Created by kitty on 6/20/16.
 */
public class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog(String name) {

        this.name = name;
    }

    public void bark(){

        System.out.println(this.getName() + ": I'm a dog");
    }

}
