package com.test.bostoncompanies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance;

     private static final String CREATE_EMPLOYEE_TABLE = "CREATE TABLE " +
             DataEntryEmployee.TABLE_NAME + " (" +
             DataEntryEmployee._ID + " INTEGER PRIMARY KEY, " +
             DataEntryEmployee.SSN + " TEXT, " +
             DataEntryEmployee.FIRST_NAME + " TEXT, " +
             DataEntryEmployee.LAST_NAME + " TEXT, " +
             DataEntryEmployee.BIRTH_YEAR + " TEXT, " +
             DataEntryEmployee.CITY + " TEXT);";

    private static final String CREATE_JOB_TABLE = "CREATE TABLE " +
            DataEntryJob.TABLE_NAME + " (" +
            DataEntryJob._ID + " INTEGER PRIMARY KEY, " +
            DataEntryJob.SSN + " TEXT, " +
            DataEntryJob.COMPANY + " TEXT," +
            DataEntryJob.SALARY + " TEXT," +
            DataEntryJob.EXPERIENCE + " TEXT);";

    private static final String DROP_EMPLOYEE_TABLE = "DROP TABLE IF EXISTS " + DataEntryEmployee.TABLE_NAME;
    private static final String DROP_JOB_TABLE = "DROP TABLE IF EXISTS " + DataEntryJob.TABLE_NAME;


    public DBHelper(Context context) {
        super(context, "db", null, 1);

    }


    public  static synchronized DBHelper getInstance(Context context) {
        if (instance == null) {
            return new DBHelper(context);
        } else {
            return instance;
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

        public static final String TABLE_NAME = "Employees";
        public static final String SSN = "SS#";
        public static final String FIRST_NAME = "First Name:";
        public static final String LAST_NAME = "Last Name:";
        public static final String BIRTH_YEAR = "Year Born:";
        public static final String CITY = "Birth Place:";

    }

    public static abstract class DataEntryJob implements BaseColumns {
        public static final String TABLE_NAME = "Jobs";
        public static final String SSN = "SS#";
        public static final String COMPANY = "Company";
        public static final String SALARY = "Salary";
        public static final String EXPERIENCE = "Experience";
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

    public void insertJobRow(Job job){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataEntryJob.SSN, job.getSsn());
        values.put(DataEntryJob.COMPANY, job.getCompany());
        values.put(DataEntryJob.SALARY, job.getSalary());
        values.put(DataEntryJob.EXPERIENCE, job.getExperience());

        db.insertOrThrow(DataEntryJob.TABLE_NAME, null, values);

    }


    public Cursor getCompaniesInBoston() {
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + DataEntryJob.TABLE_NAME + " INNER JOIN " + DataEntryEmployee.TABLE_NAME +
                " ON " + DataEntryJob.TABLE_NAME + "." + DataEntryJob.SSN + "=" + DataEntryEmployee.TABLE_NAME + "." + DataEntryEmployee.SSN +
                " WHERE " + DataEntryEmployee.CITY+ "='Boston'";

        Cursor cursor = db.rawQuery(query, null);

        return cursor;

    }



    public Cursor topPayer() {
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + DataEntryJob.TABLE_NAME + " ORDER BY " + DataEntryJob.SALARY + " ";
        Cursor cursor = db.rawQuery(query, null);

        return cursor;

    }
    public Cursor getSameCompany() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] allColumns = {DataEntryEmployee._ID, DataEntryEmployee.SSN, DataEntryEmployee.FIRST_NAME, DataEntryEmployee.LAST_NAME, DataEntryEmployee.BIRTH_YEAR, DataEntryEmployee.CITY};
        Cursor cursor = db.query(DataEntryEmployee.TABLE_NAME, allColumns, null, null, null, null, null, null);
        return cursor;
    }
}








