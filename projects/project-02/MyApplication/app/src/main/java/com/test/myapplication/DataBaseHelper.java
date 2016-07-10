package com.test.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jon Kim on 7/8/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Alcohol.db";
    public static final String ALCOHOL_TABLE_NAME = "ALCOHOL_LIST";
    public static final String COL_ALC_ID = "ALC_ID";
    public static final String COL_ALC_NAME = "NAME";
    public static final String COL_ALC_PRICE = "PRICE";
    public static final String COL_ALC_ABV = "ABV";
    public static final String COL_ALC_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ALC_IMAGE = "IMAGE";
    public static final String[] ALC_COLUMN = {COL_ALC_NAME,COL_ALC_PRICE,COL_ALC_ABV,COL_ALC_DESCRIPTION,COL_ALC_IMAGE};
    public static final String SQL_CREATE_GAME_TABLE = "CREATE TABLE "
            +ALCOHOL_TABLE_NAME+"("
            +COL_ALC_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_ALC_NAME+" TEXT, "
            +COL_ALC_ABV+" INTEGER, "
            +COL_ALC_PRICE+" INTEGER, "
            +COL_ALC_DESCRIPTION+" TEXT, "
            +COL_ALC_IMAGE+" INT)";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_GAME_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS "+ALCOHOL_TABLE_NAME);
        this.onCreate(db);
    }

    public Cursor searchAlcohol(String query){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ALCOHOL_TABLE_NAME,
                ALC_COLUMN,
                COL_ALC_ABV + " LIKE ? OR " + COL_ALC_NAME + " LIKE ? OR " + COL_ALC_PRICE + " LIKE ?",
                new String[]{"%" + query + "%", "%" + query + "%", "%" + query + "%"},
                null,
                null,
                COL_ALC_PRICE+" DESC, "+ COL_ALC_ABV + " DESC, "+ COL_ALC_NAME + " DESC",
                null);

        return cursor;
    }

    public Cursor getAlcohol(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ALCOHOL_TABLE_NAME,
                ALC_COLUMN,
                COL_ALC_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        return cursor;
    }

    public void addAlcohol(Alcohol alcohol){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_ALC_NAME,alcohol.getAlcName());
        values.put(COL_ALC_ABV,alcohol.getAbv());
        values.put(COL_ALC_PRICE,alcohol.getAlcPrice());
        values.put(COL_ALC_DESCRIPTION,alcohol.getDescription());
        values.put(COL_ALC_IMAGE,alcohol.getImage());

        db.insert(ALCOHOL_TABLE_NAME, null, values);
        db.close();
    }

    public Cursor getAlcoholList(){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(ALCOHOL_TABLE_NAME,
                ALC_COLUMN,
                null,
                null,
                null,
                null,
                null,
                null);

        return cursor;

    }
}
