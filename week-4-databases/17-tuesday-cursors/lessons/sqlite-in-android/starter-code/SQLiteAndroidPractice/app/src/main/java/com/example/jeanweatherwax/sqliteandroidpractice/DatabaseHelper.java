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
    public static final String COL_GAME_NAME = "name";
    public static final String COL_GAME_YEAR = "year";
    public static final String TABLE_NAME = "games";
    public static final String SQL_CREATE_GAME_TABLE = "CREATE TABLE "+ TABLE_NAME + " (_id INTEGER PRIMARY KEY,"+ COL_GAME_NAME + " TEXT," + COL_GAME_YEAR+" TEXT)";
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

    public void insert(int id, String name, String year){
        //get reference to db.
        SQLiteDatabase db = getWritableDatabase();

        //create new content value for the values
        ContentValues values = new ContentValues();
        values.put("_id", id);
        values.put("name", name);
        values.put("year", year);

        //Insert the row into the games table
        db.insert("games", null, values);

    }

    public Game getGame(int id){
        //reference to db. a readable database because you are reading
        SQLiteDatabase db = getReadableDatabase();

        //Define a projection. this will tell the query to return only the columns mentions.
        //Similar to "SELECT column1, column2,
        String[] projection = new String[]{"_id", "name", "year"};

        //Define a selection. This defines WHERE in sqlite cmd
        String selection = "id = ?";

        //Define selection values. these are the values for the WHERE.
        //The number of values here should equal the number of the ? in the WHERE clause.
        String[] selectionArgs = new String[]{String.valueOf(id)};

        //Make the query with a cursor object
        Cursor cursor = db.query("games", projection, selection, selectionArgs, null, null, null, null);

        //create a new game object with cursor
        cursor.moveToFirst();

        //return it
        String name = cursor.getString(cursor.getColumnIndex("name"));
        String year = cursor.getString(cursor.getColumnIndex("year"));

        return new Game(id, name, year);

    }

    public void delete(int id){
        //get reference to db.
        SQLiteDatabase db = getWritableDatabase();

        //define the slection values(WHERE)
        String selection = "_id =?";

        //define selection values (the ? in the selection)
        String[] selectionArgs = new String[]{String.valueOf(id)};

        //destroy everythign we want
        //DELETE FROM games WHERE(condition)
        db.delete("games", selection, selectionArgs);

    }

    public Cursor getAllGames(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        return cursor;

    }


}
