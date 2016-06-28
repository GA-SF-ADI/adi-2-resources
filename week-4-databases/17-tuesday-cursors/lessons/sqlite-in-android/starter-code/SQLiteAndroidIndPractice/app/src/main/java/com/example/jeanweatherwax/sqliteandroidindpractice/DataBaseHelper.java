package com.example.jeanweatherwax.sqliteandroidindpractice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * Created by audreyeso on 6/28/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    //Define the database and name and version

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME= "Store.db";

    public DataBaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Create a table called televisions with columns:
    //id, brand, size(real), price(int)

    public static final String SQL_CREATE_TELEVISIONS_TABLE =
            "CREATE TABLE televisions (id INTEGER PRIMARY KEY, brand TEXT, size REAL, price INTEGER)";

    public static final String SQL_DROP_GAME_TABLE= "DROP TABLE IF EXITS games";
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TELEVISIONS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DROP_GAME_TABLE);
        onCreate(db);

    }

    //insert new TVs

    public void insert(int id, String brand,Double size, int price) {
        //we are modifying so use getWriteableDatabase
        SQLiteDatabase db = getWritableDatabase();

        //create new content to store the values

        ContentValues tvValues = new ContentValues();
        tvValues.put("id", id);
        tvValues.put("brand", brand);
        tvValues.put("size", size);
        tvValues.put("price", price);

        //insert the row into the television table

        db.insert("televisions", null, tvValues);
    }

    public Television getTV (int id) {
        //get reference to the db(readable NOT writable)

        SQLiteDatabase db = getReadableDatabase();

        //Define a projection
        //similar to "select column1, column2, column3"

        String[] projection = new String[]{"id", "brand", "size", "price"};

        //define selection
        //The number of values here should equal the number of ? in the WHERE clause.
        String selection = "id = ?";

        //Define selection values. These are the values for the WHERE.
        //The number of values here should equal the number of ? in the WHERE clause.

        String[] selectionArgs = new String[]{String.valueOf(id)};

        //Make the query with a cursor object
        Cursor cursor = db.query("televisions", projection, selection, selectionArgs, null, null, null, null);


        //Create a new Game object with your cursor
        cursor.moveToFirst();

        //return it
        // we got a new cursor object, but we want to get a few things from it...:
        // we want to get the name

        //concatonated


        String brand = cursor.getString(cursor.getColumnIndex("brand"));
        String size = cursor.getString(cursor.getColumnIndex("size"));
        int price = cursor.getInt(cursor.getColumnIndex("price"));

        return new Television(id, brand, size, price);
    }


    // delete single entries

    public void deleteSingleEntry(int id) {
        //reference the db (modifying so use WRITABLE)
        SQLiteDatabase db = getWritableDatabase();

        //Define the selection values(WHERE)

        String selection = "id = ?";

        //Define selection values (the ? in the selection)

        String [] selectionArgs = new String[] {String.valueOf(id)};

        //Destroy everything using DELETE FROM televisions WHERE (condition)

        db.delete("televisions", selection, selectionArgs);
    }
}
