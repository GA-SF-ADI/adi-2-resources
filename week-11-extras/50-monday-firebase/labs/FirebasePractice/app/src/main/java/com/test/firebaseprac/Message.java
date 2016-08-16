package com.test.firebaseprac;

/**
 * Created by Jon Kim on 8/15/16.
 */
public class Message {
    private String user,msg;
    private int color;

    public Message(){

    }

    public Message(String user, String msg, int color) {
        this.user = user;
        this.msg = msg;
        this.color = color;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
