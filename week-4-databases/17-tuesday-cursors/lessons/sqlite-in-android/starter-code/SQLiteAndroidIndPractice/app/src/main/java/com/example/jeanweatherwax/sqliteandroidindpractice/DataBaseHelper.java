package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by generalassembly on 6/28/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Store.db";

    public static final String SQL_CREATE_GAME_TABLE =
            "CREATE TABLE games ( id INTEGER PRIMARY KEY, name TEXT, year TEXT )";

    public static final String SQL_DROP_GAME_TABLE = "DROP TABLE IF EXISTS games";



    public DataBaseHelper (Context context) {
        super((context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_GAME_TABLE);


    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_GAME_TABLE);
        onCreate(db);

    }
}
