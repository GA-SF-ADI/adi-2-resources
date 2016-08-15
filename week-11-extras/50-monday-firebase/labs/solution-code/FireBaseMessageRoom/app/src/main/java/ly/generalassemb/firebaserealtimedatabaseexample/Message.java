package ly.generalassemb.firebaserealtimedatabaseexample;

/**
 * Created by alex on 8/15/16.
 */
public class Message {
    private String user;
    private int color;
    private String msg;

    public Message(String user, String msg) {
        this.user = user;
        this.msg = msg;
    }

    public Message() {

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
