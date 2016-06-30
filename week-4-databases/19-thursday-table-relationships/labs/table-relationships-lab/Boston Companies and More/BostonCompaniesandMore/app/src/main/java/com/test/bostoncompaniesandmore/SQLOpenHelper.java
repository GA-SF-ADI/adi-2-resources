package com.test.bostoncompaniesandmore;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by LangstonSmith on 6/30/16.
 */
public class SQLOpenHelper extends SQLiteOpenHelper {

    private static String EMPLOYEE_TABLE_NAME = "employee";
    private static String COL_ID = "_id";
    private static String COL_SSN = "_id";
    private static String COL_FIRST_NAME = "_id";
    private static String COL_LAST_NAME = "_id";
    private static String COL_YEAR_OF_BIRTH = "_id";
    private static String COL_CITY = "_id";

    private static String CREATE_TABLE = "CREATE TABLE " + EMPLOYEE_TABLE_NAME;




    private static String JOB_TABLE_NAME = "job";

    private static String COL_COMPANY = "_id";
    private static String COL_SALARY = "_id";

    private static String CREATE_NEW_TABLE = "CREATE TABLE ";


}
