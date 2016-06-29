package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by michaeljeffress on 6/28/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "store.db";

    public static final String SQK_CREATE_TELEVISION_TABLE =
            "CREATE TABLE televisions (id INTEGER, brand TEXT, size TEXT, price INTEGER)";

    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQK_CREATE_TELEVISION_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQK_CREATE_TELEVISION_TABLE);
        onCreate(db);
    }

    public void insert(int id, String brand, String size, Integer price){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put("brand", brand);
        values.put("size", size);
        values.put("price", price);

        db.insert("televisions", null, values);
    }

    public Television getTelevision (int id) {

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = new String[]{"id", "brand", "size", "price"};

        String selection = "id = ?";

        String[] selectionArgs = new String[] { String.valueOf(id) };

        Cursor cursor = db.query("televisions", projection, selection, selectionArgs, null, null, null, null);

        cursor.moveToFirst();

        String brand = cursor.getString(cursor.getColumnIndex("brand"));
        String size = cursor.getString(cursor.getColumnIndex("size"));
        Integer price = cursor.getInt(cursor.getColumnIndex("price"));


        return new Television(id, brand, size, price);
    }

    public void delete(int id){

        SQLiteDatabase db = getWritableDatabase();

        String selection = "id = ?";

        String[] selectionArgs = new String[] { String.valueOf(id) };

        db.delete("televisions", selection, selectionArgs);

    }

}
