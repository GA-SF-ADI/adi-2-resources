package com.test.stockportfolio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nolbertoarroyo on 7/27/16.
 */
public class StocksDatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Stocks.db";
    public static final String STOCK_ID = "_id";
    public static final String STOCK_NAME = "name";
    public static final String STOCK_SYMBOL = "symbol";
    public static final String STOCK_QUANTITY = "quantity";
    public static final String STOCK_EXCHANGE_NAME = "exchange";
    public static final String CREATE_STOCKS_TABLE = "CREATE TABLE stocks ( id INTEGER PRIMARY KEY,"+STOCK_NAME +" TEXT," + STOCK_SYMBOL + "TEXT" + STOCK_QUANTITY + "INTEGER" + STOCK_EXCHANGE_NAME + "TEXT )";
    public static final String SQL_DROP_STOCKS_TABLE = "DROP TABLE IF EXISTS stocks";
    public static final String STOCKS_TABLE_NAME= "stocks";
    public static final String[] STOCKS_COLUMNS = {STOCK_ID,STOCK_NAME,STOCK_SYMBOL,STOCK_EXCHANGE_NAME,STOCK_QUANTITY};

    public StocksDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static StocksDatabaseHelper instance;

    public static StocksDatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new StocksDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_STOCKS_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_STOCKS_TABLE);
        onCreate(sqLiteDatabase);


    }
    public void insert(int id, String name, String symbol, int quantity, String stockExchangeName){
        // Get a reference to the database
        SQLiteDatabase db = getWritableDatabase();

        // create a new content value to store values
        ContentValues values = new ContentValues();
        values.put("id", id);
        values.put(STOCK_NAME, name);
        values.put(STOCK_SYMBOL, symbol);
        values.put(STOCK_QUANTITY,quantity);
        values.put(STOCK_EXCHANGE_NAME, stockExchangeName);

        // Insert the row into the games table
        db.insert(STOCKS_TABLE_NAME, null, values);
    }
    public Cursor getStocks(String selection) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(STOCKS_TABLE_NAME, // a. table
                STOCKS_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }
    public long addStock(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        long insertedRow = db.insert(STOCKS_TABLE_NAME, null, values);
        db.close();
        return insertedRow;
    }
    public Cursor getStockSymbols(String selection) {
        String[] projection = {STOCK_SYMBOL};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(STOCKS_TABLE_NAME,projection,selection,null,null,null,null);

        return cursor;
    }

    public int deleteStock(String id) {
        SQLiteDatabase db = getWritableDatabase();
        int deleteNum = db.delete(STOCKS_TABLE_NAME,
                STOCK_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return deleteNum;
    }


}
