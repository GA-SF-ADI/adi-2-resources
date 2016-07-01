package com.test.relationshipsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nolbertoarroyo on 6/30/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "Business Table.db";



    public static final String EMPLOYEE_COL_ID = "_id";
    public static final String EMPLOYEE_TABLE_NAME= "EMPLOYEE";
    public static final String COL_SSN="SSN";
    public static final String COL_ITEM_FIRST_NAME = "FIRST NAME";
    public static final String COL_ITEM_LAST_NAME = "LAST NAME";
    public static final String COL_ITEM_BIRTH = "BIRTH";
    public static final String COL_ITEM_CITY = "CITY";
    public static final String[] EMPLOYEE_COLUMNS = {EMPLOYEE_COL_ID,COL_SSN,COL_ITEM_FIRST_NAME,COL_ITEM_LAST_NAME,COL_ITEM_BIRTH,COL_ITEM_CITY};
    public static final String JOB_TABLE_NAME= "JOB";
    public static final String COL_JOB_SSN= "SSN";
    public static final String COL_ITEM_COMPANY = "COMPANY";
    public static final String COL_ITEM_SALARY = "SALARY";
    public static final String COL_EXPERIENCE = "EXPERIENCE";
    public static final String JOB_COL_ID = "_id";
    public static final String[] JOB_COLUMNS = {JOB_COL_ID,COL_SSN,COL_ITEM_COMPANY,COL_ITEM_SALARY,COL_EXPERIENCE};


    private static final String CREATE_EMPLOYEE_TABLE =
            "CREATE TABLE " + EMPLOYEE_TABLE_NAME +
                    "(" +
                    EMPLOYEE_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_SSN + " TEXT UNIQUE, " +
                    COL_ITEM_FIRST_NAME + " TEXT, " +
                    COL_ITEM_LAST_NAME + " TEXT, " +
                    COL_ITEM_BIRTH + " INTEGER, " + COL_ITEM_CITY + " TEXT )";

    private static final String CREATE_JOB_TABLE =
            "CREATE TABLE " + JOB_TABLE_NAME +
                    "(" +
                    JOB_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_JOB_SSN + " TEXT, " +
                    COL_ITEM_COMPANY + " TEXT, " +
                    COL_ITEM_SALARY + " INTEGER, " +
                    COL_EXPERIENCE + " INTEGER )";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    private static DatabaseHelper instance;

    public static DatabaseHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }


        @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EMPLOYEE_TABLE);
        db.execSQL(CREATE_JOB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + JOB_TABLE_NAME);
        onCreate(db);
    }
    public long addEmployeeItem(String ssn, String firstName, String last, int birth, String city){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, ssn);
        values.put(COL_ITEM_FIRST_NAME, firstName);
        values.put(COL_ITEM_LAST_NAME, last);
        values.put(COL_ITEM_BIRTH, birth);
        values.put(COL_ITEM_CITY, city);
        long returnId = db.insert(EMPLOYEE_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }
    public long addJobItem(String snn, String company, int salary, int experience){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_JOB_SSN, snn);
        values.put(COL_ITEM_COMPANY, company);
        values.put(COL_ITEM_SALARY, salary);
        values.put(COL_EXPERIENCE, experience);
        long returnId = db.insert(JOB_TABLE_NAME, null, values);
        db.close();
        return returnId;
    }
    public Cursor getEmployeeTable(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(EMPLOYEE_TABLE_NAME, // a. table
                EMPLOYEE_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;


    }
    public Cursor getJobTable(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(JOB_TABLE_NAME, // a. table
                JOB_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;

}
    public String getMacyWorkers(){
        String result = "default name";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT FIRST NAME, LAST NAME FROM EMPLOYEE INNER JOIN JOB ON EMPLOYEE.SSN = JOB.SSN WHERE JOB.COMPANY = 'Macys'";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()) {
            String first = cursor.getString(cursor.getColumnIndex(COL_ITEM_FIRST_NAME));
                    String last = cursor.getString(cursor.getColumnIndex(COL_ITEM_LAST_NAME));
            result = first + " " + last;
        }
        cursor.close();
        return result;
    }




    }

