package ly.generalassemb.drewmahrt.iconlist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by drewmahrt on 12/29/15.
 */
public class IconSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = IconSQLiteOpenHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 9;
    public static final String DATABASE_NAME = "TEST_DB";
    public static final String ICON_LIST_TABLE_NAME = "ICON_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ICON_NAME = "ICON_NAME";

    public static final String[] ICON_COLUMNS = {COL_ID,COL_ICON_NAME};

    private static final String CREATE_ICON_LIST_TABLE =
            "CREATE TABLE " + ICON_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ICON_NAME + " TEXT )";


    private static IconSQLiteOpenHelper instance;

    public static IconSQLiteOpenHelper getInstance(Context context){
        if(instance == null){
            instance = new IconSQLiteOpenHelper(context);
        }
        return instance;
    }

    private IconSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ICON_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ICON_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    public Cursor getIconList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ICON_LIST_TABLE_NAME, // a. table
                ICON_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }
}
