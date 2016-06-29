package com.example.hollis.cursoradapterexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NehaRege on 6/28/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static DataBaseHelper db;

    public static final int DATA_BASE_VERSION = 1;
    public static final String DATA_BASE_NAME = "animal_db";
    public static final String TABLE_NAME = "animal_table";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_SOUND = "sound";
    public static final String COL_DESCRIPTION = "description";

    public static final String[] PROJECTION = new String[] {COL_ID,COL_NAME,COL_SOUND,COL_DESCRIPTION};

    Animal animal;

    public static DataBaseHelper getInstance(Context context) {
        if(db == null) {
            db = new DataBaseHelper(context.getApplicationContext());
        }
        return db;
    }

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE "+TABLE_NAME+ "("
            +COL_ID + " INT PRIMARY KEY, "
            +COL_NAME +" TEXT, "
            +COL_SOUND +" TEXT, "
            +COL_DESCRIPTION +" TEXT)";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS "+TABLE_NAME;

    public DataBaseHelper(Context context){
        super(context,DATA_BASE_NAME,null,DATA_BASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    public void insert(int id, String name, String sound, String description){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_ID,id);
        values.put(COL_NAME,name);
        values.put(COL_SOUND,sound);
        values.put(COL_DESCRIPTION,description);

        db.insert(TABLE_NAME,null,values);

    }

    public void addAnimal(Animal currentAnimal){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(COL_NAME,currentAnimal.getName());
        values.put(COL_SOUND,currentAnimal.getSound());
        values.put(COL_DESCRIPTION,currentAnimal.getDescription());

        db.insert(TABLE_NAME,null,values);

        db.close();

    }


    public void removeAnimal(long id){

        SQLiteDatabase db = getWritableDatabase();

        String[] selectionArgs = new String[] {String.valueOf(id)};

        db.delete(TABLE_NAME,PROJECTION+"= ?",selectionArgs);

        db.close();

    }

    public Animal getAnimal(int id){

        SQLiteDatabase db = getReadableDatabase();

//        String[] projection = new String[] {COL_ID,COL_NAME,COL_SOUND,COL_DESCRIPTION};

        String selection = "_id = ?";

        String[] selectionArgs = new String[] {String.valueOf(id)};

        Cursor cursor = db.query(TABLE_NAME,PROJECTION,selection,selectionArgs,null,null,null,null);

        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
        String sound = cursor.getString(cursor.getColumnIndex(COL_SOUND));
        String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));

        return new Animal(name,sound,description);

    }

    public Cursor getAllAnimals(){

        SQLiteDatabase db = getReadableDatabase();

        return db.query(TABLE_NAME,null,null,null,null,null,null);
    }

}
