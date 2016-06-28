package com.example.jeanweatherwax.sqliteandroidindpractice;

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

    // Define SQL statements to create and delete television table
    public static final String SQL_CREATE_TV_TABLE =
            "CREATE TABLE televisions ( id INTEGER PRIMARY KEY, brand TEXT, size TEXT, price INTEGER )";

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
        values.put("id", id);
        values.put("brand", brand);
        values.put("size", size);
        values.put("price", price);

        // Insert the row into the games table
        db.insert("games", null, values);
    }

    public Television getTV(int id) {
        // Get a reference to the db
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection. This will tell the query to return ony the columns mentioned.
        // Similar to "SELECT column1, column2, column3"
        String[] projection = new String[]{"id", "brand", "size", "price"};

        // Define a selection. This defines the WHERE clause.
        String selection = "id = ?";

        // Define selection values. These are the values for the WHERE.
        // The number of values here should equal the number of ? in the WHERE clause.
        String[] selectionArgs = new String[] { String.valueOf(id) };

        // Make the query with a cursor object
        Cursor cursor = db.query("televisions", projection, selection, selectionArgs, null, null, null, null);

        // Create a new Game object with your cursor
        cursor.moveToFirst();

        // Return it
        String brand = cursor.getString(cursor.getColumnIndex("brand"));
        String size = cursor.getString(cursor.getColumnIndex("size"));
        Integer price = cursor.getInt(cursor.getColumnIndex("price"));

        return new Television(id, brand, size, price);
    }

    public void delete(int id) {
        // Get a reference to the db
        SQLiteDatabase db = getWritableDatabase();

        // Define the selection values (WHERE)
        String selection = "id = ?";

        // define selection values (the ? in the selection)
        String[] selectionArgs = new String[] { String.valueOf(id) };

        // Destroy everything that satisfies our query.
        // DELETE FROM games WHERE (condition)
        db.delete("televisions", selection, selectionArgs);
    }
}
