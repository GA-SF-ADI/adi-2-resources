package gg.patrickcummins.myapplication;

import android.graphics.drawable.Drawable;

/**
 * Created by patrickcummins on 7/9/16.
 */

public class Player {
    String name, position, team;
    int number, playerPicture;

    public Player(String name, String position, int number, int playerPicture, String team) {
        this.name = name;
        this.position = position;
        this.number = number;
        this.playerPicture = playerPicture;
        this.team = team;

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
