package com.test.snug;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


public class DatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "snugApp.db";

    public static final String SQL_CREATE_HATS_TABLE =
            "CREATE TABLE hats ( id INTEGER PRIMARY KEY, picture INT, price INT, material TEXT, " +
                    "fittedOrSnap INT, description TEXT," +
                    " color TEXT)";


    public static final String SQL_DROP_HATS_TABLE = "DROP TABLE IF EXISTS hats";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_HATS_TABLE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DROP_HATS_TABLE);
        onCreate(db);

    }

    public void addHat(int id, int picture, int price, String material, int fittedOrSnap,
                       String description, String color) {


        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("picture", picture);
        values.put("price", price);
        values.put("material", material);
        values.put("fittedOrSnap", fittedOrSnap);
        values.put("description", description);
        values.put("color", color);

        db.insert("table", null, values);
        db.close();

    }


    public void deleteHat(int id) {

        SQLiteDatabase db = getWritableDatabase();

        String selection = "id = ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        db.delete("hats", selection, selectionArgs);

        db.close();
    }


}

