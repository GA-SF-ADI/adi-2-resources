package com.test.snug;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class SQLiteOpenHelper extends android.database.sqlite.SQLiteOpenHelper {

    public static final String HAT_TABLE_NAME = "hats";
    public static final String HAT_COLUMN_ID = "_id";
    public static final String HAT_COLUMN_HATNAME = "name";
    public static final String HAT_COLUMN_PICTUREID = "pictureID";
    public static final String HAT_COLUMN_PRICE = "price";
    public static final String HAT_COLUMN_MATERIAL = "material";
    public static final String HAT_COLUMN_FittedOrSnap = "fittedOrSnap";
    public static final String HAT_COLUMN_DESCRIPTION = "description";
    public static final String HAT_COLUMN_COLOR = "color";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "snugApp.db";

    public static final String[] HAT_COLUMNS = {HAT_COLUMN_ID, HAT_COLUMN_PICTUREID, HAT_COLUMN_HATNAME, HAT_COLUMN_PRICE,
            HAT_COLUMN_MATERIAL, HAT_COLUMN_FittedOrSnap, HAT_COLUMN_DESCRIPTION, HAT_COLUMN_COLOR};


    public static final String SQL_CREATE_HATS_TABLE =
            "CREATE TABLE " + HAT_TABLE_NAME + " (" + HAT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + HAT_COLUMN_PICTUREID + " INTEGER, " + HAT_COLUMN_HATNAME + " TEXT, " +
                    HAT_COLUMN_PRICE + " INTEGER, " + HAT_COLUMN_MATERIAL + " TEXT, " +
                    HAT_COLUMN_FittedOrSnap + " INTEGER," + HAT_COLUMN_DESCRIPTION + " TEXT, " +
                    HAT_COLUMN_COLOR + " TEXT);";


    public static final String SQL_DROP_HATS_TABLE = "DROP TABLE IF EXISTS " + HAT_TABLE_NAME;


    public SQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_HATS_TABLE);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(SQL_DROP_HATS_TABLE);
        onCreate(db);

    }

    public void addHat(int id, int picture, String name, int price, String material, int fittedOrSnap,
                       String description, String color) {

        ContentValues values = new ContentValues();
        SQLiteDatabase db = getWritableDatabase();
        db.insert(HAT_TABLE_NAME, null, values);


        values.put("id", id);
        values.put("pictureID", picture);
        values.put("name", name);
        values.put("price", price);
        values.put("material", material);
        values.put("fittedOrSnap", fittedOrSnap);
        values.put("description", description);
        values.put("color", color);


        db.close();

    }


    public void deleteHat(int id) {

        SQLiteDatabase db = getWritableDatabase();

        String selection = "id = ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        db.delete(HAT_TABLE_NAME, HAT_COLUMN_ID + "= ?", new String[]{String.valueOf(id)});
        db.close();

    }


    public Cursor getHat(int id) {
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

    /*public Hat getSpecificHat(int id) {

        SQLiteDatabase db = getReadableDatabase();
        String[] projection = new String[]{"id", "name", "pictureID", "price", "material", "fittedOrSnap", "description", "color"};

        String selection = "id = ?";

        String[] selectionArgs = new String[]{String.valueOf(id)};

        Cursor cursor = db.query("hats", projection, selection, selectionArgs, null, null, null, null);

        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndex("name"));
        int pictureID = cursor.getInt(cursor.getColumnIndex("pictureID"));
        int price = cursor.getInt(cursor.getColumnIndex("price"));
        String material = cursor.getString(cursor.getColumnIndex("material"));
        int fittedOrSnap = cursor.getInt(cursor.getColumnIndex("fittedOrSnap"));
        String description = cursor.getString(cursor.getColumnIndex("description"));
        String color = cursor.getString(cursor.getColumnIndex("year"));

        return new Hat(id, pictureID, name, price, material, fittedOrSnap, description, color);

    }*/

    public Cursor getAllHats() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(HAT_TABLE_NAME, HAT_COLUMNS, null, null, null, null, null);
        return cursor;
    }


    public Cursor searchHatList(String query) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(HAT_TABLE_NAME, // a. table
                HAT_COLUMNS, // b. column names
                HAT_TABLE_NAME + " LIKE ?", // c. selections
                new String[]{"%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;


    }
}

