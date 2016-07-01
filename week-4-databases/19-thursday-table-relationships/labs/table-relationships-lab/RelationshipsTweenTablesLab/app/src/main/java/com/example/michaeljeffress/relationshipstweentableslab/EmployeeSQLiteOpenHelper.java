package com.example.michaeljeffress.relationshipstweentableslab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michaeljeffress on 6/30/16.
 */
public class EmployeeSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = EmployeeSQLiteOpenHelper.class.getCanonicalName();
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EMPLOYEE_JOB_DB";
    public static final String JOB_INFO_TABLE_NAME = "JOB INFO";

    //Constructor that tells what the db name and version is.
    private EmployeeSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Define the instance of this class.
    private static EmployeeSQLiteOpenHelper employeeInstance;

    //Allows only one instance to be running throughout the entire app.
    public static EmployeeSQLiteOpenHelper getInstance(Context context) {
        if (employeeInstance == null) {
            employeeInstance = new EmployeeSQLiteOpenHelper(context.getApplicationContext());
        }
        return employeeInstance;
    }

    public static abstract class DataEntryEmployee implements BaseColumns {
        public static final String EMPLOYEE_INFO_TABLE_NAME = "EMPLOYEE INFO";
        public static final String COL_EMPLOYEE_ID = "EMPLOYEE_ID";
        public static final String COL_EMPLOYEE_SSN = "EMPLOYEE_SSN";
        public static final String COL_EMPLOYEE_FIRST_NAME = "EMPLOYEE_FIRST_NAME";
        public static final String COL_EMPLOYEE_LAST_NAME = "EMPLOYEE_LAST_NAME";
        public static final String COL_EMPLOYEE_YOB = "EMPLOYEE_YOB";
        public static final String COL_EMPLOYEE_CITY = "EMPLOYEE_CITY";
    }

    public static abstract class DataEntryJob implements BaseColumns {
        public static final String JOB_INFO_TABLE_NAME = "JOB INFO";
        public static final String COL_JOB_ID = "JOB_ID";
        public static final String COL_JOB_SSN = "JOB_SSN";
        public static final String COL_JOB_COMPANY = "JOB_NAME";
        public static final String COL_JOB_SALARY = "JOB_SALARY";
        public static final String COL_JOB_EXPERIENCE = "JOB_EXPERIENCE";
    }

    //NO LONGER NEEDED WITH OBJECTS?
//    public static final String[] EMPLOYEE_COLUMNS = {COL_EMPLOYEE_ID, COL_EMPLOYEE_SSN, COL_EMPLOYEE_FIRST_NAME,
//            COL_EMPLOYEE_LAST_NAME, COL_EMPLOYEE_YOB, COL_EMPLOYEE_CITY};
//    public static final String[] JOB_COLUMNS = {COL_JOB_ID, COL_JOB_SSN, COL_JOB_COMPANY,
//            COL_JOB_SALARY, COL_JOB_EXPERIENCE};


    //Creates table new table.
    private static final String CREATE_EMPLOYEE_INFO_TABLE =
            "CREATE TABLE " +
                    DataEntryEmployee.EMPLOYEE_INFO_TABLE_NAME + "(" +
                    DataEntryEmployee.COL_EMPLOYEE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DataEntryEmployee.COL_EMPLOYEE_SSN + " TEXT, " +
                    DataEntryEmployee.COL_EMPLOYEE_FIRST_NAME + " TEXT, " +
                    DataEntryEmployee.COL_EMPLOYEE_LAST_NAME + " TEXT, " +
                    DataEntryEmployee.COL_EMPLOYEE_YOB + " INTEGER, " +
                    DataEntryEmployee.COL_EMPLOYEE_CITY + " TEXT )";

    private static final String CREATE_JOB_INFO_TABLE =
            "CREATE TABLE " +
                    DataEntryJob.JOB_INFO_TABLE_NAME + "(" +
                    DataEntryJob.COL_JOB_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DataEntryJob.COL_JOB_SSN + " STRING KEY, " +
                    DataEntryJob.COL_JOB_COMPANY + " TEXT, " +
                    DataEntryJob.COL_JOB_SALARY + " INTEGER, " +
                    DataEntryJob.COL_JOB_EXPERIENCE + " TEXT )";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EMPLOYEE_INFO_TABLE);
        db.execSQL(CREATE_JOB_INFO_TABLE);
    }


    //Deletes old table when updating new table. (Need to get clarity from instructors.)
    private static final String SQL_DELETE_ENTRIES_EMPLOYEES = "DROP TABLE IF EXISTS " +
            DataEntryEmployee.EMPLOYEE_INFO_TABLE_NAME;

    private static final String SQL_DELETE_ENTRIES_JOB = "DROP TABLE IF EXISTS " +
            DataEntryJob.JOB_INFO_TABLE_NAME;

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES_EMPLOYEES);
        db.execSQL(SQL_DELETE_ENTRIES_JOB);
        this.onCreate(db);
    }

    //Implements new employee & job info rows in the DB (+ below)
    public void addEmployeeInfo(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryEmployee.COL_EMPLOYEE_SSN, employee.getSsn());
        values.put(DataEntryEmployee.COL_EMPLOYEE_FIRST_NAME, employee.getFirstName());
        values.put(DataEntryEmployee.COL_EMPLOYEE_LAST_NAME, employee.getLastName());
        values.put(DataEntryEmployee.COL_EMPLOYEE_YOB, employee.getYear());
        values.put(DataEntryEmployee.COL_EMPLOYEE_CITY, employee.getCity());

        db.insertOrThrow(DataEntryEmployee.EMPLOYEE_INFO_TABLE_NAME, null, values);
    }

    public void addJobInfo(Job job) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryJob.COL_JOB_SSN, job.getSsn());
        values.put(DataEntryJob.COL_JOB_COMPANY, job.getCompany());
        values.put(DataEntryJob.COL_JOB_SALARY, job.getSalary());
        values.put(DataEntryJob.COL_JOB_EXPERIENCE, job.getExperience());

        db.insertOrThrow(DataEntryJob.JOB_INFO_TABLE_NAME, null, values);
    }


    public List<String> getEmployeesAtSameCompany() {
        List<String> employees = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();

        // Constructing query using INNER JOIN
        String query = "SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE INNER JOIN JOB ON EMPLOYEE.SSN =" +
                "JOB.SSN WHERE JOB.COMPANY='Macys'";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String firstName = cursor.getString(cursor.getColumnIndex(DataEntryEmployee
                    .COL_EMPLOYEE_FIRST_NAME));
            String lastName = cursor.getString(cursor.getColumnIndex(DataEntryEmployee
                    .COL_EMPLOYEE_LAST_NAME));
            String name = firstName + " " + lastName;
            employees.add(name);
        }
        cursor.close();
        return employees;
    }


    public List<String> getCompaniesInBoston() {
        List<String> companies = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();

        // Constructing query using INNER JOIN
        String query = "SELECT COMPANY FROM JOB INNER JOIN EMPLOYEE ON EMPLOYEE.SSN = " +
                "JOB.SSN WHERE EMPLOYEE.CITY='Boston'";
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            String company = cursor.getString(cursor.getColumnIndex(DataEntryJob
                    .COL_JOB_COMPANY));
            companies.add(company);
        }
        cursor.close();
        return companies;
    }

    public String getCompanyWithHighestSalary () {
        // The string will be returned if there are no entries int the table COMPANY.
        String company = "No data in the database";
        // The default value of the highest salary is equal to 0.
        int highestSalary = 0;
        SQLiteDatabase db = getWritableDatabase();
        // Building query using INNER JOIN keyword
        String query = "SELECT SALARY, COMPANY FROM JOB INNER JOIN EMPLOYEE ON EMPLOYEE.SSN = " +
                "JOB.SSN";
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()) {
            int currentSalary = cursor.getInt(cursor.getColumnIndex(DataEntryJob.COL_JOB_SALARY));
            if (highestSalary < currentSalary) {
                highestSalary = currentSalary;
                company = cursor.getString(cursor.getColumnIndex(DataEntryJob.COL_JOB_COMPANY));
            }
        }
        cursor.close();
        return company;
    }
}

