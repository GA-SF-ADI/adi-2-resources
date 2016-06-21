package gg.patrickcummins.todolist;

/**
 * Created by patrickcummins on 6/21/16.
 */

public class ListItem {
    private String mName;
    private String description;

    public ListItem(String mName, String description) {
        this.mName = mName;
        this.description = description;
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
