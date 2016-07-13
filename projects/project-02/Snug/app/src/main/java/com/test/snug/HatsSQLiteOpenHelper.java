package com.test.snug;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Random;


public class HatsSQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    public static final String HAT_TABLE_NAME = "hats";
    public static final String HAT_COLUMN_ID = "_id";
    public static final String HAT_COLUMN_HATNAME = "name";
    public static final String HAT_COLUMN_PICTUREID = "pictureID";
    public static final String HAT_COLUMN_PRICE = "price";
    public static final String HAT_COLUMN_MATERIAL = "material";
    public static final String HAT_COLUMN_FittedOrSnap = "fittedOrSnap";
    public static final String HAT_COLUMN_DESCRIPTION = "description";
    public static final String HAT_COLUMN_COLOR = "color";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "snugApp.db";

    public static final String[] HAT_COLUMNS = {HAT_COLUMN_ID, HAT_COLUMN_PICTUREID, HAT_COLUMN_HATNAME, HAT_COLUMN_PRICE,
            HAT_COLUMN_MATERIAL, HAT_COLUMN_FittedOrSnap, HAT_COLUMN_DESCRIPTION, HAT_COLUMN_COLOR};


    public static final String SQL_CREATE_HATS_TABLE =
            "CREATE TABLE " + HAT_TABLE_NAME + " (" + HAT_COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + HAT_COLUMN_PICTUREID + " INTEGER, " + HAT_COLUMN_HATNAME + " TEXT, " +
                    HAT_COLUMN_PRICE + " INTEGER, " + HAT_COLUMN_MATERIAL + " TEXT, " +
                    HAT_COLUMN_FittedOrSnap + " TEXT, " + HAT_COLUMN_DESCRIPTION + " TEXT, " +
                    HAT_COLUMN_COLOR + " TEXT);";


    public static final String SQL_DROP_HATS_TABLE = "DROP TABLE IF EXISTS " + HAT_TABLE_NAME;

    private static HatsSQLiteOpenHelper mInstance;

    public static HatsSQLiteOpenHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new HatsSQLiteOpenHelper(context.getApplicationContext());
        }
        return mInstance;
    }


    public HatsSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_HATS_TABLE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DROP_HATS_TABLE);
        onCreate(db);

    }

    public void addHat(int id, int picture, String name, double price, String material, String fittedOrSnap,
                       String description, String color) {

        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();


        values.put("_id", id);
        values.put("pictureID", picture);
        values.put("name", name);
        values.put("price", price);
        values.put("material", material);
        values.put("fittedOrSnap", fittedOrSnap);
        values.put("description", description);
        values.put("color", color);

        db.insert(HAT_TABLE_NAME, null, values);

        db.close();

    }


//    TODO: Create deleteHat() method


    public Cursor getSpecificHat(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(HAT_TABLE_NAME, // a. table
                HAT_COLUMNS, // b. column names
                HAT_COLUMN_ID + " = ?", // c. selections
                new String[]{String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public Cursor getALLHats() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(HAT_TABLE_NAME, // a. table
                HAT_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null,// f. having,
                "RANDOM ()",// g. order by
                null); // h. limit
        return cursor;
    }

//    TODO: Create array of team names in the method below


    public Cursor getHatTeams(String query) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(HAT_TABLE_NAME, // a. table
                HAT_COLUMNS, // b. column names
                HAT_TABLE_NAME + " LIKE ?", // c. selections
                new String[]{"%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;


    }
}

