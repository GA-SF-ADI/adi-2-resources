package com.example.hollis.fragmentinterfacepractice;

/**
 * Created by hollis on 7/5/16.
 */
public class Animal {
    String name;
    String size;
    int numLegs;

    public Animal(String name, String size, int numLegs) {
        this.name = name;
        this.size = size;
        this.numLegs = numLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    @Override
    public String toString() {
        return name;
    }
}
