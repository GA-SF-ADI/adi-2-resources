package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by NehaRege on 6/28/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {


    public static final int DATA_BASE_VERSION = 7;
    public static final String DATA_BASE_NAME = "SHOPPING_DB";
    public static final String GROCERY_TABLE_NAME = "SHOPPING_LIST";
    public static final String COL_NAME = "ITEM_NAME";
    public static final String COL_DESCRIPTION = "DESCRIPTION";
    public static final String COL_PRICE = "PRICE";
    public static final String COL_TYPE = "TYPE";
    public static final String COL_ID = "_id";

//  name, description, price, type

    public static final String SQL_CREATE_GROCERY_TABLE =
            "CREATE TABLE " + GROCERY_TABLE_NAME + " ( "
                    + COL_ID + " INT PRIMARY KEY, "
                    + COL_NAME + " TEXT, "
                    + COL_DESCRIPTION + " TEXT, "
                    + COL_PRICE + " TEXT, "
                    + COL_TYPE + " TEXT)";

    public static final String SQL_DROP_TABLE =
            "DROP TABLE IF EXISTS"+ GROCERY_TABLE_NAME;

    public DataBaseHelper(Context context){
        super(context,DATA_BASE_NAME,null,DATA_BASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_GROCERY_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DROP_TABLE);
        onCreate(db);
    }

    public void insert(int id, String name, String description, String price, String type){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_ID,id);
        values.put(COL_NAME,name);
        values.put(COL_DESCRIPTION,description);
        values.put(COL_PRICE,price);
        values.put(COL_TYPE,type);

        db.insert(GROCERY_TABLE_NAME,null,values);
    }

    public Grocery getGrocery(int id){

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = new String[] {COL_ID,COL_NAME,COL_DESCRIPTION,COL_PRICE,COL_TYPE};

        String selection = "_id = ?";

        String[] selectionArgs = new String[] {String.valueOf(id)};

        Cursor cursor = db.query(GROCERY_TABLE_NAME,projection,selection,selectionArgs,null,null,null,null);

        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndex(COL_NAME));
        String description = cursor.getString(cursor.getColumnIndex(COL_DESCRIPTION));
        String price = cursor.getString(cursor.getColumnIndex(COL_PRICE));
        String type = cursor.getString(cursor.getColumnIndex(COL_TYPE));

        return new Grocery(id,name,description,price,type);
    }

    public Cursor getAllGrocery(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(GROCERY_TABLE_NAME,null,null,null,null,null,null);
    }


}
