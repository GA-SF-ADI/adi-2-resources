package com.example.hollis.cursoradapterexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hollis on 6/27/16.
 */
public class AnimalSqlOpenHelper extends SQLiteOpenHelper {

    public static final String TAG    = "AnimalSqlOpenHelper";

    public static AnimalSqlOpenHelper curInstance;

    private static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "ANIMAL_DB";
    public static final String ANIMAL_TABLE_NAME = "ANIMALS";

    public static final String COL_ID = "_id";
    public static final String COL_ANIMAL_NAME = "NAME";
    public static final String COL_ANIMAL_SOUND = "SOUND";
    public static final String COL_ANIMAL_DESCRIPTION = "DESCRIPTION";

    public static final String[] ANIMAL_COLUMNS = {COL_ID,COL_ANIMAL_NAME, COL_ANIMAL_SOUND, COL_ANIMAL_DESCRIPTION};

    public static final String CREATE_ANIMALS_TABLE = "CREATE TABLE " + ANIMAL_TABLE_NAME +
            "("+
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_ANIMAL_NAME + " TEXT, " +
            COL_ANIMAL_SOUND + " TEXT, " +
            COL_ANIMAL_DESCRIPTION + " TEXT)";


    public AnimalSqlOpenHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    public static AnimalSqlOpenHelper getInstance(Context context){
        if(curInstance == null){
            curInstance = new AnimalSqlOpenHelper(context.getApplicationContext());
        }
        return curInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ANIMALS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ANIMAL_TABLE_NAME);
        this.onCreate(db);
    }

    public void addAnimal(Animal animal){
        ContentValues values = new ContentValues();
        values.put(COL_ANIMAL_NAME, animal.getName());
        values.put(COL_ANIMAL_SOUND, animal.getSound());
        values.put(COL_ANIMAL_DESCRIPTION, animal.getDescription());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ANIMAL_TABLE_NAME, null, values);
        db.close();
    }

    public void removeAnimal(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(ANIMAL_TABLE_NAME, COL_ID + "= ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public Cursor getAnimals(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(ANIMAL_TABLE_NAME, ANIMAL_COLUMNS, null, null, null, null, null);
        return cursor;
    }

}
