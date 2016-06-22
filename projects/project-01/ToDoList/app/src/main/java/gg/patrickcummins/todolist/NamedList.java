package gg.patrickcummins.todolist;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/20/16.
 */

public class NamedList implements Serializable{
    private static final long serialVersionUID = 7526472295622776147L;
    private String mName;
    private ArrayList<ListItem> mArrayList;
    private String color;

    public NamedList(String mName, String color) {
        this.mArrayList = new ArrayList<ListItem>();
        this.mName = mName;
        this.color = color;

    }
    public String getColor() {
        return color;
    }



    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
    @Override
    public String toString(){
        return mName;
    }

    public ArrayList<ListItem> getmArrayList() {
        return mArrayList;
    }

    public void setmArrayList(ArrayList<ListItem> mArrayList) {
        this.mArrayList = mArrayList;
    }
}
