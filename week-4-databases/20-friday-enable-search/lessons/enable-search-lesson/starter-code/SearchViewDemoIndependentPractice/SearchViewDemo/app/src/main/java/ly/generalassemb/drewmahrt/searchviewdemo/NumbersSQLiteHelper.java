package ly.generalassemb.drewmahrt.searchviewdemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by drewmahrt on 12/30/15.
 */
public class NumbersSQLiteHelper extends SQLiteOpenHelper {
    private static final String TAG = NumbersSQLiteHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 9;
    public static final String DATABASE_NAME = "TEST_DB";
    public static final String NUMBERS_TABLE_NAME = "NUMBERS";

    public static final String COL_ID = "_id";
    public static final String COL_NUMBER_VALUE = "NUMBER_VALUE";

    public static final String[] NUMBERS_COLUMNS = {COL_ID,COL_NUMBER_VALUE};

    private static final String CREATE_NUMBERS_TABLE =
            "CREATE TABLE " + NUMBERS_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NUMBER_VALUE + " INTEGER )";


    private static NumbersSQLiteHelper instance;

    public static NumbersSQLiteHelper getInstance(Context context){
        if(instance == null){
            instance = new NumbersSQLiteHelper(context);
        }
        return instance;
    }

    private NumbersSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NUMBERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NUMBERS_TABLE_NAME);
        this.onCreate(db);
    }
}
