package com.example.jeanweatherwax.sqliteandroidpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jeanweatherwax on 6/21/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Define the database name and version
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Favorites.db";

    // Define SQL statements to create and delete game table
    public static final String SQL_CREATE_GAME_TABLE =
            "CREATE TABLE games ( id INTEGER PRIMARY KEY, name TEXT, year TEXT )";

    public static final String SQL_DROP_GAME_TABLE = "DROP TABLE IF EXISTS games";

    // override the SQLiteDatabase's constructor, onCreate, and onUpgrade
    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_GAME_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_GAME_TABLE);
        onCreate(db);
    }

    public void insert(int id, String name, String year) {
        // Get a reference to the db
        SQLiteDatabase db = getWritableDatabase();

        // Create new content value to store the values
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("name", name);
        values.put("year", year);

        // Insert the row into the games table
        db.insert("games", null, values);
    }

    public Game getGame(int id) {
        // Get a reference to the db
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection. This will tell the query to return ony the columns mentioned.
        // Similar to "SELECT column1, column2, column3"
        String[] projection = new String[]{"id", "name", "year"};

        // Define a selection. This defines the WHERE clause.
        String selection = "id = ?";

        // Define selection values. These are the values for the WHERE.
        // The number of values here should equal the number of ? in the WHERE clause.
        String[] selectionArgs = new String[] { String.valueOf(id) };

        // Make the query with a cursor object
        Cursor cursor = db.query("games", projection, selection, selectionArgs, null, null, null, null);

        // Create a new Game object with your cursor
        cursor.moveToFirst();

        // Return it
        String name = cursor.getString(cursor.getColumnIndex("name"));
        String year = cursor.getString(cursor.getColumnIndex("year"));

        return new Game(id, name, year);
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
        db.delete("games", selection, selectionArgs);
    }
}
