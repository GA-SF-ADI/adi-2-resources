package com.example.michaeljeffress.contentproviderlab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by michaeljeffress on 7/27/16.
 */
public class DBHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "companyDB.db";
    public static final String TABLE_COMPANY = "company";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMPANYNAME = "companyname";
    public static final String COLUMN_QUANTITY = "stockQuantity";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_COMPANY + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_COMPANYNAME
                + " TEXT," + COLUMN_QUANTITY + " INTEGER" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANY);
        onCreate(db);
    }

    public long addCompany(ContentValues values) {
        SQLiteDatabase db = getWritableDatabase();
        long insertedRow = db.insert(TABLE_COMPANY, null, values);
        db.close();
        return insertedRow;
    }

    public Cursor findCompanyById(String id) {
        String[] projection = {COLUMN_ID, COLUMN_COMPANYNAME, COLUMN_QUANTITY};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_COMPANY,projection,COLUMN_ID+" = '"+id+"'",null,null,null,null);

        return cursor;
    }

    public Cursor findCompanyByName(String selection) {
        String[] projection = {COLUMN_ID, COLUMN_COMPANYNAME, COLUMN_QUANTITY};

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_COMPANY,projection,selection,null,null,null,null);

        return cursor;
    }

    public int deleteCompanyByName(String selection) {
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete(TABLE_COMPANY,selection,null);
        db.close();
        return rowsDeleted;
    }

    public int deleteCompanyById(String id) {
        SQLiteDatabase db = getWritableDatabase();

        int rowsDeleted = db.delete(TABLE_COMPANY,COLUMN_ID+" = ?",new String[]{id});
        db.close();
        return rowsDeleted;
    }

    public int updateCompany(ContentValues values, String selection, String id){
        SQLiteDatabase db = getWritableDatabase();

        int updatedRows = 0;

        if(id == null)
            updatedRows = db.update(TABLE_COMPANY,values,selection,null);
        else
            updatedRows = db.update(TABLE_COMPANY,values,COLUMN_ID+" = ?",new String[]{id});

        db.close();
        return updatedRows;
    }


}
