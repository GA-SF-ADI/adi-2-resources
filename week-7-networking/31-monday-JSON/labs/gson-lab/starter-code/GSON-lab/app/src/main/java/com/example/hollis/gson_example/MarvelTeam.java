package com.example.hollis.gson_example;

/**
 * Created by hollis on 7/18/16.
 */
public class MarvelTeam {
    public String name;
    public String headquarters;
    public MarvelCharacter[] members;

    public MarvelTeam(String name, String headquarters, MarvelCharacter[] members) {
        this.name = name;
        this.headquarters = headquarters;
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public MarvelCharacter[] getMembers() {
        return members;
    }

    public void setMembers(MarvelCharacter[] members) {
        this.members = members;
    }
}
