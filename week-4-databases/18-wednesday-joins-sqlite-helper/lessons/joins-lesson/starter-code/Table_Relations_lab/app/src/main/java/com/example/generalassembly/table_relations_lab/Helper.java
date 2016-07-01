package com.example.generalassembly.table_relations_lab;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.database.Cursor;
import android.content.ContentValues;

import  java.util.ArrayList;
import  java.util.List;

/**
 * Created by generalassembly on 6/30/16.
 */
public class Helper extends SQLiteOpenHelper {

    public Helper(Context context) {
        super(context, "db", null, 1);
    }

    private static Helper INSTANCE;

    public static synchronized Helper getINSTANCE(Context context) {
        if (INSTANCE == null)
            INSTANCE = new Helper(context.getApplicationContext());
        return INSTANCE;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_EMPLOYEE);
        db.execSQL(SQL_CREATE_ENTRIES_JOB);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(SQL_DELETE_ENTRIES_EMPLOYEE);
    db.execSQL(SQL_DELETE_ENTRIES_JOB);
    }

    public static abstract class DataEntryJob implements BaseColumns {

        public static final String TABLE_NAME = "job";
        public static final String COLUMN_SNN = "snn";
        public static final String COLUMN_SALARY = "salary";
        public static final String COLUMN_EXPERIENCE = "experience";
        public static final String COLUMN_COMPANY = "company";


    }

    public static abstract class DataEntryEmployee implements BaseColumns {
        public static final String TABLE_NAME = "employee";
        public static final String COLUMN_FN = "first_name";
        public static final String COLUMN_LN = "last_name";
        public static final String COLUMN_YOB = "year_of_birth";
        public static final String COLUMN_CITY = "city";
        public static final String COLUMN_SNN = "snn";




    }

    private static final String SQL_CREATE_ENTRIES_EMPLOYEE = "CREATE TABLE " +
            DataEntryEmployee.TABLE_NAME + " (" +
            DataEntryEmployee._ID + "INTEGER PRIMARY KEY" +
            DataEntryEmployee.COLUMN_SNN + "STRING" +
            DataEntryEmployee.COLUMN_FN + "STRING" +
            DataEntryEmployee.COLUMN_LN + "STRING" +
            DataEntryEmployee.COLUMN_YOB + "INTEGER" +
            DataEntryEmployee.COLUMN_CITY + "STRING " + ")";

    private static final String SQL_CREATE_ENTRIES_JOB = "CREATE TABLE" +
            DataEntryJob.TABLE_NAME + "(" +
            DataEntryJob.COLUMN_SNN + "STRING PRIMARY KEY" +
            DataEntryJob.COLUMN_EXPERIENCE + "INTEGER" +
            DataEntryJob.COLUMN_SALARY + "SALARY" +
            DataEntryJob.COLUMN_COMPANY + "COMPANY" + ")";

    private static final String SQL_DELETE_ENTRIES_JOB = "DROP TABLE IF EXISTS " +
            DataEntryJob.TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES_EMPLOYEES = "DROP TABLE IF EXISTS " +
            DataEntryEmployee.TABLE_NAME;

    public void insertRow(Employee employee){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.writeToParcel(DataEntryEmployee.COLUMN_SNN, employee.getSnn());
        values.writeToParcel(DataEntryEmployee.COLUMN_FN, employee.getFN());
        values.writeToParcel(DataEntryEmployee.COLUMN_LN,employee.getFN());
        values.writeToParcel(DataEntryEmployee.COLUMN_YOB,employee.getFN());
        values.writeToParcel(DataEntryEmployee.COLUMN_CITY,employee.getFN());

        db.insertOrThrow(DataEntryEmployee.TABLE_NAME, null, values);

    }
    public void insertRowJob (Job job){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryJob.COLUMN_SNN, job.getSnn());
        values.put(DataEntryJob.COLUMN_COMPANY, job.getSnn());
        values.put(DataEntryJob.COLUMN_SALARY, job.getSnn());
        values.put(DataEntryJob.COLUMN_EXPERIENCE, job.getSnn());

        db.insertOrThrow(DataEntryJob.TABLE_NAME, null, values);

    }
    public List<String> getEmployeesWorkingAtTheSameCompany () {
        List<String> employees = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        // Building query using INNER JOIN keyword
        String query = "SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE INNER JOIN JOB ON EMPLOYEE.SSN =" +
                "JOB.SSN WHERE JOB.COMPANY='Macys'";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()) {
            String firstName = cursor.getString(cursor.getColumnIndex(DataEntryEmployee
                    .COLUMN_FN));
            String lastName = cursor.getString(cursor.getColumnIndex(DataEntryEmployee
                    .COLUMN_LN));
            String name = firstName + " " + lastName;
            employees.add(name);
        }
        cursor.close();
        return employees;

}}
