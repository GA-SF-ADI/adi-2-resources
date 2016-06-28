package com.example.jeanweatherwax.sqliteandroidpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.id;
import static java.text.Collator.PRIMARY;

/**
 * Created by jeanweatherwax on 6/21/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    // Define the database name and version
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Favorites.db";
    public static final String COL_GAME_NAME = "name";
    public static final String COL_GAME_YEAR = "Year";
    public static final String COL_GAME_ID = "_id";
    public static final String TABLE_NAME = "games";

    // override the SQLiteDatabase's constructor, onCreate, and onUpgrade
    public static final String SQL_CREATE_GAME_TABLE = "CREATE TABLE "+ TABLE_NAME +" ("+COL_GAME_ID +" INTEGER PRIMARY KEY, "+COL_GAME_NAME +" TEXT, "+COL_GAME_YEAR +" TEXT)";

    public static final String SQL_DROP_GAME_TABLE = "DROP TABLE IF EXISTS " +TABLE_NAME;
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
        //Get a reference to the db
        SQLiteDatabase db = getWritableDatabase();

        //create new content value to store values
        ContentValues values = new ContentValues();
        values.put(COL_GAME_ID, id);
        values.put(COL_GAME_NAME, name);
        values.put(COL_GAME_YEAR, year);

        //Insert row into games table
        db.insert(TABLE_NAME, null, values);
    }
    public Game getGame(int id){
        //get a reference to the db
        SQLiteDatabase db = getReadableDatabase();

        //Define a projection. This will tell the query to return only the columns mentioned.
        //Similar to "SELECT column1, column2, column3"
        String[] projection = new String[]{COL_GAME_ID, COL_GAME_NAME, COL_GAME_YEAR};

        //Define a selection. This defines the WHERE clause.
        String selection = COL_GAME_ID+ " = ?";

        //Define selection values These are the values for the WHERE
        //The number of values here should equal the number of ? in the WHERE clause.
        String[] selectionArgs = new String[]{String.valueOf(id)};

        //Make the query with a cursor object
        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null, null);

        //Create a Game object
        cursor.moveToFirst();

        //return it
        String name = cursor.getString(cursor.getColumnIndex(COL_GAME_NAME));
        String year = cursor.getString(cursor.getColumnIndex(COL_GAME_YEAR));
        Game game = new Game(id, name, year);
        return game;


    }
    public void destroy(int id){
        //get a reference to the db
        SQLiteDatabase db = getWritableDatabase();

        //Define selection values (WHERE)
        String selection = COL_GAME_ID +" = ?";

        //Define selection values(the ? in the selection)
        String[] selectionArgs = new String[]{String.valueOf(id)};

        //Destroy everything that satisfies our query

        db.delete(TABLE_NAME, selection, selectionArgs);
    }
    public Cursor getAllGames(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        return cursor;
    }
}
