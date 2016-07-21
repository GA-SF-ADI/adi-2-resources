package generalassembly.yuliyakaleda.contentprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

  private static final int DATABASE_VERSION = 1;
  private static final String DATABASE_NAME = "productDB.db";
  public static final String TABLE_PRODUCTS = "products";

  public static final String COLUMN_ID = "_id";
  public static final String COLUMN_PRODUCTNAME = "productname";
  public static final String COLUMN_QUANTITY = "quantity";

  public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    super(context, DATABASE_NAME, factory, DATABASE_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
        TABLE_PRODUCTS + "("
        + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRODUCTNAME
        + " TEXT," + COLUMN_QUANTITY + " INTEGER" + ")";
    db.execSQL(CREATE_PRODUCTS_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
    onCreate(db);
  }

  public long addProduct(ContentValues values) {
    SQLiteDatabase db = getWritableDatabase();
    long insertedRow = db.insert(TABLE_PRODUCTS, null, values);
    db.close();
    return insertedRow;
  }

  public Cursor findProductById(String id) {
    String[] projection = {COLUMN_ID, COLUMN_PRODUCTNAME, COLUMN_QUANTITY};

    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.query(TABLE_PRODUCTS,projection,COLUMN_ID+" = '"+id+"'",null,null,null,null);

    return cursor;
  }

  public Cursor findProductByName(String selection) {
    String[] projection = {COLUMN_ID, COLUMN_PRODUCTNAME, COLUMN_QUANTITY};

    SQLiteDatabase db = getReadableDatabase();
    Cursor cursor = db.query(TABLE_PRODUCTS,projection,selection,null,null,null,null);

    return cursor;
  }

  public int deleteProductByName(String selection) {
    SQLiteDatabase db = getWritableDatabase();

    int rowsDeleted = db.delete(TABLE_PRODUCTS,selection,null);
    db.close();
    return rowsDeleted;
  }

  public int deleteProductById(String id) {
    SQLiteDatabase db = getWritableDatabase();

    int rowsDeleted = db.delete(TABLE_PRODUCTS,COLUMN_ID+" = ?",new String[]{id});
    db.close();
    return rowsDeleted;
  }

  public int updateProduct(ContentValues values, String selection, String id){
    SQLiteDatabase db = getWritableDatabase();

    int updatedRows = 0;

    if(id == null)
      updatedRows = db.update(TABLE_PRODUCTS,values,selection,null);
    else
      updatedRows = db.update(TABLE_PRODUCTS,values,COLUMN_ID+" = ?",new String[]{id});

    db.close();
    return updatedRows;
  }

}
