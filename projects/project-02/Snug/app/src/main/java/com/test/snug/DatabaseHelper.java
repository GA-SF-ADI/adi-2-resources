package com.test.snug;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {

    public static final String HAT_TABLE_NAME = "hats";
    public static final String HAT_COLUMN_ID = "_id";
    public static final String HAT_COLUMN_PICTURE = "picture";
    public static final String HAT_COLUMN_GENDER = "gender";
    public static final String HAT_COLUMN_PRICE = "price";
    public static final String HAT_COLUMN_MATERIAL = "material";
    public static final String HAT_COLUMN_FittedOrSnap = "fittedOrSnap";
    public static final String HAT_COLUMN_DESCRIPTION = "description";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "snugApp.db";

    public static final String SQL_CREATE_HATS_TABLE =
            "CREATE TABLE " + HAT_TABLE_NAME + " (" + HAT_COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + HAT_COLUMN_PICTURE + " TEXT, " + HAT_COLUMN_GENDER + " TEXT, " + HAT_COLUMN_PRICE
                    + " INTEGER, " + HAT_COLUMN_MATERIAL + " TEXT, " + HAT_COLUMN_FittedOrSnap + " INTEGER,"
                    + HAT_COLUMN_DESCRIPTION + " TEXT)";


    public static final String SQL_DROP_HATS_TABLE = "DROP TABLE IF EXISTS " + HAT_TABLE_NAME;


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

    public void addHat(int id, int picture, double price, String material, int fittedOrSnap,
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

        db.insert(HAT_TABLE_NAME, null, values);
        db.close();

    }


    public void deleteHat(int id) {

        SQLiteDatabase db = getWritableDatabase();

        String selection = "id = ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        db.delete(HAT_TABLE_NAME, selection, selectionArgs);
        db.close();

    }

    public Hat getSpecificHat(int id) {

        // Get a reference to the database
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection, which tells the query to return only the columns mentioned
        // similar to "SELECT column1, column2, column3"
        String[] projection = new String[]{"id", "picture", "price", "material", "fittedOrSnap", "description", "color"};

        // Define a selection, which defines the WHERE clause of the query (but not the values for it)
        // similar to "WHERE x < 23", only without the value; "WHERE x < ?"
        String selection = "id = ?";

        // Define the selection values. The ?'s in the selection
        // The number of values in the following array should equal the number of ? in the where clause
        String[] selectionArgs = new String[]{String.valueOf(id)};

        // Make the query, getting the cursor object
        Cursor cursor = db.query("hats", projection, selection, selectionArgs, null, null, null, null);

        // With the cursor, create a new game object and return it
        cursor.moveToFirst();

        int picture = cursor.getInt(cursor.getColumnIndex("picture"));
        double price = cursor.getInt(cursor.getColumnIndex("price"));
        String material = cursor.getString(cursor.getColumnIndex("material"));
        int fittedOrSnap = cursor.getInt(cursor.getColumnIndex("fittedOrSnap"));
        String description = cursor.getString(cursor.getColumnIndex("description"));
        String color = cursor.getString(cursor.getColumnIndex("year"));

        return new Hat(id, picture, price, material, fittedOrSnap, description, color);


    }

    public Cursor getAllHats() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + HAT_TABLE_NAME, null);
        return res;
    }


}
