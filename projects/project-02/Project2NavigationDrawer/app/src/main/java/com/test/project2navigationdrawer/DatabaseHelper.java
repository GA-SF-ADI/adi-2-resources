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

    public static DatabaseHelper databaseHelper;

    //had to make Singleton
    public static DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null)
            databaseHelper = new DatabaseHelper(context.getApplicationContext());
        return databaseHelper;
    }

    //table 1 for list of items
    //private static final String TAG = "DBAdapter";

    private static final String TAG = DatabaseHelper.class.getCanonicalName();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Jewelry.db";
    public static final String TABLE_NAME = "jewelry_table";
    public static final String COL_1_ID = "_id";
    public static final String COL_2_TYPE = "TYPE";
    public static final String COL_3_PRICE = "PRICE";
    public static final String COL_4_GOLD = "GOLD_TYPE";
    public static final String COL_5_STONE = "STONE_TYPE";
    public static final String COL_6_MEASUREMENT = "MEASUREMENT";
    public static final String COL_7_QUANTITY = "QUANTITY";
    public static final String COL_8_NAME = "NAME";
    public static final String COL_9_IMAGE = "IMAGE";

    //table 2 for shopping cart
    public static final String TABLE_NAME_SHOPPING_CART = "shopping_cart_table";
    public static final String COL_1_ID_SHOPPING_CART = "_id";
    public static final String COL_2_TYPE_SHOPPING_CART = "TYPE";
    public static final String COL_3_PRICE_SHOPPING_CART = "PRICE";
    public static final String COL_4_GOLD_SHOPPING_CART = "GOLD_TYPE";
    public static final String COL_5_STONE_SHOPPING_CART = "STONE_TYPE";
    public static final String COL_6_MEASUREMENT_SHOPPING_CART = "MEASUREMENT";
    public static final String COL_7_QUANTITY_SHOPPING_CART = "QUANTITY";
    public static final String COL_8_NAME_SHOPPING_CART = "NAME";
    public static final String COL_9_IMAGE_SHOPPING_CART = "IMAGE";

    //columns of shopping cart (that user will add to shopping cart)

    public static final String[] SHOPPING_CART_COLUMNS = {COL_1_ID_SHOPPING_CART, COL_2_TYPE_SHOPPING_CART,
            COL_3_PRICE_SHOPPING_CART, COL_4_GOLD_SHOPPING_CART, COL_5_STONE_SHOPPING_CART, COL_6_MEASUREMENT_SHOPPING_CART,
            COL_7_QUANTITY_SHOPPING_CART, COL_8_NAME_SHOPPING_CART, COL_9_IMAGE_SHOPPING_CART};

    //columns of jewelry columns that are disyplayed
    public static final String[] JEWELRY_COLUMNS = {COL_1_ID, COL_2_TYPE, COL_3_PRICE, COL_4_GOLD,
            COL_5_STONE, COL_6_MEASUREMENT, COL_7_QUANTITY, COL_8_NAME, COL_9_IMAGE};

    private static final String CREATE_SHOPPING_LIST_TABLE =
            "CREATE TABLE " + TABLE_NAME +
                    "(" +
                    COL_1_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_2_TYPE + " TEXT, " +
                    COL_3_PRICE + " DOUBLE, " +
                    COL_4_GOLD + " TEXT, " +
                    COL_5_STONE + " TEXT, " +
                    COL_6_MEASUREMENT + " TEXT, " +
                    COL_7_QUANTITY + " TEXT, " +
                    COL_8_NAME + " TEXT, " +
                    COL_9_IMAGE + " INTEGER )";

    private static final String CREATE_SHOPPING_CART_TABLE =
            "CREATE TABLE " + TABLE_NAME_SHOPPING_CART +
                    "(" +
                    COL_1_ID_SHOPPING_CART + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_2_TYPE_SHOPPING_CART + " TEXT, " +
                    COL_3_PRICE_SHOPPING_CART + " DOUBLE, " +
                    COL_4_GOLD_SHOPPING_CART + " TEXT, " +
                    COL_5_STONE_SHOPPING_CART + " TEXT, " +
                    COL_6_MEASUREMENT_SHOPPING_CART + " TEXT, " +
                    COL_7_QUANTITY_SHOPPING_CART + " TEXT, " +
                    COL_8_NAME_SHOPPING_CART + " TEXT, " +
                    COL_9_IMAGE_SHOPPING_CART + " INTEGER )";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    //execute tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        //will execute query
        db.execSQL(CREATE_SHOPPING_LIST_TABLE);
        db.execSQL(CREATE_SHOPPING_CART_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    //method to insert items
    public void insert(String id, String type, double price, String gold, String stone, String measurement, String name,int image) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1_ID, id);
        values.put(COL_2_TYPE, type);
        values.put(COL_3_PRICE, price);
        values.put(COL_4_GOLD, gold);
        values.put(COL_5_STONE, stone);
        values.put(COL_6_MEASUREMENT, measurement);
        //values.put(COL_7_QUANTITY, quantity);
        values.put(COL_8_NAME, name);
        values.put(COL_9_IMAGE, image);

        db.insert(TABLE_NAME, null, values);

    }

    //method to insert ShoppingCart
    public void insertShoppingCart(String type, double price,
                                   String gold, String stone, String measurement,  String name, int image) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2_TYPE_SHOPPING_CART, type);
        values.put(COL_3_PRICE_SHOPPING_CART, price);
        values.put(COL_4_GOLD_SHOPPING_CART, gold);
        values.put(COL_5_STONE_SHOPPING_CART, stone);
        values.put(COL_6_MEASUREMENT_SHOPPING_CART, measurement);
        //values.put(COL_7_QUANTITY_SHOPPING_CART, quantity);
        values.put(COL_8_NAME_SHOPPING_CART, name);
        values.put(COL_9_IMAGE_SHOPPING_CART, image);

        db.insert(TABLE_NAME_SHOPPING_CART, null, values);
        db.close();
    }

    //method to get all jewelry columns
    public Cursor getJewelry() {
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

    //method to get items by id
    public Item getItemById(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, JEWELRY_COLUMNS,
                COL_1_ID +" = ?",
                new String [] {String.valueOf(id)},
                null,
                null,
                null,
                null);

        if(cursor.moveToFirst()) {
        Item customerItem = new Item(
                cursor.getString(cursor.getColumnIndex(COL_1_ID)),
                cursor.getString(cursor.getColumnIndex(COL_2_TYPE)),
                cursor.getDouble(cursor.getColumnIndex(COL_3_PRICE)),
                cursor.getString(cursor.getColumnIndex(COL_4_GOLD)),
                cursor.getString(cursor.getColumnIndex(COL_5_STONE)),
                cursor.getString(cursor.getColumnIndex(COL_6_MEASUREMENT)),
                cursor.getString(cursor.getColumnIndex(COL_8_NAME)),
                cursor.getInt(cursor.getColumnIndex(COL_9_IMAGE)));
                return customerItem;
        } else {
            return null;
        }
    }

    public Cursor getShoppingCart() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME_SHOPPING_CART, // a. table
                SHOPPING_CART_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    //created so that user can search based on COL 2, 4, 5, and 8 only
    public Cursor searchShoppingList(String query) {

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.query(TABLE_NAME,
                JEWELRY_COLUMNS,
                        "_id LIKE" + "'%" + query + "%' OR " + COL_2_TYPE +
                        " LIKE" + "'%" + query + "%' OR " + COL_4_GOLD +
                        " LIKE" + "'%" + query + "%' OR " + COL_5_STONE +
                        " LIKE" + "'%" + query + "%' OR " + COL_8_NAME +
                        " LIKE" + "'%" + query + "%'",
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }

    //used to remove all items and CLEAR price
    public void deleteAll () {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME_SHOPPING_CART, null, null);

    }

}
