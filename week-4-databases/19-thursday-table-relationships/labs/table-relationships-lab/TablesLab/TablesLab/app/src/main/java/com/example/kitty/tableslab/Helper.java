package com.example.kitty.tableslab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by kitty on 6/30/16.
 */
public class Helper extends SQLiteOpenHelper{

    public Helper(Context context) {
        super(context, "db", null, 1);
    }

    private static Helper INSTANCE;

    public static synchronized Helper getInstance(Context context) {
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
        onCreate(db);
    }

    public static abstract class DataEntryEmployee implements BaseColumns {
        public static final String TABLE_NAME = "employee";
        public static final String COLUMN_SSN = "ssn";
        public static final String COLUMN_FIRST_NAME = "first";
        public static final String COLUMN_LAST_NAME = "last";
        public static final String COLUMN_YEAR_OF_BIRTH = "year";
        public static final String COLUMN_CITY = "city";
    }

    public static abstract class DataEntryJob implements BaseColumns {
        public static final String TABLE_NAME = "job";
        public static final String COLUMN_SSN = "ssn";
        public static final String COLUMN_COMPANY = "company";
        public static final String COLUMN_SALARY = "salary";
        public static final String COLUMN_EXPERIENCE = "experience";
    }

    private static final String SQL_CREATE_ENTRIES_EMPLOYEE = "CREATE TABLE " +
            DataEntryEmployee.TABLE_NAME + " (" +
            DataEntryEmployee._ID + " INTEGER PRIMARY KEY," +
            DataEntryEmployee.COLUMN_SSN + " TEXT," +
            DataEntryEmployee.COLUMN_FIRST_NAME + " TEXT," +
            DataEntryEmployee.COLUMN_LAST_NAME + " TEXT," +
            DataEntryEmployee.COLUMN_YEAR_OF_BIRTH + " INTEGER," +
            DataEntryEmployee.COLUMN_CITY + " TEXT" + ")";

    private static final String SQL_CREATE_ENTRIES_JOB = "CREATE TABLE " +
            DataEntryJob.TABLE_NAME + " (" +
            DataEntryJob._ID + " INTEGER PRIMARY KEY," +
            DataEntryJob.COLUMN_SSN + " TEXT," +
            DataEntryJob.COLUMN_COMPANY + " TEXT," +
            DataEntryJob.COLUMN_SALARY + " INTEGER," +
            DataEntryJob.COLUMN_EXPERIENCE + " INTEGER" + ")";

    private static final String SQL_DELETE_ENTRIES_EMPLOYEE = "DROP TABLE IF EXISTS " +
            DataEntryEmployee.TABLE_NAME;

    private static final String SQL_DELETE_ENTRIES_JOB = "DROP TABLE IF EXISTS " +
            DataEntryJob.TABLE_NAME;

    public void addEmployee(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryEmployee.COLUMN_SSN, employee.getSsn());
        values.put(DataEntryEmployee.COLUMN_FIRST_NAME, employee.getFirst());
        values.put(DataEntryEmployee.COLUMN_LAST_NAME, employee.getLast());
        values.put(DataEntryEmployee.COLUMN_YEAR_OF_BIRTH, employee.getYearOfBirth());
        values.put(DataEntryEmployee.COLUMN_CITY, employee.getCity());
        db.insert(DataEntryEmployee.TABLE_NAME, null, values);
    }

    public void addJob(Job job) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryJob.COLUMN_SSN, job.getSsn());
        values.put(DataEntryJob.COLUMN_COMPANY, job.getCompany());
        values.put(DataEntryJob.COLUMN_SALARY, job.getSalary());
        values.put(DataEntryJob.COLUMN_EXPERIENCE, job.getExperience());
        db.insert(DataEntryJob.TABLE_NAME, null, values);
    }

    // people working at same company i.e. Macy's
    public Cursor getEEAtSameCompany() {
        SQLiteDatabase db = getWritableDatabase();

        // don't judge, i got lazy so i didn't fix this
        String query = "SELECT * FROM EMPLOYEE INNER JOIN JOB ON JOB.SSN=EMPLOYEE.SSN WHERE JOB.COMPANY='Macys'";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public Cursor getCompaniesInBoston() {
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + DataEntryJob.TABLE_NAME + " INNER JOIN " + DataEntryEmployee.TABLE_NAME +
                " ON " + DataEntryJob.TABLE_NAME + "." + DataEntryJob.COLUMN_SSN + "=" + DataEntryEmployee.TABLE_NAME + "." + DataEntryEmployee.COLUMN_SSN +
                " WHERE " + DataEntryEmployee.COLUMN_CITY + "='Boston'";

        Cursor cursor = db.rawQuery(query, null);

        return cursor;

    }

    public Cursor getHighestSalary() {
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + DataEntryJob.TABLE_NAME + " ORDER BY " + DataEntryJob.COLUMN_SALARY + " DESC LIMIT 1";
        Cursor cursor = db.rawQuery(query, null);

        return cursor;

    }

    public Cursor getEmployees() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] allColumns = {DataEntryEmployee._ID, DataEntryEmployee.COLUMN_SSN, DataEntryEmployee.COLUMN_FIRST_NAME, DataEntryEmployee.COLUMN_LAST_NAME, DataEntryEmployee.COLUMN_YEAR_OF_BIRTH, DataEntryEmployee.COLUMN_CITY};
        Cursor cursor = db.query(DataEntryEmployee.TABLE_NAME, allColumns, null, null, null, null, null, null);
        return cursor;
    }
}
