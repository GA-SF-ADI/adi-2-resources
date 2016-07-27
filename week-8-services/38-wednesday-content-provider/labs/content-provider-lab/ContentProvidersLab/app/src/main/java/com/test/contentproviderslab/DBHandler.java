package com.test.contentproviderslab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by audreyeso on 7/27/16.
 */
public class DBHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "stockDB.db";
    public static final String TABLE_STOCKS = "stocks";
   // Store the stock symbol, company name, quantity of stock, and the stock exchange name in the database

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_SYMBOL = "stocksymbol";
    public static final String COLUMN_COMPANY_NAME = "companyname";
    public static final String COLUMN_QUANTITY="quantity";
    public static final String COLUMN_STOCK_EXCHANGE_NAME ="stockname";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_STOCKS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_SYMBOL
                + " TEXT," + COLUMN_COMPANY_NAME + " TEXT" + COLUMN_QUANTITY
                + " TEXT," + COLUMN_STOCK_EXCHANGE_NAME + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STOCKS);
        onCreate(sqLiteDatabase);
    }
}
