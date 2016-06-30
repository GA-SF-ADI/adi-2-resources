package com.test.bostoncompaniesandmore;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LangstonSmith on 6/30/16.
 */
public class SQLOpenHelper extends SQLiteOpenHelper {

    private static String EMPLOYEE_TABLE_NAME = "employee";
    private static String COL_SSN = "SSN";
    private static String COL_FIRST_NAME = "First Name";
    private static String COL_LAST_NAME = "Last Name";
    private static String COL_YEAR_OF_BIRTH = "Year of Birth";
    private static String COL_CITY = "City";

    private static String CREATE_TABLE = "CREATE TABLE " + EMPLOYEE_TABLE_NAME;
    private static final String SQL_CREATE_EMPLOYEE_TABLE = "CREATE TABLE " +
            EMPLOYEE_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY," +
            COL_FIRST_NAME + " TEXT," +
            COL_LAST_NAME + " TEXT," +
            COL_YEAR_OF_BIRTH + " INTEGER," +
            COL_CITY + " TEXT);";


    private static String JOB_TABLE_NAME = "job";

    private static String COL_COMPANY = "company";
    private static String COL_SALARY = "salary";
    private static String COL_EXPERIENCE = "experience";

    private static final String SQL_CREATE_JOB_TABLE = "CREATE TABLE " +
            JOB_TABLE_NAME + " (" +
            COL_SSN + " INTEGER PRIMARY KEY," +
            COL_COMPANY + " TEXT," +
            COL_SALARY + " INTEGER," +
            COL_EXPERIENCE + " INTEGER " + ");";


}
