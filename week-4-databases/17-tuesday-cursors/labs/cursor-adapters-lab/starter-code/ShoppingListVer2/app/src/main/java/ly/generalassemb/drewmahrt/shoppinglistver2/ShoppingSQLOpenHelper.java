package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;

/**
 * Created by LangstonSmith on 6/28/16.
 */
public class ShoppingSQLOpenHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "SHOPPING_DB";
    private static final int DATABASE_VERSION = 7;
    private static final String TABLE_NAME = "SHOPPING_LIST";
    private static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    public static final String PRICE = "PRICE";
    private static final String TYPE = "TYPE";

    public static final String[] ITEM_COLUMNS = {COL_ID, COL_ITEM_NAME, PRICE};


    private static final String CREATE_SHOPPING_LIST_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_ITEM_NAME + " TEXT, " + PRICE + " INT );";

    public ShoppingSQLOpenHelper(Context context) {
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