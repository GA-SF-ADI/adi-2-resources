package com.test.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;

/**
 * Created by NehaRege on 6/30/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String TAG = DatabaseHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 9;
    public static final String DATABASE_NAME = "EMPLOYEE_JOB_DB";

    public static final String EMPLOYEE_TABLE_NAME = "Employee";
    public static final String JOB_TABLE_NAME = "Job";

    public static final String COL_ID = "_id";

    public static final String COL_SSN_EMPLOYEE = "ssn";
    public static final String COL_FIRST_EMPLOYEE = "First";
    public static final String COL_BIRTH_YEAR_EMPLOYEE = "Birth_Year";
    public static final String COL_LAST_EMPLOYEE = "Last";
    public static final String COL_CITY_EMPLOYEE = "City";

    public static final String COL_SSN_JOB = "ssn";
    public static final String COL_COMPANY_JOB = "Company";
    public static final String COL_SALARY_JOB = "Salary";
    public static final String COL_EXPERIENCE_JOB = "Experience";

    public static final String CREATE_EMPLOYEE_TABLE =
            "CREATE TABLE " +EMPLOYEE_TABLE_NAME+ " ("
                    +COL_ID+ "INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +COL_SSN_EMPLOYEE+ " TEXT UNIQUE, "
                    +COL_FIRST_EMPLOYEE+ " TEXT, "
                    +COL_LAST_EMPLOYEE+ " TEXT, "
                    +COL_BIRTH_YEAR_EMPLOYEE+ "TEXT, "
                    +COL_CITY_EMPLOYEE+ " TEXT)";

    public static final String CREATE_JOB_TABLE =
            "CREATE TABLE " +JOB_TABLE_NAME+ " ("
                    +COL_ID+ " INTEGER PRIMARY KEY, "
                    +COL_SSN_JOB+ " TEXT UNIQUE, "
                    +COL_COMPANY_JOB+ " TEXT, "
                    +COL_SALARY_JOB+ " TEXT, "
                    +COL_EXPERIENCE_JOB+ " TEXT)";

    private static DatabaseHelper instance;

    public static DatabaseHelper getInstance(Context context){
        if(instance == null){
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    private DatabaseHelper (Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EMPLOYEE_TABLE);
        db.execSQL(CREATE_JOB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+EMPLOYEE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+JOB_TABLE_NAME);
        onCreate(db);
    }

    public void insertRowEmployee(Employee employee){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_SSN_EMPLOYEE,employee.getSsn());
        values.put(COL_FIRST_EMPLOYEE,employee.getFirstName());
        values.put(COL_LAST_EMPLOYEE,employee.getLastName());
        values.put(COL_BIRTH_YEAR_EMPLOYEE,employee.getBirthYear());
        values.put(COL_CITY_EMPLOYEE,employee.getCity());

        db.insertOrThrow(EMPLOYEE_TABLE_NAME,null,values);

    }

    public void insertRowJob(Job job){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_SSN_JOB,job.getSsn());
        values.put(COL_COMPANY_JOB,job.getCompany());
        values.put(COL_EXPERIENCE_JOB,job.getExperience());

        db.insertOrThrow(JOB_TABLE_NAME,null,values);

    }

    public Cursor getAllEmployees(){
        SQLiteDatabase db = getReadableDatabase();

        return db.query(EMPLOYEE_TABLE_NAME,null,null,null,null,null,null);

    }


    public ArrayList<String> employeesAtSameCompany(){

        ArrayList<String> employeesAtSameCompanyList = new ArrayList<>();
        String resultString = "";
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT "
                +COL_FIRST_EMPLOYEE+ ", "
                +COL_LAST_EMPLOYEE+ " FROM "
                +EMPLOYEE_TABLE_NAME+ " INNER JOIN "
                +JOB_TABLE_NAME+ " ON "
                +EMPLOYEE_TABLE_NAME+ "." +COL_SSN_EMPLOYEE+ " = " +JOB_TABLE_NAME+ "." +COL_SSN_JOB
                +" WHERE "+COL_COMPANY_JOB+" = 'Macy's'";


//        "SELECT first, last FROM Employee INNER JOIN Job ON Employee._id = Job._id";

        Cursor cursor = db.rawQuery(query,null);

//        return cursor;

        while (cursor.moveToNext()){

            resultString = cursor.getString(cursor.getColumnIndex(COL_FIRST_EMPLOYEE)) + " "
                     + cursor.getString(cursor.getColumnIndex(COL_LAST_EMPLOYEE));

            employeesAtSameCompanyList.add(resultString);

        }
        cursor.close();
        return employeesAtSameCompanyList;


    }

    public ArrayList<String> companiesBoston(){

        ArrayList<String> bostonCompaniesList = new ArrayList<>();
        String resultStr = "";

        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT "
                +COL_COMPANY_JOB+ " FROM "
                +JOB_TABLE_NAME+ " INNER JOIN "
                +EMPLOYEE_TABLE_NAME+ " ON "
                +EMPLOYEE_TABLE_NAME+ "." +COL_SSN_EMPLOYEE+ " = " +JOB_TABLE_NAME+ "." +COL_SSN_JOB
                +" WHERE " +COL_CITY_EMPLOYEE+ " = 'Boston'";

        Cursor cursor = db.rawQuery(query,null);

//        return cursor;

        while(cursor.moveToNext()){
            resultStr = cursor.getString(cursor.getColumnIndex(COL_COMPANY_JOB));

            bostonCompaniesList.add(resultStr);

        }
        cursor.close();
        return bostonCompaniesList;

    }

//    public String highestSalaryCompany(){
//
//        String result = "";
//
//        SQLiteDatabase db = getWritableDatabase();
//
//        String query = "SELECT"
//    }




}
