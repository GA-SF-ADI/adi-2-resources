package com.differentdevices.threads;

/**
 * Created by sterlinggerritz on 7/20/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = DBHelper.class.getName();

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "TEST_DB";
    public static final String TEST_TABLE_NAME = "names";

    public static final String COL_ID = "_id";
    public static final String COL_FIRST_NAME = "first_name";
    public static final String COL_LAST_NAME = "last_name";

    public static final String[] COLUMNS = {COL_ID,COL_FIRST_NAME,COL_LAST_NAME};

    private static final String CREATE_TEST_TABLE =
            "CREATE TABLE " + TEST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_FIRST_NAME + " TEXT," +
                    COL_LAST_NAME +" TEXT )";


    private static DBHelper instance;

    public static DBHelper getInstance(Context context){
        if(instance == null){
            instance = new DBHelper(context);
        }
        return instance;
    }

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TEST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TEST_TABLE_NAME);
        this.onCreate(db);
    }

    public long addName(String first, String last){
        ContentValues values = new ContentValues();
        values.put(COL_FIRST_NAME,first);
        values.put(COL_LAST_NAME,last);

        SQLiteDatabase db = getWritableDatabase();
        return db.insert(TEST_TABLE_NAME,null,values);
    }

    public Integer getItemCount(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TEST_TABLE_NAME, // a. table
                COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor.getCount();
    }}

