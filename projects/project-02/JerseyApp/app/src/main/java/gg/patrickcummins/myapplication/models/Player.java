package gg.patrickcummins.myapplication.models;

import android.graphics.drawable.Drawable;

/**
 * Created by patrickcummins on 7/9/16.
 */

public class Player {
    String name, position, team;
    int number, playerPicture, jersey1, jersey2, jersey3;

    public Player(String name, String position, int number, int playerPicture, String team, int jersey1, int jersey2, int jersey3) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.number = number;
        this.playerPicture = playerPicture;
        this.jersey1 = jersey1;
        this.jersey2 = jersey2;
        this.jersey3 = jersey3;
    }

    public int getJersey1() {
        return jersey1;
    }

    public void setJersey1(int jersey1) {
        this.jersey1 = jersey1;
    }

    public int getJersey2() {
        return jersey2;
    }

    public void setJersey2(int jersey2) {
        this.jersey2 = jersey2;
    }

    public int getJersey3() {
        return jersey3;
    }

    public void setJersey3(int jersey3) {
        this.jersey3 = jersey3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPlayerPicture() {
        return playerPicture;
    }

    public void setPlayerPicture(int playerPicture) {
        this.playerPicture = playerPicture;
    }
}
