package com.example.hollis.cursoradapterexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jon Kim on 6/28/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ANIMALS_DB";
    public static final String TABLE_NAME = "Animals";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "Name";
    public static final String COL_DESCRIPTION = "Description";
    public static final String COL_SOUND = "Sound";
    public static final String SQL_DROP_GROCERY_TABLE = "DROP TABLE IF EXISTS Animals";
    public static final String SQL_CREATE_GROCERY_TABLE = "CREATE TABLE " + TABLE_NAME + "("+COL_ID+
            " INTEGER PRIMARY KEY, "
            +COL_NAME+
            " TEXT, "
            +COL_DESCRIPTION+
            " TEXT, "
            +COL_SOUND+
            " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_GROCERY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_GROCERY_TABLE);
        onCreate(db);

    }

    public void insert(Animal animal){
        //get reference to db.
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_NAME, animal.getName());
        values.put(COL_SOUND, animal.getSound());
        values.put(COL_DESCRIPTION, animal.getDescription());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public void delete(int id){
        SQLiteDatabase db = getWritableDatabase();

        String selection = "_id =?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        //DELETE FROM games WHERE(condition)
        db.delete(TABLE_NAME, selection, selectionArgs);

    }

    public Cursor getAnimalList(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);

        return cursor;

    }
}
