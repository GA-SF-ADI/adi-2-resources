package com.example.kitty.ecommerceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kitty on 7/10/16.
 */
public class Helper extends SQLiteOpenHelper {

    private static final String TAG = Helper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "SHOPPING_DB";
    public static final String TP_TABLE_NAME = "TP_LIST";
    public static final String REVIEW_TABLE_NAME = "REVIEW_LIST";
    public static final String SHOPPING_CART_TABLE_NAME = "SHOPPING_LIST";
    public static final String SALE_TABLE_NAME = "SALE_LIST";

    //TP table columns
    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_BRAND = "BRAND";
    public static final String COL_ITEM_PRICE = "PRICE";
    public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ITEM_PLY = "PLY";
    public static final String COL_ITEM_SIZE = "SIZE";
    public static final String COL_ITEM_NUM_ROLL = "NUM_ROLL";
    public static final String COL_ITEM_AVG_RATING = "AVG_RATING";

    //Review table columns
    public static final String COL_REVIEW_ID = "_id";
    public static final String COL_REVIEW_COMMENT = "COMMENT";
    public static final String COL_REVIEW_RATING = "RATING";
    public static final String COL_REVIEW_ITEM_ID = "ITEM_ID";

    //Shopping cart columns
    public static final String COL_CART_ID = "_id";
    public static final String COL_CART_ITEM_ID = "ITEM_ID";
    public static final String COL_CART_QUANTITY = "QUANTITY";

    //Sale table columns
    public static final String COL_SALE_ID = "_id";
    public static final String COL_SALE_ITEM_ID = "ITEM_ID";
    public static final String COL_SALE_PRICE = "SALE_PRICE";

    private static Helper mInstance;

    public static final String[] TP_COLUMNS = {COL_ID,COL_ITEM_NAME,COL_ITEM_BRAND, COL_ITEM_PRICE, COL_ITEM_DESCRIPTION, COL_ITEM_PLY,
            COL_ITEM_SIZE, COL_ITEM_NUM_ROLL, COL_ITEM_AVG_RATING};
    public static final String[] REVIEW_COLUMNS = {COL_REVIEW_ID, COL_REVIEW_COMMENT, COL_REVIEW_RATING, COL_REVIEW_ITEM_ID};
    public static final String[] CART_COLUMNS = {COL_CART_ID, COL_CART_ITEM_ID, COL_CART_QUANTITY};
    public static final String[] SALE_COLUMNS = {COL_SALE_ID, COL_SALE_ITEM_ID, COL_SALE_PRICE};

    private static final String CREATE_TP_LIST_TABLE =
            "CREATE TABLE " + TP_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT, " +
                    COL_ITEM_BRAND + " TEXT, " +
                    COL_ITEM_PRICE + " DOUBLE, " +
                    COL_ITEM_DESCRIPTION + " TEXT, " +
                    COL_ITEM_PLY + " INTEGER, " +
                    COL_ITEM_SIZE + " TEXT, " +
                    COL_ITEM_NUM_ROLL + " INTEGER, " +
                    COL_ITEM_AVG_RATING + " DOUBLE )";
    private static final String CREATE_REVIEW_TABLE =
            "CREATE TABLE " + REVIEW_TABLE_NAME +
                    "(" +
                    COL_REVIEW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_REVIEW_COMMENT + " TEXT, " +
                    COL_REVIEW_RATING + " INTEGER, " +
                    "FOREIGN KEY (" + COL_REVIEW_ITEM_ID + ") REFERENCES " + TP_TABLE_NAME + "(" + COL_ID + "))";
    private static final String CREATE_CART_TABLE =
            "CREATE TABLE " + SHOPPING_CART_TABLE_NAME +
                    "(" +
                    COL_CART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_CART_QUANTITY + " INTEGER, " +
                    "FOREIGN KEY (" + COL_CART_ITEM_ID + ") REFERENCES " + TP_TABLE_NAME + "(" + COL_ID + "))";
    private static final String CREATE_SALE_TABLE =
            "CREATE TABLE " + SALE_TABLE_NAME +
                    "(" +
                    COL_SALE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_SALE_PRICE + " DOUBLE, " +
                    "FOREIGN KEY (" + COL_SALE_ITEM_ID + ") REFERENCES " + TP_TABLE_NAME + "(" + COL_ID + "))";

    public static Helper getInstance(Context context){
        if(mInstance == null){
            mInstance = new Helper(context.getApplicationContext());
        }
        return mInstance;
    }

    private Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TP_LIST_TABLE);
        db.execSQL(CREATE_REVIEW_TABLE);
        db.execSQL(CREATE_CART_TABLE);
        db.execSQL(CREATE_SALE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TP_TABLE_NAME);
        this.onCreate(db);
    }

    public long addTP(String name, String brand, double price, String description, int ply, String size, int numRoll){
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_NAME, name);
        values.put(COL_ITEM_BRAND, brand);
        values.put(COL_ITEM_PRICE, price);
        values.put(COL_ITEM_DESCRIPTION, description);
        values.put(COL_ITEM_PLY, ply);
        values.put(COL_ITEM_SIZE, size);
        values.put(COL_ITEM_NUM_ROLL, numRoll);

        //need to add coding to pull user rating from other table and take average.

        SQLiteDatabase db = this.getWritableDatabase();
        long returnId = db.insert(TP_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }

    public Cursor getTPList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TP_TABLE_NAME, // a. table
                TP_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public int deleteTP(int id){
        SQLiteDatabase db = getWritableDatabase();
        int deleteNum = db.delete(TP_TABLE_NAME,
                COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return deleteNum;
    }

    public Cursor searchTPList(String query){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TP_TABLE_NAME, // a. table
                TP_COLUMNS, // b. column names
                COL_ITEM_NAME + " LIKE ? AND " + COL_ITEM_BRAND + " LIKE ?", // c. selections
                new String[]{"%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public Cursor getTPComment(int TPid) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(REVIEW_TABLE_NAME,
                REVIEW_COLUMNS,
                COL_REVIEW_ITEM_ID + " = ?",
                new String[]{TPid+""},
                null,
                null,
                null,
                null);
        return cursor;
    }

    public Cursor getTP(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TP_TABLE_NAME, // a. table
                TP_COLUMNS, // b. column names
                COL_ID + " = ?", // c. selections
                new String[]{String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }
}

