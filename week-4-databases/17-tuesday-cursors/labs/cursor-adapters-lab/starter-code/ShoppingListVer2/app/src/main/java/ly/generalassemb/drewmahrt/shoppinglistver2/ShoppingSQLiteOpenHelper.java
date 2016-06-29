package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nolbertoarroyo on 6/28/16.
 */
public class ShoppingSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME = "Shopping.db";
    public static final String SHOPPING_TABLE_NAME ="shopping";
    public static final String COL_ID = "_id";
    public static final String COL_NAME= "NAME";
    public static final String COL_DESCRIPTION = "DESCRIPTION";
    public static final String COL_PRICE="PRICE";
    public static final String COL_TYPE="TYPE";
    public static final String[] SHOPPING_COLUMNS = {COL_ID,COL_NAME,COL_DESCRIPTION,COL_PRICE,COL_TYPE};

    private static final String CREATE_SHOPPING_LIST =
            "CREATE TABLE " + SHOPPING_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY, " +
                    COL_NAME + " TEXT,"+ COL_DESCRIPTION + " TEXT,"+ COL_PRICE + " TEXT,"+ COL_TYPE + " TEXT )";
    private static ShoppingSQLiteOpenHelper instance;

    public static ShoppingSQLiteOpenHelper getInstance(Context context){
        if(instance == null){
            instance = new ShoppingSQLiteOpenHelper(context);
        }
        return instance;
    }

    public ShoppingSQLiteOpenHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SHOPPING_LIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SHOPPING_TABLE_NAME);
        this.onCreate(db);

    }
    public Cursor getShoppingList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(SHOPPING_TABLE_NAME,
                SHOPPING_COLUMNS, null, null, null, null, null, null);
        return cursor;
    }

}
