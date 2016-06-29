package com.example.hollis.cursoradapterexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nolbertoarroyo on 6/28/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "Animals.db";
    public static final String TABLE_NAME ="animals";
    public static final String COL_ID = "_ID";
    public static final String ANIMAL_NAME ="ANIMAL_NAME";
    public static final String ANIMAL_DESCRIPTION="ANIMAL_DESCRIPTION";
    public static final String ANIMAL_SOUND ="ANIMAL_SOUND";
    public static final String[] ANIMAL_COLUMNS = {COL_ID,ANIMAL_NAME,ANIMAL_DESCRIPTION,ANIMAL_SOUND};
    public static final String SQL_CREATE_ANIMAL_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY, " +ANIMAL_NAME +" TEXT," + ANIMAL_DESCRIPTION + " TEXT," + ANIMAL_SOUND +" TEXT )";
    public static final String SQL_DROP_ANIMAL_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME ;

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static DatabaseHelper instance;
    public static DatabaseHelper getInstance(Context context){
        if(instance == null){
            instance = new DatabaseHelper(context);
        }return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ANIMAL_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_ANIMAL_TABLE);
        onCreate(db);

    }
    public void insert(int id, String name, String description, String sound){
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // create a new content value to store values
        ContentValues values = new ContentValues();
        values.put(COL_ID, id);
        values.put(ANIMAL_NAME, name);
        values.put(ANIMAL_DESCRIPTION, description);
        values.put(ANIMAL_SOUND, sound);
        DatabaseHelper db = getWritableDatabase();

        // Insert the row into the games table
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
    public void remove(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COL_ID + "= ?", new String[]{String.valueOf(id)});

    }
    public Cursor getAnimals(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,ANIMAL_COLUMNS,null,null,null,null,null);
        return cursor;
    }

}
