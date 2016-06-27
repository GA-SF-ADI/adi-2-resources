package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jeanweatherwax on 6/21/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "store.db";

    // Define SQL statements to create television table
    public static final String SQL_CREATE_TELEVISION_TABLE =
            "CREATE TABLE televisions ( id INTEGER PRIMARY KEY, name TEXT, year TEXT )";

    public static final String SQL_DROP_TELEVISION_TABLE = "DROP TABLE IF EXISTS televisions";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create the games table when the database is created
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TELEVISION_TABLE);
    }

    // When the database is upgraded, the old data isn't needed. Delete the television
    // table and recreate the table
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TELEVISION_TABLE);
        onCreate(db);
    }

    //INSERT INTO televisions VALUES (10, 'Sony', '40"', '300');
    public void insert(int id, String brand, String size, Integer price){
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // create a new content value to store values
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("brand", brand);
        values.put("size", size);
        values.put("price", price);

        // Insert the row into the games table
        db.insert("televisions", null, values);
    }

    //SELECT id, brand, size, price FROM televisions WHERE id = 10;
    public Television getTV(int id){
        // Get a reference to the database
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection, which tells the query to return only the columns mentioned
        // similar to "SELECT column1, column2, column3"
        String[] projection = new String[]{ "id", "brand", "size", "price" };

        // Define a selection, which defines the WHERE clause of the query (but not the values for it)
        // similar to "WHERE x < 23", only without the value; "WHERE x < ?"
        String selection = "id = ?";

        // Define the selection values. The ?'s in the selection
        // The number of values in the following array should equal the number of ? in the where clause
        String[] selectionArgs = new String[]{ String.valueOf(id) };

        // Make the query, getting the cursor object
        Cursor cursor = db.query("televisions", projection, selection, selectionArgs, null, null, null, null);

        // With the cursor, create a new game object and return it
        cursor.moveToFirst();

        String brand = cursor.getString( cursor.getColumnIndex("brand") );
        String size = cursor.getString( cursor.getColumnIndex("size") );
        Integer price = cursor.getInt(cursor.getColumnIndex("price"));

        return new Television(id, brand, size, price);
    }

    //DELETE FROM televisions WHERE id = 10;
    public void delete(int id){
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // Define the selection, or the where
        String selection = "id = ?";

        // Define the selection values. The ?'s in the selection
        // The number of values in the following array should equal the number of ? in the where clause
        String[] selectionArgs = new String[]{ String.valueOf(id) };

        // Delete everything that satisfies the selection
        db.delete("televisions", selection, selectionArgs);
    }
}
