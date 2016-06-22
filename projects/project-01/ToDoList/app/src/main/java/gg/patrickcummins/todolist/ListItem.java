package gg.patrickcummins.todolist;

import java.io.Serializable;

/**
 * Created by patrickcummins on 6/21/16.
 */

public class ListItem implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;
    private String mName;
    private String description;
    private String color = null;


    public ListItem(String mName, String description, String color) {
        this.mName = mName;
        this.description = description;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getmName() {
        return mName;
    }

    public String getDescription() {
        return description;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return mName + " " + description;
    }
}
