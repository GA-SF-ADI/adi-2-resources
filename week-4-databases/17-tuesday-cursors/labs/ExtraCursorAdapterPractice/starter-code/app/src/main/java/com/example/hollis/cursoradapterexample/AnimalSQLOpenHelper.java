package com.example.hollis.cursoradapterexample;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hollis on 6/27/16.
 */
public class AnimalSQLOpenHelper extends SQLiteOpenHelper {


    public static final String TAG = "AnimalSqlOpenHelper";

    public static AnimalSQLOpenHelper curInstance;

    private static String DATABASE_NAME = "animal_db";
    private static final int DATABASE_VERSION = 7;
    public static final String TABLE_NAME = "animals";
    private static String COL_ID = "_id";
    private static String COL_NAME = "name";
    private static String COL_SOUND = "sound";
    private static String COL_DESCRIPTION = "description";

    public static final String[] ANIMAL_COLUMNS = {COL_ID, COL_NAME, COL_SOUND, COL_DESCRIPTION};

    public static final String CREATE_ANIMALS_TABLE = "CREATE TABLE " + TABLE_NAME +
            "(" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT, " +
            COL_SOUND + " TEXT, " +
            COL_DESCRIPTION + " TEXT)";


    public AnimalSqlOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static AnimalSqlOpenHelper getInstance(Context context) {
        if (curInstance == null) {
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }

    public void addAnimal(Animal animal) {
        ContentValues values = new ContentValues();
        values.put(COL_NAME, animal.getName());
        values.put(COL_SOUND, animal.getSound());
        values.put(COL_DESCRIPTION, animal.getDescription());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void removeAnimal(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, COL_ID + "= ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public Cursor getAnimals() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, ANIMAL_COLUMNS, null, null, null, null, null);
        return cursor;
    }

}


}