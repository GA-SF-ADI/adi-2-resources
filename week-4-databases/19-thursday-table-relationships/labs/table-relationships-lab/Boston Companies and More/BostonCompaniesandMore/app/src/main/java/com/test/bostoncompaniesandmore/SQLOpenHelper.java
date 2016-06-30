package com.test.bostoncompaniesandmore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LangstonSmith on 6/30/16.
 */
public class SQLOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static String EMPLOYEE_TABLE_NAME = "employee";
    private static String COL_SSN = "SSN";
    private static String COL_FIRST_NAME = "First Name";
    private static String COL_LAST_NAME = "Last Name";
    private static String COL_YEAR_OF_BIRTH = "Year of Birth";
    private static String COL_CITY = "City";

    private static final String SQL_CREATE_EMPLOYEE_TABLE = "CREATE TABLE " +
            EMPLOYEE_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY," +
            COL_FIRST_NAME + " TEXT," +
            COL_LAST_NAME + " TEXT," +
            COL_YEAR_OF_BIRTH + " INTEGER," +
            COL_CITY + " TEXT);";


    private static String JOB_TABLE_NAME = "job";

    private static String COL_COMPANY_NAME = "company";
    private static String COL_SALARY = "salary";
    private static String COL_EXPERIENCE = "experience";

    private static final String SQL_CREATE_JOB_TABLE = "CREATE TABLE " +
            JOB_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY," +
            COL_COMPANY_NAME + " TEXT," +
            COL_SALARY + " INTEGER," +
            COL_EXPERIENCE + " INTEGER " + ");";

    public static final String[] EMPLOYEE_TABLE_COLUMNS = {COL_SSN, COL_FIRST_NAME,
            COL_LAST_NAME, COL_YEAR_OF_BIRTH, COL_CITY};


    public static final String[] JOB_TABLE_COLUMNS = {COL_COMPANY_NAME, COL_SALARY,
            COL_EXPERIENCE};

    public SQLOpenHelper(Context context) {
        super(context, EMPLOYEE_TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EMPLOYEE_TABLE);
        db.execSQL(SQL_CREATE_JOB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + JOB_TABLE_NAME);
        this.onCreate(db);
    }


    public Cursor getEmployeeTable() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(EMPLOYEE_TABLE_NAME, // a. table
                EMPLOYEE_TABLE_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    public Cursor getJobTable() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(JOB_TABLE_NAME, // a. table
                JOB_TABLE_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }


    public void insertRowIntoJobTable(NewEmployee employee) {
        SQLiteDatabase db = getWritableDatabase();

    }


    public String employeesWorkingAtSameCompany() {
        SQLiteDatabase db = getWritableDatabase();

        return null;
    }

    public String companiesInBoston() {
        SQLiteDatabase db = getWritableDatabase();





        return null;
    }

    public String companyWithHighestSalary() {
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT MAX " + COL_SALARY + " FROM " + JOB_TABLE_NAME + ";";

        Cursor highestSalaryCursor = db.rawQuery(query, null);
        while (highestSalaryCursor.moveToNext()) {
            query = highestSalaryCursor.getString(highestSalaryCursor.getColumnIndex(SQLOpenHelper.______));
        }

        highestSalaryCursor.close();
        return query;

    }


}
