package com.test.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jon Kim on 7/8/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    private static DataBaseHelper mInstance;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Alcohol.db";
    public static final String CART_TABLE_NAME = "CART";
    public static final String CART_COL_ID = "_id";
    public static final String CART_COL_ALC_ID = "ALC_ID";
    public static final String CART_COL_QUANTITY = "QUANTITY";
    public static final String[] CART_COLUMN = {CART_COL_ID,CART_COL_ALC_ID,CART_COL_QUANTITY};
    public static final String ALCOHOL_TABLE_NAME = "ALCOHOL";
    public static final String COL_ALC_ID = "_id";
    public static final String COL_ALC_NAME = "NAME";
    public static final String COL_ALC_PRICE = "PRICE";
    public static final String COL_ALC_ABV = "ABV";
    public static final String COL_ALC_DESCRIPTION = "DESCRIPTION";
    public static final String COL_ALC_IMAGE = "IMAGE";
    public static final String[] ALC_COLUMN = {COL_ALC_ID,COL_ALC_NAME,COL_ALC_PRICE,COL_ALC_ABV,COL_ALC_DESCRIPTION,COL_ALC_IMAGE};
    public static final String SQL_CREATE_ALC_TABLE = "CREATE TABLE "
            +ALCOHOL_TABLE_NAME+"("
            +COL_ALC_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_ALC_NAME+" TEXT, "
            +COL_ALC_ABV+" INTEGER, "
            +COL_ALC_PRICE+" INTEGER, "
            +COL_ALC_DESCRIPTION+" TEXT, "
            +COL_ALC_IMAGE+" INT)";
    public static final String SQL_CREATE_CART_TABLE = "CREATE TABLE "
            +CART_TABLE_NAME+"("
            +CART_COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CART_COL_QUANTITY+" INTEGER, "
            +CART_COL_ALC_ID+" INTEGER, FOREIGN KEY ("+CART_COL_ALC_ID+") REFERENCES "+ALCOHOL_TABLE_NAME+"(id))";


    public static DataBaseHelper getInstance(Context context){
        if(mInstance == null){
            mInstance = new DataBaseHelper(context.getApplicationContext());
        }
        return mInstance;
    }


    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ALC_TABLE);
        db.execSQL(SQL_CREATE_CART_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS "+ALCOHOL_TABLE_NAME);
        db.execSQL("DROP IF TABLE EXISTS "+CART_TABLE_NAME);
        this.onCreate(db);
    }

    public Cursor searchAlcohol(String query){
        SQLiteDatabase db = this.getReadableDatabase();
        try{
            Integer.valueOf(query);
            Cursor cursor1 = db.query(ALCOHOL_TABLE_NAME,
                    ALC_COLUMN,
                    COL_ALC_PRICE + " < ?",
                    new String[]{query},
                    null,
                    null,
                    COL_ALC_PRICE+" DESC",
                    null);
            return cursor1;

        }catch (NumberFormatException e){
        Cursor cursor = db.query(ALCOHOL_TABLE_NAME,
                ALC_COLUMN,
                COL_ALC_DESCRIPTION + " LIKE ? OR " + COL_ALC_NAME + " LIKE ?",
                new String[]{"%" + query + "%", "%" + query + "%"},
                null,
                null,
                COL_ALC_PRICE+" DESC",
                null);
        return cursor;
        }

    }

    public Alcohol getAlcohol(long id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ALCOHOL_TABLE_NAME,
                ALC_COLUMN,
                COL_ALC_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        cursor.moveToFirst();


        Alcohol alcohol = new Alcohol(
                cursor.getString(cursor.getColumnIndex(COL_ALC_NAME)),
                cursor.getInt(cursor.getColumnIndex(COL_ALC_PRICE)),
                cursor.getInt(cursor.getColumnIndex(COL_ALC_ABV)),
                cursor.getString(cursor.getColumnIndex(COL_ALC_DESCRIPTION)),
                cursor.getInt(cursor.getColumnIndex(COL_ALC_IMAGE)),
                cursor.getInt(cursor.getColumnIndex(COL_ALC_ID)));

        return alcohol;
    }

    public void addAlcohol(Alcohol alcohol){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_ALC_NAME,alcohol.getAlcName());
        values.put(COL_ALC_ABV,alcohol.getAbv());
        values.put(COL_ALC_PRICE,alcohol.getAlcPrice());
        values.put(COL_ALC_DESCRIPTION,alcohol.getDescription());
        values.put(COL_ALC_IMAGE,alcohol.getImage());

        db.insert(ALCOHOL_TABLE_NAME, null, values);
        db.close();
    }

    public Cursor getAlcoholList(){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(ALCOHOL_TABLE_NAME,
                ALC_COLUMN,
                null,
                null,
                null,
                null,
                COL_ALC_NAME+" ASC",
                null);

        return cursor;
    }

    public void addCart(Cart cart){
        SQLiteDatabase db = getWritableDatabase();
//        int qty = cart.getQuantity();
//        int alcId = cart.getfAlcId();
//        String query = "UPDATE "+CART_TABLE_NAME+" SET "+CART_COL_QUANTITY+"="+CART_COL_QUANTITY+"+"+qty+"WHERE "+CART_COL_ALC_ID+"="+alcId;
//        String query = "INSERT OR REPLACE INTO "+CART_TABLE_NAME+"("+CART_COL_ID+", "+CART_COL_QUANTITY+", "+CART_COL_ALC_ID+") VALUES ((SELECT "+CART_COL_ID+" FROM "+CART_TABLE_NAME+" WHERE "+CART_COL_ALC_ID+"="+alcId+"),+"+qty+","+alcId+")";
//        db.rawQuery(query,null);



        ContentValues values = new ContentValues();
        values.put(CART_COL_QUANTITY,cart.getQuantity());
        values.put(CART_COL_ALC_ID,cart.getfAlcId());
        db.insert(CART_TABLE_NAME, null, values);
        db.close();
    }
    //inner joins to get alcohol properties and quantity using alcid from the cart item.
    public Cursor getCartAlcList(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT "
                +ALCOHOL_TABLE_NAME+"."
                +COL_ALC_NAME+", "
                +ALCOHOL_TABLE_NAME+"."
                +COL_ALC_PRICE+", "
                +ALCOHOL_TABLE_NAME+"."
                +COL_ALC_IMAGE+", "
                +CART_TABLE_NAME+"."
                +CART_COL_QUANTITY+", "
                +CART_TABLE_NAME+"."
                +CART_COL_ID+ " FROM "
                +ALCOHOL_TABLE_NAME+" INNER JOIN "
                +CART_TABLE_NAME+" ON "+ALCOHOL_TABLE_NAME+"."+COL_ALC_ID+" = "+CART_TABLE_NAME+"."+CART_COL_ALC_ID;

        return db.rawQuery(query,null);
    }

    public void deleteCart(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "DELETE FROM "+CART_TABLE_NAME;
        db.execSQL(query);
        db.close();
    }
}
