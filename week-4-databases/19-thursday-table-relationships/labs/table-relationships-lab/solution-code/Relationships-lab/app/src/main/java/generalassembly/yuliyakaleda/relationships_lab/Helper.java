package generalassembly.yuliyakaleda.relationships_lab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class Helper extends SQLiteOpenHelper {

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
    db.execSQL(SQL_CREATE_ENTRIES_EMPLOYEES);
    db.execSQL(SQL_CREATE_ENTRIES_JOB);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(SQL_DELETE_ENTRIES_EMPLOYEES);
    db.execSQL(SQL_DELETE_ENTRIES_JOB);
    onCreate(db);
  }

  public static abstract class DataEntryEmployee implements BaseColumns {
    public static final String TABLE_NAME = "employee";
    public static final String COLUMN_SSN = "ssn";
    public static final String COLUMN_FIRST_NAME = "firstName";
    public static final String COLUMN_LAST_NAME = "lastName";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_CITY = "city";
  }

  public static abstract class DataEntryJob implements BaseColumns {
    public static final String TABLE_NAME = "job";
    public static final String COLUMN_SSN = "ssn";
    public static final String COLUMN_COMPANY = "company";
    public static final String COLUMN_SALARY = "salary";
    public static final String COLUMN_EXPERIENCE = "experience";
  }

  private static final String SQL_CREATE_ENTRIES_EMPLOYEES = "CREATE TABLE " +
      DataEntryEmployee.TABLE_NAME + " (" +
      DataEntryEmployee._ID + " INTEGER PRIMARY KEY," +
      DataEntryEmployee.COLUMN_SSN + " TEXT," +
      DataEntryEmployee.COLUMN_FIRST_NAME + " TEXT," +
      DataEntryEmployee.COLUMN_LAST_NAME + " TEXT," +
      DataEntryEmployee.COLUMN_YEAR + " INTEGER," +
      DataEntryEmployee.COLUMN_CITY + " TEXT" + ")";

  private static final String SQL_DELETE_ENTRIES_EMPLOYEES = "DROP TABLE IF EXISTS " +
      DataEntryEmployee.TABLE_NAME;

  private static final String SQL_CREATE_ENTRIES_JOB = "CREATE TABLE " +
      DataEntryJob.TABLE_NAME + " (" +
      DataEntryJob._ID + " INTEGER PRIMARY KEY," +
      DataEntryJob.COLUMN_SSN + " TEXT," +
      DataEntryJob.COLUMN_COMPANY + " TEXT," +
      DataEntryJob.COLUMN_SALARY + " INTEGER," +
      DataEntryJob.COLUMN_EXPERIENCE + " INTEGER" + ")";

  private static final String SQL_DELETE_ENTRIES_JOB = "DROP TABLE IF EXISTS " +
      DataEntryJob.TABLE_NAME;

  public void insertRow(Employee employee) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(DataEntryEmployee.COLUMN_SSN, employee.getSsn());
    values.put(DataEntryEmployee.COLUMN_FIRST_NAME, employee.getFirstName());
    values.put(DataEntryEmployee.COLUMN_LAST_NAME, employee.getLastName());
    values.put(DataEntryEmployee.COLUMN_YEAR, employee.getYear());
    values.put(DataEntryEmployee.COLUMN_CITY, employee.getCity());

    db.insertOrThrow(DataEntryEmployee.TABLE_NAME, null, values);
  }

  public void insertRowJob(Job job) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(DataEntryJob.COLUMN_SSN, job.getSsn());
    values.put(DataEntryJob.COLUMN_COMPANY, job.getCompany());
    values.put(DataEntryJob.COLUMN_SALARY, job.getSalary());
    values.put(DataEntryJob.COLUMN_EXPERIENCE, job.getExperience());

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
          .COLUMN_FIRST_NAME));
      String lastName = cursor.getString(cursor.getColumnIndex(DataEntryEmployee
          .COLUMN_LAST_NAME));
      String name = firstName + " " + lastName;
      employees.add(name);
    }
    cursor.close();
    return employees;
  }

  public List<String> getCompaniesLocatedInBoston () {
    List<String> companies = new ArrayList<String>();
    SQLiteDatabase db = getWritableDatabase();
    // Building query using INNER JOIN keyword
    String query = "SELECT COMPANY FROM JOB INNER JOIN EMPLOYEE ON EMPLOYEE.SSN = " +
        "JOB.SSN WHERE EMPLOYEE.CITY='Boston'";
    Cursor cursor = db.rawQuery(query, null);
    while(cursor.moveToNext()) {
      String company = cursor.getString(cursor.getColumnIndex(DataEntryJob
          .COLUMN_COMPANY));
      companies.add(company);
    }
    cursor.close();
    //If there are no companies in Boston, the list will be empty.
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
      int currentSalary = cursor.getInt(cursor.getColumnIndex(DataEntryJob.COLUMN_SALARY));
      if (highestSalary < currentSalary) {
        highestSalary = currentSalary;
        company = cursor.getString(cursor.getColumnIndex(DataEntryJob.COLUMN_COMPANY));
      }
    }
    cursor.close();
    return company;
  }
}


