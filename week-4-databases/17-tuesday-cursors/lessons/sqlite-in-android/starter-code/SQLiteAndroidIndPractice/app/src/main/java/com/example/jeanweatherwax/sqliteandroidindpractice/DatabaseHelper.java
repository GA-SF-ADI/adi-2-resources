package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kitty on 6/28/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Define the database name and version
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Store.db";

    // Define Table name for better practice
    public static final String TABLE_NAME = "televisions";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_BRAND = "brand";
    public static final String COLUMN_SIZE = "size";
    public static final String COLUMN_PRICE = "price";

    // Define SQL statements to create and delete television table
    public static final String SQL_CREATE_TV_TABLE =
            "CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_BRAND + " TEXT, " + COLUMN_SIZE + " TEXT, " + COLUMN_PRICE + " INTEGER )";

    public static final String SQL_DROP_TV_TABLE = "DROP TABLE IF EXISTS televisions";

    // override the SQLiteDatabase's constructor, onCreate, and onUpgrade
    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TV_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TV_TABLE);
        onCreate(db);
    }

    public void insert(int id, String brand, String size, Integer price) {
        // Get a reference to the db
        SQLiteDatabase db = getWritableDatabase();

        // Create new content value to store the values
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_BRAND, brand);
        values.put(COLUMN_SIZE, size);
        values.put(COLUMN_PRICE, price);

        // Insert the row into the games table
        db.insert(TABLE_NAME, null, values);
    }

    public Television getTV(int id) {
        // Get a reference to the db
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection. This will tell the query to return ony the columns mentioned.
        // Similar to "SELECT column1, column2, column3"
        // Should actually put these column names as variables instead of hardcoding
        String[] projection = new String[]{COLUMN_ID, COLUMN_BRAND, COLUMN_SIZE, COLUMN_PRICE};

        // Define a selection. This defines the WHERE clause.
        String selection = "_id = ?";

        // Define selection values. These are the values for the WHERE.
        // The number of values here should equal the number of ? in the WHERE clause.
        String[] selectionArgs = new String[] { String.valueOf(id) };

        // Make the query with a cursor object
        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null, null);

        // Create a new Game object with your cursor
        cursor.moveToFirst();

        // Return it
        String brand = cursor.getString(cursor.getColumnIndex(COLUMN_BRAND));
        String size = cursor.getString(cursor.getColumnIndex(COLUMN_SIZE));
        Integer price = cursor.getInt(cursor.getColumnIndex(COLUMN_PRICE));

        return new Television(id, brand, size, price);
    }

    public void delete(int id) {
        // Get a reference to the db
        SQLiteDatabase db = getWritableDatabase();

        // Define the selection values (WHERE)
        String selection = "_id = ?";

        // define selection values (the ? in the selection)
        String[] selectionArgs = new String[] { String.valueOf(COLUMN_ID) };

        // Destroy everything that satisfies our query.
        // DELETE FROM games WHERE (condition)
        db.delete(TABLE_NAME, selection, selectionArgs);
    }

    public Cursor getAllTVs() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }
}
