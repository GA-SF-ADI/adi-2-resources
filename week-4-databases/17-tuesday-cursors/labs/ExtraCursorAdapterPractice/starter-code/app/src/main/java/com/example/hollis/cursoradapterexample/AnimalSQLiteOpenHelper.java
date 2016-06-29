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

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ANIMAL_DB";
    public static final String ANIMAL_LIST_TABLE_NAME = "ANIMAL_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_NAME = "NAME";
    public static final String COL_SOUND = "SOUND";
    public static final String COL_DESCRIPTION = "DESCRIPTION";

    public static final String[] ANIMAL_COLUMNS = {COL_ID,COL_NAME, COL_SOUND, COL_DESCRIPTION};

    private static final String CREATE_ANIMAL_LIST_TABLE =
            "CREATE TABLE " + ANIMAL_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NAME + " TEXT, " +
                    COL_DESCRIPTION + " TEXT, ";


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

    public long addItem(String name, String sound, String description){
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_SOUND, sound);
        values.put(COL_DESCRIPTION, description);

        SQLiteDatabase db = this.getWritableDatabase();
        long returnId = db.insert(ANIMAL_LIST_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }

    public Cursor getAnimalList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ANIMAL_LIST_TABLE_NAME, // a. table
                ANIMAL_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    public int deleteItem(int id){
        SQLiteDatabase db = getWritableDatabase();
        int deleteNum = db.delete(ANIMAL_LIST_TABLE_NAME,
                COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return deleteNum;
    }






}
