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

    public static final String COL_ID = "_id";
    public static final String COL_GAME_NAME = "name";
    public static final String COL_GAME_YEAR = "year";
    public static final String TABLE_NAME = "games";

    public static final String SQL_CREATE_GAME_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY, " + COL_GAME_NAME + " TEXT, " + COL_GAME_YEAR + " TEXT)";
    //put in UNDERSCORE _id

    public static final String SQL_DROP_GAME_TABLE = "DROP TABLE IF EXITS games";

    // override the SQLiteDatabase's constructor, onCreate, and onUpgrade
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        //execute query ... created table
        db.execSQL(SQL_CREATE_GAME_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //destroyed table
        db.execSQL(SQL_DROP_GAME_TABLE);
        onCreate(db);
    }

    //look in game to see these parameters
    public void insert(int id, String name, String year) {
        SQLiteDatabase db = getWritableDatabase();

        //create new content to store the values

        ContentValues values = new ContentValues();
        values.put(COL_ID, id); //actual name and the parameter
        values.put("name", name);
        values.put("year", year);

        //Insert the row into the games table

        db.insert("games", null, values);
    }

    //Read or display table
    //When we read something, we are getting a game object

    public Game getGame(int id) {
        // get a reference to the db (readable instead of writable)
        SQLiteDatabase db = getReadableDatabase();

        //Define a projection. This will tell the query to return only the columns mentioned
        //Similar to "Select column1, column2, column3"

        String[] projection = new String[]{COL_ID, "name", "year"};

        // Define a selection. This defines the WHERE clause. "?" means whatever

        String selection = "_id = ?";
        //Define selection values. These are the values for the WHERE.
        //The number of values here should equal the number of ? in the WHERE clause.

        String[] selectionArgs = new String[]{String.valueOf(id)};

        //Make the query with a cursor object
        Cursor cursor = db.query("games", projection, selection, selectionArgs, null, null, null, null);


        //Create a new Game object with your cursor
        cursor.moveToFirst();

        //return it
        // we got a new cursor object, but we want to get a few things from it...:
        // we want to get the name

        //concatonated

        String name = cursor.getString(cursor.getColumnIndex("name"));
        String year = cursor.getString(cursor.getColumnIndex("year"));


        //must return with parameters that you want to return

        return new Game(id, name, year);

    }

    //if you want to delete JUST ONE entry! we need another method... not the table one from above
    //the table method will delete the whole table

    public void deleteOneEntry(int id) {
        //get a reference to the db
        //modification to database should be writable
        //readable if you are getting something from it (retrieving something)
        SQLiteDatabase db = getWritableDatabase();

        //Define the selection vaues (WHERE)

        String selection = "id = ?";

        //Define selection values (the ? in the selection)
        String[] selectionArgs = new String[]{String.valueOf(id)};

        //Destroy everything that satisfies our query
        //DELETE FROM games WHERE (condition)

        db.delete("games", selection, selectionArgs);
    }

    //needs to be accessible from main activity
    //you do not need any parameters (we already have the table and column names)
    public Cursor getAllGames() {
        //make a db and readable
        SQLiteDatabase db = getReadableDatabase();
        //now we need to get the data
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        //must return cursor
        return cursor;
    }
}
