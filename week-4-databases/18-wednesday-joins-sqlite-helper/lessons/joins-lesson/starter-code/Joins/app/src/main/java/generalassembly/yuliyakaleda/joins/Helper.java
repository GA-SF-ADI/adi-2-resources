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
      DataEntryCompany._ID + " INTEGER PRIMARY KEY," +
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

  public void insertRow(Employee employee) {
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
  }

  //The method is the solution for the independent part of the lesson
  public String getFullInformation() {
    //TODO: add the code from the lesson.
  }
}

