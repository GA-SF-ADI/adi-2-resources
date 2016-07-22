package drewmahrt.generalassemb.ly.investingportfolio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

  private static final int DATABASE_VERSION = 1;
  private static final String DATABASE_NAME = "portfolioDB.db";
  public static final String TABLE_STOCKS = "stocks";

  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_STOCK_SYMBOL = "symbol";
  public static final String COLUMN_STOCKNAME = "stockname";
  public static final String COLUMN_QUANTITY = "quantity";
  public static final String COLUMN_EXCHANGE = "exchange";

  public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    super(context, DATABASE_NAME, factory, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
        TABLE_STOCKS + "("
        + COLUMN_ID + " INTEGER PRIMARY KEY,"
            + COLUMN_STOCKNAME + " TEXT,"
            + COLUMN_EXCHANGE + " TEXT,"
            + COLUMN_STOCK_SYMBOL + " TEXT,"
            + COLUMN_QUANTITY + " INTEGER" + ")";
    db.execSQL(CREATE_PRODUCTS_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_STOCKS);
    onCreate(db);
  }

  public long addStock(ContentValues values) {
    SQLiteDatabase db = getWritableDatabase();
    long insertedRow = db.insert(TABLE_STOCKS, null, values);
    db.close();
    return insertedRow;
  }

  public Cursor getStockSymbols(String selection) {
    String[] projection = {COLUMN_STOCK_SYMBOL};

    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.query(TABLE_STOCKS,projection,selection,null,null,null,null);

    return cursor;
  }

  public Cursor getStocks(String selection) {
    String[] projection = {COLUMN_ID,COLUMN_STOCK_SYMBOL,COLUMN_STOCKNAME,COLUMN_EXCHANGE,COLUMN_QUANTITY};

    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.query(TABLE_STOCKS,projection,selection,null,null,null,null);

    return cursor;
  }

  public int deleteStockById(String id) {
    SQLiteDatabase db = getWritableDatabase();

    int rowsDeleted = db.delete(TABLE_STOCKS,id,null);
    db.close();
    return rowsDeleted;
  }

}
