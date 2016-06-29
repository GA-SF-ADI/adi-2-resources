package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nolbertoarroyo on 6/28/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Store.db";
    public static final String SQL_CREATE_TELEVISION_TABLE ="CREATE TABLE television(id INTERGER PRIMARY KEY, brand TEXT, size INTEGER, price INTEGER)";
    public static final String SQL_DROP_TELEVISION_TABLE= "DROP TABLE IF IT EXISTS television";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TELEVISION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TELEVISION_TABLE);
        onCreate(db);

    }

    public void insert(int id, String brand, int price, int size){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("brand",brand);
        values.put("price",price);
        values.put("size",size);

        db.insert("television", null, values);
    }

    public Television getTelevison(int id){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = new String[]{"id","brand","price","size"};

        String selection =" ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = db.query("television",projection,selection,selectionArgs,null,null,null,null);
        cursor.moveToFirst();
        int id = cursor.getInt(cursor.getColumnIndex("id"));
        String brand = cursor.getString(cursor.getColumnIndex("brand"));
        int price = cursor.getInt(cursor.getColumnIndex("price"));
        int size = cursor.getInt(cursor.getColumnIndex("size"));

        return new Television("id","brand","price","size");

    }
}
