package com.test.relationshipslab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jon Kim on 6/30/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RELATIONSHIP_DB";
    public static final String EMPLOYEE_TABLE = "EMPLOYEE";
    public static final String JOB_TABLE = "JOB";
    public static final String EMPLOYEE_ID = "_id";
    public static final String EMPLOYEE_SSN = "SSN";
    public static final String EMPLOYEE_FIRSTNAME = "FIRST";
    public static final String EMPLYOEE_LASTNAME = "LAST";
    public static final String EMPLOYEE_DOB = "YEAR OF BIRTH";
    public static final String EMPLOYEE_CITY = "CITY";
    public static final String JOB_ID = "_id";
    public static final String JOB_SSN = "SSN";
    public static final String JOB_COMPANY = "COMPANY";
    public static final String JOB_SALARY = "SALARY";
    public static final String JOB_EXP = "EXPERIENCE";
    public static final String SQL_DROP_EMPLOYEE_TABLE = "DROP TABLE IF EXISTS EMPLOYEE";
    public static final String SQL_DROP_JOB_TABLE = "DROP TABLE IF EXISTS JOB";
    public static final String SQL_CREATE_EMPLOYEE = "CREATE TABLE "+EMPLOYEE_TABLE+"("
            +EMPLOYEE_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +EMPLOYEE_SSN+" INTEGER UNIQUE, "
            +EMPLOYEE_FIRSTNAME+" TEXT, "
            +EMPLYOEE_LASTNAME+" TEXT, "
            +EMPLOYEE_DOB+" INTEGER, "
            +EMPLOYEE_CITY+" TEXT)";
    public static final String SQL_CREATE_JOB = "CREATE TABLE "+JOB_TABLE+"("
            +JOB_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +JOB_SSN+" INTEGER UNIQUE, "
            +JOB_COMPANY+" TEXT, "
            +JOB_SALARY+" INTEGER, "
            +JOB_EXP+" INTEGER)";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EMPLOYEE);
        db.execSQL(SQL_CREATE_JOB);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DROP_EMPLOYEE_TABLE);
        db.execSQL(SQL_DROP_JOB_TABLE);
        onCreate(db);
    }

    public void addEmployee(Employee employee){
        ContentValues values = new ContentValues();
        values.put(EMPLOYEE_FIRSTNAME, employee.getFirstName());
        values.put(EMPLYOEE_LASTNAME, employee.getLastName());
        values.put(EMPLOYEE_CITY, employee.getCity());
        values.put(EMPLOYEE_DOB, employee.getBirthYear());
        values.put(EMPLOYEE_SSN, employee.getSsn());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(EMPLOYEE_TABLE, null, values);
        db.close();
    }

    public void addJob(Job job){
        ContentValues values = new ContentValues();
        values.put(JOB_COMPANY, job.getCompany());
        values.put(JOB_EXP, job.getExp());
        values.put(JOB_SALARY, job.getSalary());
        values.put(JOB_SSN, job.getSsn());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(JOB_TABLE, null, values);
        db.close();

    }

    public String getSameJob(){
        String result = "nada";
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT FIRST, LAST FROM EMPLOYEE INNER JOIN COMPANY ON COMPANY.SSN=JOB.SSN WHERE JOB.COMPANY=Macy's";
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()){
            String first = cursor.getString(cursor.getColumnIndex(DataBaseHelper.EMPLOYEE_FIRSTNAME));
            String last = cursor.getString(cursor.getColumnIndex(DataBaseHelper.EMPLYOEE_LASTNAME));
            result = first+last;
        }
        cursor.close();
        return result;
    }

    public String getBostonJob(){
        String result = "shnada";
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT COMPANY FROM JOB INNER JOIN EMPLOYEE ON COMPANY.SSN=JOB.SSN WHERE EMPLOYEE.CITY=Boston";
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()){
            result = cursor.getString(cursor.getColumnIndex(DataBaseHelper.JOB_COMPANY));
        }
        cursor.close();
        return result;
    }

    public String getRichJob(){
        String result = "shnadada";
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT COMPANY FROM JOB WHERE max(SALARY)";
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()){
            result = cursor.getString(cursor.getColumnIndex(DataBaseHelper.JOB_COMPANY));
        }
        return result;
    }

}
