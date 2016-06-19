package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by audreyeso on 6/19/16.
 */


public class PlayList {
    private int numSongs;
    ArrayList<String> myList = new ArrayList<>();

    public PlayList(ArrayList<String> myList) {
         numSongs = 0;
        myList = new ArrayList<String>();
    }

    //did not work...
    public void insertAt (String name) {
       myList.add (2, name );
    }

    public int getNumSongs() {
        return numSongs;
    }

public ArrayList getSong (int index) {
        myList.get(index);
    return myList;
    }


        }

