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
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "Favorites.db";

    //Define SQL statements to create and delete games table
    public static final  String SQK_CREATE_GAME_TABLE =
            "CREATE TABLE games ( _id INTEGER PRIMARY KEY, name TEXT, year TEXT)";


    // override the SQLiteDatabase's constructor, onCreate, and onUpgrade
    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQK_CREATE_GAME_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQK_CREATE_GAME_TABLE);
        onCreate(db);
    }
    // Create method to insert a column
    public void insert(int id, String name, String year){
        //Get reference to the db
        SQLiteDatabase db = getWritableDatabase();

        //create new content value to store the values
        ContentValues values = new ContentValues();
        values.put("_id", id);
        values.put("name", name);
        values.put("year", year);

        //Insert the row into the game table
        db.insert("games", null, values); // INSERT INTO games VALUES id, name, year
    }

    // Create read method
    public Game getGame (int id){

        //get a reference to the db
        SQLiteDatabase db = getReadableDatabase();

        //Define a projection. This will tell the quesry to return only the columns mentioned.
        //Similar to "Select column1, column2, column3"
        String[] projection = new String[]{"_id", "name", "year"};

        //Define a selection. This defines the WHERE clause.
        String selection = "_id = ?";

        //Define selection values. These are the values for the WHERE.
        //The number of values here should equal the number of ? in the WHERE clause.
        String[] selectionArgs = new String[] { String.valueOf(id) };

        //Make the query with a cursor object
        Cursor cursor = db.query("games", projection, selection, selectionArgs, null, null, null, null); //4 nulls?

        //Create a new Game object with your cursor
        cursor.moveToFirst();

        //return it

        String name = cursor.getString(cursor.getColumnIndex("name"));
        String year = cursor.getString(cursor.getColumnIndex("year"));


        return new Game(id, name, year);
    }

    public void delete(int id){

        //get a reference to the db
        SQLiteDatabase db = getWritableDatabase();

        //Define a selection. This defines the WHERE clause.
        String selection = "_id = ?";

        //Define selection values. These are the values for the WHERE.
        //The number of values here should equal the number of ? in the WHERE clause.
        String[] selectionArgs = new String[] { String.valueOf(id) };

        //Destroy everything that satisfies our query.
        //DELETE FROM games WHERE (condition)
        db.delete("games", selection, selectionArgs);

    }

    public Cursor getAllGames () {
        //get db ref
        SQLiteDatabase db = getReadableDatabase();
        //get cursor variable
        Cursor cursor = db.query("games", null, null, null, null, null, null);

        return cursor;
    }
}
