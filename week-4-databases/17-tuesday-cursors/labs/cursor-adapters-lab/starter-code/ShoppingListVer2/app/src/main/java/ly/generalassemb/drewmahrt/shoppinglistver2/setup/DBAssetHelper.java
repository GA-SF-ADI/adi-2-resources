package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by drewmahrt on 12/29/15.
 */
public class DBAssetHelper extends SQLiteAssetHelper {

    private static final String TAG = DBAssetHelper.class.getCanonicalName();

    private static final String DATABASE_NAME = "SHOPPING_DB";
    private static final int DATABASE_VERSION = 7;
    private static final String TABLE_NAME = "shopping list";
    private static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String PRICE = "price";
    private static final String TYPE = "type";

    public static final String[] ITEM_COLUMNS = {COL_ID, COL_ITEM_NAME};


    private static final String CREATE_SHOPPING_LIST_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_ITEM_NAME + " TEXT, " + PRICE + " INT );";

    private static DBAssetHelper instance;

    public static DBAssetHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DBAssetHelper(context);
        }
        return instance;
    }

    public DBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SHOPPING_LIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }


    public Cursor getShoppingList() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, // a. table
                ITEM_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;

    }


}

