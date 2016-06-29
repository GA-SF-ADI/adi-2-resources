package com.example.hollis.cursoradapterexample;

/**
 * Created by LangstonSmith on 6/28/16.
 */
public class Animal {

    private String name;
    private String sound;
    private String description;

    public Animal(String name, String sound, String description) {
        this.name = name;
        this.sound = sound;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
