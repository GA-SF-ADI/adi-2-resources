package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.content.ContentValues;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jon Kim on 6/28/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "store.db";

    public final String SQL_CREATE_TV_TABLE = "CREATE TABLE televisions (id INTEGER PRIMARY KEY, brand TEXT, size INTEGER, price INTEGER)";
    public static final String SQL_DROP_TV_TABLE = "DROP TABLE IF EXISTS televisions";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TV_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TV_TABLE);
        onCreate(db);
    }

    public void insert(int id, String brand, int size, int price){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("brand", brand);
        values.put("size", size);
        values.put("price", price);

        db.insert("televisions", null, values);

    }
    public Television getTV(int id){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = new String[]{"id","brand","size","price"};

        String selection = "id=?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        Cursor cursor = db.query("televisions", projection, selection, selectionArgs, null, null, null, null);

        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndex("brand"));
        String size = cursor.getString(cursor.getColumnIndex("size"));
        Integer price = cursor.getInt(cursor.getColumnIndex("price"));

        return new Television(id, name, size, price);
    }
    public void delete(int id){
        SQLiteDatabase db = getWritableDatabase();

        String selection = "id=?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        db.delete("telivisions", selection, selectionArgs);
    }

}
