package com.example.hollis.cursoradapterexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by patrickcummins on 6/28/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "Animals.db";
    public static final String TABLE_NAME= "animals";
    public static final String ANIMAL_ID = "_id";
    public static final String ANIMAL_SOUND = "sound";
    public static final String ANIMAL_NAME = "name";
    public static final String ANIMAL_DESCRIPTION = "description";

    public static final String CREATE_TABLE_STRING = "CREATE TABLE " + TABLE_NAME + " ( " + ANIMAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ANIMAL_NAME + " TEXT, " + ANIMAL_SOUND + " TEXT, " + ANIMAL_DESCRIPTION + " TEXT)";
    public static  final String DROP_TABLE_STRING = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STRING);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_STRING);
        onCreate(db);
    }

    public void addAnimal(Animal animal){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ANIMAL_NAME, animal.getName());
        values.put(ANIMAL_SOUND, animal.getSound());
        values.put(ANIMAL_DESCRIPTION, animal.getDescription());
        db.insert(TABLE_NAME, null, values);
        db.close();


    }

    public void removeAnimal(int id){
        SQLiteDatabase db = getWritableDatabase();
        String selection = ANIMAL_ID + " = ?";
        String[] selectionArgs  = new String[]{String.valueOf(id)};
        db.delete(TABLE_NAME, selection,selectionArgs);
    }
    public Cursor getAnimals(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,null, null, null, null, null,null, null);
        return cursor;
    }
}
