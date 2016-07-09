package gg.patrickcummins.myapplication;

import android.graphics.drawable.Drawable;

/**
 * Created by patrickcummins on 7/9/16.
 */

public class Player {
    String name, position;
    int number, playerPicture;

    public Player(String name, String position, int number, int playerPicture) {
        this.name = name;
        this.position = position;
        this.number = number;
        this.playerPicture = playerPicture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {

        return name;
    }

    public String getPosition() {
        return position;
    }


    public int getNumber() {
        return number;
    }
    public int getPlayerPicture() {
        return playerPicture;
    }

    public void setPlayerPicture(int playerPicture) {
        this.playerPicture = playerPicture;
    }
}
