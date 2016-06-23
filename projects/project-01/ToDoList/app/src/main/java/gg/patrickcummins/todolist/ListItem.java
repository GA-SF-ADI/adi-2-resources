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
    private boolean isItemChecked;


    public ListItem(String mName, String description, String color) {
        this.mName = mName;
        this.description = description;
        this.color = color;
    }

    public boolean isItemChecked() {
        return this.isItemChecked;
    }

    public void setItemChecked(boolean checked) {
        this.isItemChecked = checked;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return mName + " " + description;
    }
}
