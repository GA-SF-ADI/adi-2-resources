package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.name;

/**
 * Created by patrickcummins on 6/28/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "store.db";

    // override the SQLiteDatabase's constructor, onCreate, and onUpgrade
    public static final String SQL_CREATE_TV_TABLE = "CREATE TABLE television (id INTEGER PRIMARY KEY, brand TEXT, size TEXT, price INT)";

    public static final String SQL_DROP_TV_TABLE = "DROP TABLE IF EXISTS television";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TV_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TV_TABLE);
        onCreate(db);
    }

    public void insert(int id, String brand, String size, Integer price){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values =  new ContentValues();
        values.put("id", id);
        values.put("brand", brand);
        values.put("size", size);
        values.put("price", price);

        db.insert("television", null, values);

    }

    public Television getTelevision(int id){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = new String[]{"id", "brand", "size", "price"};

        String selection = "id = ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        Cursor cursor = db.query("television", projection, selection, selectionArgs, null, null, null, null);
        cursor.moveToFirst();
        String brand = cursor.getString(cursor.getColumnIndex("brand"));
        String size = cursor.getString(cursor.getColumnIndex("size"));
        Integer price = cursor.getInt(cursor.getColumnIndex("price"));
        Television television = new Television(id, brand, size, price);
        return television;
    }
    public void destroy(int id){
        SQLiteDatabase db = getWritableDatabase();
        String selection = "id = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};

        db.delete("television", selection, selectionArgs);

    }


}
