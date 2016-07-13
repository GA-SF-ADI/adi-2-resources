package com.test.project2navigationdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by audreyeso on 7/10/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBAdapter";
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME= "Jewelry.db";
    public static final String TABLE_NAME= "jewelry_table";
    public static final String COL_1_ID= "_id";
    public static final String COL_2_TYPE= "TYPE";
    public static final String COL_3_PRICE= "PRICE";
    public static final String COL_4_GOLD= "GOLD_TYPE";
    public static final String COL_5_STONE= "STONE_TYPE";
    public static final String COL_6_MEASUREMENT= "MEASUREMENT";
    public static final String COL_7_QUANTITY= "QUANTITY";
    public static final String COL_8_NAME= "NAME";
    public static final String COL_9_IMAGE = "IMAGE";


    public static final String[] JEWELRY_COLUMNS = {COL_1_ID,COL_2_TYPE, COL_3_PRICE, COL_4_GOLD, COL_5_STONE, COL_6_MEASUREMENT, COL_7_QUANTITY, COL_8_NAME, COL_9_IMAGE};

    private static final String CREATE_SHOPPING_LIST_TABLE =
            "CREATE TABLE " + TABLE_NAME +
                    "(" +
                    COL_1_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_2_TYPE + " TEXT, " +
                    COL_3_PRICE + " TEXT, " +
                    COL_4_GOLD + " TEXT, " +
                    COL_5_STONE + " TEXT, " +
                    COL_6_MEASUREMENT + " TEXT, " +
                    COL_7_QUANTITY + " TEXT, " +
                    COL_8_NAME + " TEXT, " +
                    COL_9_IMAGE + " INTEGER )";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //will execute query
        db.execSQL(CREATE_SHOPPING_LIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public void insert(String id, String type, String price, String gold, String stone, String measurement,String quantity,String name, int image) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1_ID,id);
        values.put(COL_2_TYPE, type);
        values.put(COL_3_PRICE, price);
        values.put(COL_4_GOLD,gold);
        values.put(COL_5_STONE, stone);
        values.put(COL_6_MEASUREMENT, measurement);
        values.put(COL_7_QUANTITY,quantity);
        values.put(COL_8_NAME, name);
        values.put(COL_9_IMAGE, image);

        db.insert(TABLE_NAME, null, values);

    }

    public Cursor getJewelry(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, // a. table
                JEWELRY_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }
}

