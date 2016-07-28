package com.test.contentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jon Kim on 7/27/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Stocks.db";
    public static final String SQL_TABLE_NAME = "stocks";
    public static final String SQL_COL_ID = "_id";
    public static final String SQL_COL_SYMBOL = "symbol";
    public static final String SQL_COL_NAME = "name";
    public static final String SQL_COL_QUANTITY = "quantity";
    public static final String SQL_COL_EXCHANGE_NAME = "exchange_name";
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS "+SQL_TABLE_NAME;
    public static final String SQL_CREATE_TABLE = "CREATE TABLE "
            +SQL_TABLE_NAME+" ("
            +SQL_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +SQL_COL_SYMBOL+" TEXT, "
            +SQL_COL_NAME+" TEXT, "
            +SQL_COL_QUANTITY+" TEXT, "
            +SQL_COL_EXCHANGE_NAME+" TEXT)";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DROP_TABLE);
        onCreate(sqLiteDatabase);
    }
}
