package gg.patrickcummins.relationshiplab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.BlurMaskFilter.Blur.INNER;

/**
 * Created by patrickcummins on 6/30/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "db";
    private static final int DATA_BASE_VERSION = 1;
    private static DatabaseHelper DATABASE_INSTANCE;

    //CREATE TABLE STRINGS
    private static final String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + DataEntryEmployee.TABLE_NAME + " (" + DataEntryEmployee._ID + " INTEGER PRIMARY KEY, " + DataEntryEmployee.SSN + " TEXT, " + DataEntryEmployee.FIRST_NAME + " TEXT, " + DataEntryEmployee.LAST_NAME + " TEXT, " + DataEntryEmployee.BIRTH_YEAR + " TEXT, " + DataEntryEmployee.CITY + " TEXT);";
    private static final String CREATE_JOB_TABLE = "CREATE TABLE " + DataEntryJob.TABLE_NAME + " (" + DataEntryJob._ID + " INTEGER PRIMARY KEY, " + DataEntryJob.SSN + " TEXT, " + DataEntryJob.COMPANY + " TEXT," + DataEntryJob.SALARY + " INT," + DataEntryJob.EXPERIENCE + " INT);";

    //DROP TABLE STRINGS
    private static final String DROP_EMPLOYEE_TABLE = "DROP TABLE IF EXISTS " + DataEntryEmployee.TABLE_NAME;
    private static final String DROP_JOB_TABLE = "DROP TABLE IF EXISTS " + DataEntryJob.TABLE_NAME;

    private DatabaseHelper(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);


    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (DATABASE_INSTANCE == null) {
            return new DatabaseHelper(context);
        } else {
            return DATABASE_INSTANCE;
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EMPLOYEE_TABLE);
        db.execSQL(CREATE_JOB_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_EMPLOYEE_TABLE);
        db.execSQL(DROP_JOB_TABLE);
        onCreate(db);
    }

    public static abstract class DataEntryEmployee implements BaseColumns {
        public static final String TABLE_NAME = "employeeTable";
        public static final String SSN = "ssn";
        public static final String FIRST_NAME = "firstName";
        public static final String LAST_NAME = "lastName";
        public static final String BIRTH_YEAR = "birthYear";
        public static final String CITY = "city";
    }

    public static abstract class DataEntryJob implements BaseColumns {
        public static final String TABLE_NAME = "jobTable";
        public static final String SSN = "ssn";
        public static final String COMPANY = "company";
        public static final String SALARY = "salary";
        public static final String EXPERIENCE = "exp";
    }

    public void insertEmployeeRow(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryEmployee.SSN, employee.getSsn());
        values.put(DataEntryEmployee.FIRST_NAME, employee.getFirstName());
        values.put(DataEntryEmployee.LAST_NAME, employee.getLastName());
        values.put(DataEntryEmployee.BIRTH_YEAR, employee.getBirthYear());
        values.put(DataEntryEmployee.CITY, employee.getCity());
        db.insertOrThrow(DataEntryEmployee.TABLE_NAME, null, values);
    }

    public void insertJobRow(Job job) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryJob.SSN, job.getSsn());
        values.put(DataEntryJob.COMPANY, job.getCompany());
        values.put(DataEntryJob.SALARY, job.getSalary());
        values.put(DataEntryJob.EXPERIENCE, job.getExperience());

        db.insertOrThrow(DataEntryJob.TABLE_NAME, null, values);

    }

    public ArrayList<String> getCompaniesInBoston() {
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT " + DataEntryJob.COMPANY + " FROM " + DataEntryJob.TABLE_NAME + " INNER JOIN " + DataEntryEmployee.TABLE_NAME + " ON " + DataEntryEmployee.TABLE_NAME + "." + DataEntryEmployee.SSN + " = " + DataEntryJob.TABLE_NAME + "." + DataEntryJob.SSN + " WHERE " + DataEntryEmployee.CITY + " = 'Boston'", null);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndex(DataEntryJob.COMPANY)));

        }
        cursor.close();
        return list;
    }

    public String getHighestSalary() {
        String myString = "default string";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + DataEntryJob.SALARY + ", " + DataEntryJob.COMPANY + " FROM " + DataEntryJob.TABLE_NAME + " INNER JOIN " + DataEntryEmployee.TABLE_NAME + " ON " + DataEntryEmployee.TABLE_NAME + "." + DataEntryEmployee.SSN + " = " + DataEntryJob.TABLE_NAME + "." + DataEntryJob.SSN, null);

        int currentHighest = 0;
        while (cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndex(DataEntryJob.SALARY)) > currentHighest) {
                myString = cursor.getString(cursor.getColumnIndex(DataEntryJob.COMPANY));
                currentHighest = cursor.getInt(cursor.getColumnIndex(DataEntryJob.SALARY));
            }

        }
        cursor.close();
        return myString;
    }

    public ArrayList<String> getEmployeesAtSameCompany() {
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + DataEntryEmployee.FIRST_NAME + ", " + DataEntryEmployee.LAST_NAME + " FROM " + DataEntryJob.TABLE_NAME + " INNER JOIN " + DataEntryEmployee.TABLE_NAME + " ON " + DataEntryEmployee.TABLE_NAME + "." + DataEntryEmployee.SSN + " = " + DataEntryJob.TABLE_NAME + "." + DataEntryJob.SSN + " WHERE " + DataEntryJob.COMPANY + " = 'Macys'", null);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndex(DataEntryEmployee.FIRST_NAME)) + " " + cursor.getString(cursor.getColumnIndex(DataEntryEmployee.LAST_NAME)));

        }
        cursor.close();
        return list;
    }

    public ArrayList<String> getAllEmployees(){
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT " + DataEntryEmployee.FIRST_NAME + ", " + DataEntryEmployee.LAST_NAME + " FROM " + DataEntryEmployee.TABLE_NAME, null);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndex(DataEntryEmployee.FIRST_NAME)) + " " + cursor.getString(cursor.getColumnIndex(DataEntryEmployee.LAST_NAME)));

        }
        cursor.close();
        return  list;
    }

}
