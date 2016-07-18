package com.example.hollis.gson_example;

/**
 * Created by audreyeso on 7/18/16.
 */
public class Wind {
    public int getChill() {
        return chill;
    }

    public void setChill(int chill) {
        this.chill = chill;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    private int chill;
    private int direction;
    private int speed;
}
