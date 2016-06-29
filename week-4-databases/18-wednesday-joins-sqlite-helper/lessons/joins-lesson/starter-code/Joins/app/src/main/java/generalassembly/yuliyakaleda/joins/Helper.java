package generalassembly.yuliyakaleda.joins;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;


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
    db.execSQL(SQL_CREATE_ENTRIES_COMPANY);
    db.execSQL(SQL_CREATE_ENTRIES_DEPARTMENT);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL(SQL_DELETE_ENTRIES_COMPANY);
    db.execSQL(SQL_DELETE_ENTRIES_DEPARTMENT);
    onCreate(db);
  }

  public static abstract class DataEntryCompany implements BaseColumns {
    public static final String TABLE_NAME = "company";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_SALARY = "salary";
  }

  public static abstract class DataEntryDepartment implements BaseColumns {
    public static final String TABLE_NAME = "department";
    public static final String COLUMN_DEPARTMENT = "department";
    public static final String COLUMN_EMP_ID = "emp_id";
  }

  private static final String SQL_CREATE_ENTRIES_COMPANY = "CREATE TABLE " +
          DataEntryCompany.TABLE_NAME + " (" +
          DataEntryCompany._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
          DataEntryCompany.COLUMN_NAME + " TEXT," +
          DataEntryCompany.COLUMN_AGE + " INTEGER," +
          DataEntryCompany.COLUMN_ADDRESS + " TEXT," +
          DataEntryCompany.COLUMN_SALARY + " INTEGER" + ")";

  private static final String SQL_CREATE_ENTRIES_DEPARTMENT = "CREATE TABLE " +
          DataEntryDepartment.TABLE_NAME + " (" +
          DataEntryDepartment._ID + " INTEGER PRIMARY KEY," +
          DataEntryDepartment.COLUMN_DEPARTMENT + " TEXT," +
          DataEntryDepartment.COLUMN_EMP_ID + " INTEGER" + ")";

  private static final String SQL_DELETE_ENTRIES_COMPANY = "DROP TABLE IF EXISTS " +
          DataEntryCompany.TABLE_NAME;
  private static final String SQL_DELETE_ENTRIES_DEPARTMENT = "DROP TABLE IF EXISTS " +
          DataEntryDepartment.TABLE_NAME;

  public void insertRowEmployee(Employee employee) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(DataEntryCompany.COLUMN_NAME, employee.getName());
    values.put(DataEntryCompany.COLUMN_AGE, employee.getAge());
    values.put(DataEntryCompany.COLUMN_ADDRESS, employee.getAddress());
    values.put(DataEntryCompany.COLUMN_SALARY, employee.getSalary());
    db.insertOrThrow(DataEntryCompany.TABLE_NAME, null, values);
  }

  public void insertRowDepartment(Department department) {
    SQLiteDatabase db = getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put(DataEntryDepartment.COLUMN_DEPARTMENT, department.getDept());
    values.put(DataEntryDepartment.COLUMN_EMP_ID, department.getEmpId());
    db.insertOrThrow(DataEntryDepartment.TABLE_NAME, null, values);
  }

  public String getNameJoins() {
    //TODO: add the code from the lesson.

    String result = "default name";
    SQLiteDatabase db = getWritableDatabase();
// Building query using INNER JOIN keyword.
    String query = "SELECT NAME FROM COMPANY INNER JOIN DEPARTMENT ON COMPANY._ID = DEPARTMENT.EMP_ID";
    Cursor cursor = db.rawQuery(query, null);
    while(cursor.moveToNext()) {
      result = cursor.getString(cursor.getColumnIndex(DataEntryCompany.COLUMN_NAME));
    }
    cursor.close();

    //we are returning the person that matches the criteria... their company id has to match employee id
    return result;
  }


  //The method is the solution for the independent part of the lesson
  public String getFullInformation() {
    //TODO: add the code from the lesson.
    String myResult ="default info";
    SQLiteDatabase db = getWritableDatabase();

    //Building query using INNER JOIN keyword.
    String query = "SELECT NAME, AGE, SALARY, DEPARTMENT FROM COMPANY INNER JOIN DEPARTMENT ON COMPANY._ID = DEPARTMENT._ID";
    Cursor cursor = db.rawQuery(query, null);
    while(cursor.moveToNext()) {
      String name = cursor.getString(cursor.getColumnIndex(DataEntryCompany.COLUMN_NAME));
      String age = cursor.getString(cursor.getColumnIndex(DataEntryCompany.COLUMN_AGE));
      String salary = cursor.getString(cursor.getColumnIndex(DataEntryCompany.COLUMN_SALARY));
      String dept = cursor.getString(cursor.getColumnIndex(DataEntryCompany.COLUMN_ADDRESS));

      myResult = (name + "is " + age + " years old and has a salary of: " + salary + "." + name + "works in"  + dept + ".");
    }
    cursor.close();

    return myResult;
  }
}

