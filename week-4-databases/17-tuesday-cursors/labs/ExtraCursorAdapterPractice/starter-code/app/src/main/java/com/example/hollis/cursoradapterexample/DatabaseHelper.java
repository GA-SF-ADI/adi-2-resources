package com.example.hollis.cursoradapterexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by audreyeso on 6/28/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //database and version

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Animals.db";
    public static final String COL_ANI_NAME = "name";
    public static final String COL_ANI_SOUND = "sound";
    public static final String COL_ANI_DES = "description";
    public static final String TABLE_NAME = "animal";


    //Define SQL statement to create table
    public static final String SQL_CREATE_ANIMAL_TABLE =
            "CREATE TABLE animals (name TEXT, sound TEXT, desctription TEXT )";

    //Define SQL statement to delete table
    public static final String SQL_DROP_ANIMAL_TABLE = "DROP TABLE IF EXISTS games";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //create animal table when database is created
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ANIMAL_TABLE);
    }

    //delete old animals and recreate the table

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_ANIMAL_TABLE);
        onCreate(db);
    }

    public void insert(String name, String sound, String description) {
        //get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        //create a new content value to store values
        //content values class is simliar to a bundle or map
        //data type that maps values to particular keys

        ContentValues values = new ContentValues();
        values.put(COL_ANI_NAME, name);
        values.put(COL_ANI_SOUND, sound);
        values.put(COL_ANI_DES, description);

        //insert the row into the animal table

        db.insert(TABLE_NAME, null, values);
    }

    public Animal getAnimal (String name) {
        //reference the database
        SQLiteDatabase db = getReadableDatabase();
        String [] projection = new String[] {COL_ANI_NAME, COL_ANI_SOUND, COL_ANI_DES};
        String selection = "id = ?";

        String[] selectionArgs = new String[]{ String.valueOf(name) };

        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null, null);

        cursor.moveToFirst();

        name = cursor.getString( cursor.getColumnIndex(COL_ANI_NAME) );
        String description = cursor.getString( cursor.getColumnIndex(COL_ANI_DES) );
        String sound = cursor.getString(cursor.getColumnIndex(COL_ANI_SOUND));

        return new Animal(name, sound, description);
    }

    public void deleteOneEntry(String name) {
        //get a reference to the db
        //modification to database should be writable
        //readable if you are getting something from it (retrieving something)
        SQLiteDatabase db = getWritableDatabase();

        //Define the selection vaues (WHERE)

        String selection = "name = ?";

        //Define selection values (the ? in the selection)
        String[] selectionArgs = new String[]{String.valueOf(name)};

        //Destroy everything that satisfies our query
        //DELETE FROM games WHERE (condition)

        db.delete(TABLE_NAME, selection, selectionArgs);
    }

    //needs to be accessible from main activity
    //you do not need any parameters (we already have the table and column names)
    public Cursor getAllAnimals() {
        //make a db and readable
        SQLiteDatabase db = getReadableDatabase();
        //now we need to get the data
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        //must return cursor
        return cursor;
    }
}
