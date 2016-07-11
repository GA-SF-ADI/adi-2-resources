package com.example.hollis.cursoradapterexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by michaeljeffress on 6/28/16.
 */
public class AnimalSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = AnimalSQLiteOpenHelper.class.getCanonicalName();
    public static AnimalSQLiteOpenHelper instanceOfDB;
    private static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "ANIMAL_DB";
    public static final String ANIMAL_LIST_TABLE_NAME = "ANIMAL_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "NAME";
    public static final String COL_SOUND = "SOUND";
    public static final String COL_DESCRIPTION = "DESCRIPTION";

    public static final String[] ANIMAL_COLUMNS = {COL_ID,COL_NAME,COL_SOUND,COL_DESCRIPTION};

    private static final String CREATE_ANIMAL_LIST_TABLE =
            "CREATE TABLE " + ANIMAL_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NAME + " TEXT, " +
                    COL_SOUND + " TEXT, " +
                    COL_DESCRIPTION + " TEXT)";


    public AnimalSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ANIMAL_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ANIMAL_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    public void addItem(Animal animal){
        ContentValues values = new ContentValues();
        values.put(COL_NAME, animal.getName());
        values.put(COL_SOUND, animal.getSound());
        values.put(COL_DESCRIPTION, animal.getDescription());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ANIMAL_LIST_TABLE_NAME, null, values);
        db.close();
    }

    public static AnimalSQLiteOpenHelper getInstance(Context context){
        if(instanceOfDB == null) {
            instanceOfDB = new AnimalSQLiteOpenHelper(context.getApplicationContext());
        }

        return instanceOfDB;
    }

    public void deleteItem(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(ANIMAL_LIST_TABLE_NAME, COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }


    public Cursor getAnimals(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(ANIMAL_LIST_TABLE_NAME, ANIMAL_COLUMNS, null, null, null, null, null);
        return cursor;
    }

}
