package com.example.hollis.cursoradapterexample;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hollis on 6/27/16.
 */
public class AnimalSQLOpenHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "animal_db";
    private static final int DATABASE_VERSION = 7;
    private static String COL_NAME = "name";
    private static String COL_SOUND = "sound";
    private static String COL_DESCRIPTION = "description";


    public AnimalSQLOpenHelper(String name, String sound, String description) {
        this.name = name;
        this.sound = sound;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }
}
