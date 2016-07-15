package com.test.snug;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Random;


public class HatsSQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    public static final String HAT_TABLE_NAME = "hats";
    public static final String HAT_COLUMN_ID = "_id";
    public static final String HAT_COLUMN_HATNAME = "name";
    public static final String HAT_COLUMN_PICTUREID = "pictureID";
    public static final String HAT_COLUMN_PRICE = "price";
    public static final String HAT_COLUMN_MATERIAL = "material";
    public static final String HAT_COLUMN_FittedOrSnap = "fittedOrSnap";
    public static final String HAT_COLUMN_DESCRIPTION = "description";
    public static final String HAT_COLUMN_COLOR = "color";

    public static final String CART_TABLE_NAME = "cart";
    public static final String CART_COLUMN_ID = "_id_cart";
    public static final String CART_COLUMN_PRICE = "cartPrice";


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "snugApp.db";

    public static final String[] HAT_COLUMNS = {HAT_COLUMN_ID, HAT_COLUMN_PICTUREID, HAT_COLUMN_HATNAME, HAT_COLUMN_PRICE,
            HAT_COLUMN_MATERIAL, HAT_COLUMN_FittedOrSnap, HAT_COLUMN_DESCRIPTION, HAT_COLUMN_COLOR};

    public static final String[] CART_COLUMNS = {CART_COLUMN_ID, CART_COLUMN_PRICE};


    public static final String SQL_CREATE_HATS_TABLE =
            "CREATE TABLE " + HAT_TABLE_NAME + " (" + HAT_COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + HAT_COLUMN_PICTUREID + " INTEGER, " + HAT_COLUMN_HATNAME + " TEXT, " +
                    HAT_COLUMN_PRICE + " INTEGER, " + HAT_COLUMN_MATERIAL + " TEXT, " +
                    HAT_COLUMN_FittedOrSnap + " TEXT, " + HAT_COLUMN_DESCRIPTION + " TEXT, " +
                    HAT_COLUMN_COLOR + " TEXT);";

    public static final String SQL_CREATE_CART_TABLE = "CREATE TABLE " + CART_TABLE_NAME + "(" + CART_COLUMN_ID + " INTEGER PRIMARY KEY, " + CART_COLUMN_PRICE + ")";


    public static final String SQL_DROP_HATS_TABLE = "DROP TABLE IF EXISTS " + HAT_TABLE_NAME;

    public static final String SQL_DROP_CART_TABLE = "DROP TABLE IF EXISTS " + CART_TABLE_NAME;

    private static HatsSQLiteOpenHelper mInstance;

    public static HatsSQLiteOpenHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new HatsSQLiteOpenHelper(context.getApplicationContext());
        }
        return mInstance;
    }


    public HatsSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_HATS_TABLE);
        db.execSQL(SQL_CREATE_CART_TABLE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DROP_HATS_TABLE);
        db.execSQL(SQL_DROP_CART_TABLE);
        onCreate(db);

    }

    public void addHatToHatTable(int id, int picture, String name, double price, String material,
                                 String fittedOrSnap, String description, String color) {

        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();

        values.put("_id", id);
        values.put("pictureID", picture);
        values.put("name", name);
        values.put("price", price);
        values.put("material", material);
        values.put("fittedOrSnap", fittedOrSnap);
        values.put("description", description);
        values.put("color", color);

        db.insert(HAT_TABLE_NAME, null, values);

        db.close();

    }

    public void addHatToCart(int id, double price) {

        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();

        values.put("_id_cart", id);
        values.put("cartPrice", price);

        db.insert(CART_TABLE_NAME, null, values);

        db.close();
    }

    public void deleteSpecificHatFromCart(int position) {

        SQLiteDatabase db = getWritableDatabase();

        String selection = "id = ?";

        String[] selectionArgs = new String[]{String.valueOf(position)};

        db.delete("cart", selection, selectionArgs);

    }

    public void deleteAllHatsFromCart() {

        SQLiteDatabase db = getWritableDatabase();


        db.delete(CART_TABLE_NAME, null, null);


    }


    public Cursor getSpecificHat(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(HAT_TABLE_NAME, // a. table
                HAT_COLUMNS, // b. column names
                HAT_COLUMN_ID + " = ?", // c. selections
                new String[]{String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public Cursor getALLHatsFromHatDatabase() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(HAT_TABLE_NAME, // a. table
                HAT_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null,// f. having,
                "RANDOM ()",// g. order by
                null); // h. limit
        return cursor;
    }

    public Cursor getALLHatsFromCART() {

        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT _id, cartPrice, name, pictureID, price, material, " +
                "fittedOrSnap, description, color FROM " + HAT_TABLE_NAME + " INNER JOIN " +
                CART_TABLE_NAME + " ON " + HAT_TABLE_NAME + "." + HAT_COLUMN_ID + " = " +
                CART_TABLE_NAME + "." + CART_COLUMN_ID;

        Cursor cursor = db.rawQuery(query, null);


        return cursor;


    }

    public int checkNumOfHatsInCart() {

        String countQuery = "SELECT  * FROM " + CART_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }


    public Cursor getHatTeams() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                true, //a. set to true so that I only get unique team names
                HAT_TABLE_NAME, // b. table
                new String[]{HAT_COLUMN_HATNAME}, // c. column names
                null, // d. selections
                null, // e. selections args
                null, // f. group by
                null, // g. having
                null, // h. order by
                null); // i. limit
        return cursor;


    }


    public Cursor getNumOfCartItems() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(CART_TABLE_NAME, // a. table
                CART_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;


    }

    public Cursor searchAmongAllHats(String queryString) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(HAT_TABLE_NAME, // a. table
                HAT_COLUMNS, // b. column names
                null, // c. selections
                new String[]{"%" + queryString + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }


}

