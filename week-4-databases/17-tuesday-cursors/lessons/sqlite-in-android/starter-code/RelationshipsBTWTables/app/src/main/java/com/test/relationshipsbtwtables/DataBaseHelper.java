package com.test.relationshipsbtwtables;

import android.content.ContentValues;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;

/**
 * Created by audreyeso on 6/30/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {


    Cursor cursor;


    private static DataBaseHelper INSTANCE;



    public static synchronized DataBaseHelper getInstance(Context context) {
        if (INSTANCE == null)
            INSTANCE = new DataBaseHelper(context);
        return INSTANCE;
    }

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATA_BASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_EMPLOYEE_LIST_TABLE);
        db.execSQL(CREATE_JOB_LIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES_COMPANY);
        db.execSQL(SQL_DELETE_ENTRIES_JOB);
        onCreate(db);

    }

    private static final String TAG = DataBaseHelper.class.getCanonicalName();
    private static final int DATA_BASE_VERSION = 1;
    public static final String DATABASE_NAME = "RELATIONSHIP_TABLES";
    public static final String EMPLOYEE_TABLE_NAME = "EMPLOYEE_TABLE";

    public static final String COL_ID = "_id";
    public static final String COL_SSN = "SSN";
    public static final String COL_FIRST_NAME = "First_Name";
    public static final String COL_LAST_NAME = "Last_Name";
    public static final String COL_YEAR = "Birthday_Year";
    public static final String COL_CITY = "City";

    public static final String[] COL_EMPLOYEE_COLUMNS = {COL_ID, COL_SSN, COL_FIRST_NAME, COL_LAST_NAME, COL_YEAR, COL_CITY};

    private static final String CREATE_EMPLOYEE_LIST_TABLE =
            "CREATE TABLE " + EMPLOYEE_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_SSN + " TEXT, " +
                    COL_FIRST_NAME + " TEXT, " +
                    COL_LAST_NAME + " TEXT, " +
                    COL_YEAR + " TEXT, " +
                    COL_CITY + " TEXT ) ";

    public static final String JOB_TABLE_NAME = "JOB_TABLE";
    public static final String COL_COMPANY_NAME = "Company_Name";
    public static final String COL_SALARY = "Salary";
    public static final String COL_EXPERIENCE_YEARS = "Experience";

    public static final String[] COL_JOB_COLUMNS = {COL_ID, COL_SSN, COL_COMPANY_NAME, COL_SALARY, COL_EXPERIENCE_YEARS};

    private static final String CREATE_JOB_LIST_TABLE =
            "CREATE TABLE " + JOB_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_SSN + " TEXT, " +
                    COL_COMPANY_NAME + " TEXT, " +
                    COL_SALARY + " TEXT, " +
                    COL_EXPERIENCE_YEARS + " TEXT ) ";


    private static final String SQL_DELETE_ENTRIES_COMPANY = "DROP TABLE IF EXISTS " +
            EMPLOYEE_TABLE_NAME;
    private static final String SQL_DELETE_ENTRIES_JOB = "DROP TABLE IF EXISTS " +
            JOB_TABLE_NAME;


    public void insertEmployee(Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, employee.getSSN());
        values.put(COL_FIRST_NAME, employee.getFirst_name());
        values.put(COL_LAST_NAME, employee.getLast_name());
        values.put(COL_YEAR, employee.getBirth_Year());
        values.put(COL_CITY, employee.getCity());
        db.insert(EMPLOYEE_TABLE_NAME, null, values);
    }

    public Cursor getEmployee() {
        SQLiteDatabase db = getReadableDatabase();
        cursor = db.query(EMPLOYEE_TABLE_NAME,COL_EMPLOYEE_COLUMNS, null, null, null, null, null);
        return cursor;
    }


    public void insertJob(Job job) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, job.getSSN());
        values.put(COL_COMPANY_NAME, job.getCompanyName());
        values.put(COL_SALARY, job.getCompanyName());
        values.put(COL_EXPERIENCE_YEARS, job.getExperience());
        //db.insertOrThrow(JOB_TABLE_NAME,null,values);

    }
}
