package gg.patrickcummins.todolist;

import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/20/16.
 */

public class NamedList extends ArrayList {
    private String mName;

    public NamedList(String mName) {
        this.mName = mName;

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
}
