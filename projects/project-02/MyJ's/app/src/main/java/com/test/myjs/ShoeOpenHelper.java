package com.test.myjs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by nolbertoarroyo on 7/10/16.
 */
//created datatbase helper class
public class ShoeOpenHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Shoes.db";


    //set constructor for helper
    public ShoeOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static ShoeOpenHelper instance;

    public static ShoeOpenHelper getInstance(Context context) {
        if (instance == null) {
            instance = new ShoeOpenHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create tables
        db.execSQL(SQL_CREATE_ENTRIES_SHOES);
        db.execSQL(SQL_CREATE_ENTRIES_SHOPPING_CART);

    }

    //deleting tables and updating them
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES_SHOES);
        db.execSQL(SQL_DELETE_ENTRIES_SHOPPING_CART);
        onCreate(db);

    }

    public static abstract class DataEntryShoes implements BaseColumns {
        public static final String SHOE_TABLE_NAME = "SHOES";
        public static final String COL_NAME = "NAME";
        public static final String COL_DESCRIPTION = "DESCRIPTION";
        public static final String COL_PRICE = "PRICE";
        public static final String COL_STYLE = "STYLE";
        public static final String COL_YEAR = "YEAR";
        public static final String COL_IMG_ID = "IMG_ID";
        public static final String COL_SHOE_ID = "_id";
        public static final String COL_COLOR = "COLOR";


    }

    public static abstract class DataEntryShoppingCart implements BaseColumns {
        public static final String TABLE_NAME = "SHOPPING";
        public static final String COL_CART_PRICE = "PRICE";
        public static final String COL_ITEM_NAME = "NAME";
        public static final String COL_ITEM_IMAGE_ID = "IMG_ID";
        public static final String COL_ITEM_YEAR = "YEAR";
        public static final String COL_ID = "_id";
        public static final String COL_ITEM_DESCRIPTION = "DESCRIPTION";

    }

    private static final String SQL_CREATE_ENTRIES_SHOES = "CREATE TABLE " +
            DataEntryShoes.SHOE_TABLE_NAME + " (" +
            DataEntryShoes.COL_SHOE_ID + " INTEGER PRIMARY KEY," +
            DataEntryShoes.COL_NAME + " TEXT," +
            DataEntryShoes.COL_DESCRIPTION + " TEXT," +
            DataEntryShoes.COL_PRICE + " DOUBLE," +
            DataEntryShoes.COL_YEAR + " INTEGER," +
            DataEntryShoes.COL_STYLE + " TEXT," +
            DataEntryShoes.COL_COLOR + " TEXT," +
            DataEntryShoes.COL_IMG_ID + " INTEGER)";

    private static final String SQL_DELETE_ENTRIES_SHOES = "DROP TABLE IF EXISTS " +
            DataEntryShoes.SHOE_TABLE_NAME;
    public static final String[] SHOES_COLUMNS = {DataEntryShoes.COL_SHOE_ID, DataEntryShoes.COL_NAME, DataEntryShoes.COL_DESCRIPTION, DataEntryShoes.COL_PRICE, DataEntryShoes.COL_YEAR, DataEntryShoes.COL_STYLE, DataEntryShoes.COL_IMG_ID};

   /* private static final String SQL_CREATE_ENTRIES_SHOPPING_CART = "CREATE TABLE " +
            DataEntryShoppingCart.TABLE_NAME + " (" +
            DataEntryShoppingCart.COL_ID + " INTEGER PRIMARY KEY," +
            DataEntryShoppingCart.COL_TOTAL_PRICE + " DOUBLE," +
            DataEntryShoppingCart.COL_NUM_ITEMS + " INTEGER," +
            DataEntryShoppingCart.COL_ITEM_ID + " INTEGER" + ")";
*/
   private static final String SQL_CREATE_ENTRIES_SHOPPING_CART = "CREATE TABLE " +
           DataEntryShoppingCart.TABLE_NAME + " (" +
           DataEntryShoppingCart.COL_ID + " INTEGER PRIMARY KEY," +
           DataEntryShoppingCart.COL_CART_PRICE + " DOUBLE," +
           DataEntryShoppingCart.COL_ITEM_NAME + " TEXT,"+
           DataEntryShoppingCart.COL_ITEM_DESCRIPTION + " TEXT," +
           DataEntryShoppingCart.COL_ITEM_IMAGE_ID + " INTEGER," +
           DataEntryShoppingCart.COL_ITEM_YEAR + " INTEGER"+ ")";
    private static final String SQL_DELETE_ENTRIES_SHOPPING_CART = "DROP TABLE IF EXISTS " +
            DataEntryShoppingCart.TABLE_NAME;
    public static final String[] SHOPPING_CART_COLUMNS = {DataEntryShoppingCart.COL_ID, DataEntryShoppingCart.COL_ITEM_NAME, DataEntryShoppingCart.COL_ITEM_IMAGE_ID, DataEntryShoppingCart.COL_ITEM_YEAR, DataEntryShoppingCart.COL_CART_PRICE,DataEntryShoppingCart.COL_ITEM_DESCRIPTION};

    public void insertRowShoes(Shoe shoe) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryShoes.COL_SHOE_ID, shoe.getId());
        values.put(DataEntryShoes.COL_NAME, shoe.getName());
        values.put(DataEntryShoes.COL_DESCRIPTION, shoe.getDescription());
        values.put(DataEntryShoes.COL_PRICE, shoe.getPrice());
        values.put(DataEntryShoes.COL_STYLE, shoe.getStyle());
        values.put(DataEntryShoes.COL_YEAR, shoe.getYear());
        values.put(DataEntryShoes.COL_IMG_ID, shoe.getImageId());
        values.put(DataEntryShoes.COL_COLOR, shoe.getColor());
        db.insertOrThrow(DataEntryShoes.SHOE_TABLE_NAME, null, values);
    }

   /* public void insertRowShoppingCart(ShoppingCart cart) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryShoppingCart.COL_ID, cart.getId());
        values.put(DataEntryShoppingCart.COL_TOTAL_PRICE, cart.getTotalPrice());
        values.put(DataEntryShoppingCart.COL_NUM_ITEMS, cart.getNumItems());
        values.put(DataEntryShoppingCart.COL_ITEM_ID, cart.getNumItems());
        db.insertOrThrow(DataEntryShoppingCart.TABLE_NAME, null, values);
    }
*/public void insertRowShoppingCart(String name, double price, int imageId, int year, String description) {
       SQLiteDatabase db = getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put(DataEntryShoppingCart.COL_ITEM_NAME, name);
       values.put(DataEntryShoppingCart.COL_CART_PRICE, price);
       values.put(DataEntryShoppingCart.COL_ITEM_IMAGE_ID, imageId);
       values.put(DataEntryShoppingCart.COL_ITEM_YEAR, year);
       values.put(DataEntryShoppingCart.COL_ITEM_DESCRIPTION,description);
       db.insertOrThrow(DataEntryShoppingCart.TABLE_NAME, null, values);
   }
    public Cursor getShoesList() {
        //returning shoelist table with cursor

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DataEntryShoes.SHOE_TABLE_NAME, // a. table
                SHOES_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    public int deleteItem(long id) {
        SQLiteDatabase db = getWritableDatabase();
        int deleteNum = db.delete(DataEntryShoes.SHOE_TABLE_NAME,
                DataEntryShoes.COL_SHOE_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return deleteNum;
    }

    public Cursor getShoppingCart() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DataEntryShoppingCart.TABLE_NAME, // a. table
                SHOPPING_CART_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    public int deleteItemFromCart(long id) {
        SQLiteDatabase db = getWritableDatabase();
        int deleteNum = db.delete(DataEntryShoppingCart.TABLE_NAME,
                DataEntryShoppingCart.COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return deleteNum;
    }
    public void deleteAllFromCart(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ DataEntryShoppingCart.TABLE_NAME); //delete all rows in a table
        db.close();
    }

    // create method getShoeById, to use for getting item
    public Cursor getShoeById(long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DataEntryShoes.SHOE_TABLE_NAME, // a. table
                SHOES_COLUMNS, // b. column names
                DataEntryShoes.COL_SHOE_ID + " = ?", // c. selections
                new String[]{String.valueOf(id)}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

    public Cursor search(String query) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(DataEntryShoes.SHOE_TABLE_NAME, // a. table
                SHOES_COLUMNS, // b. column names
                DataEntryShoes.COL_COLOR + " LIKE ? OR " + DataEntryShoes.COL_YEAR + " LIKE ?", // c. selections
                new String[]{"%"+query+"%", "%"+ query+"%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }
    //create search query for color

}







