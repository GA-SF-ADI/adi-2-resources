package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by audreyeso on 6/28/16.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    //Define database name and version

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Groceries.db";

    public static final String COL_ID = "_id";
    public static final String ITEM_NAME ="name";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String TYPE = "type";
    public static final String TABLE_NAME ="groceries";

    public static final String [] allColumns = {COL_ID, ITEM_NAME, DESCRIPTION, PRICE, TYPE};

    //Create a table called groceries with columns:
    //id, name, description, price, and type

    public static final String SQL_CREATE_GROCERIES_TABLE =
            "CREATE TABLE " + TABLE_NAME +
                    " ( " +
                    COL_ID + " TEXT" +
                    ITEM_NAME + " TEXT" +
                    DESCRIPTION + " TEXT" +
                    PRICE + " TEXT" +
                    TYPE + " TEXT)";

    public static final String SQL_DROP_GROCERIES_TABLE = "DROP TABLE IF EXITS groceries";


    // override the SQLiteDatabase's constructor, onCreate, and onUpgrade
    public DataBaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
@Override
    public void onCreate(SQLiteDatabase db) {
        //execute query ... created table
        db.execSQL(SQL_CREATE_GROCERIES_TABLE);
    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //destroy table
        db.execSQL(SQL_DROP_GROCERIES_TABLE);
        this.onCreate(db);
    }

    //parameters
    public long insert(int id, String name, String description, String price, String type) {

        //create new content to STORE values
        ContentValues values = new ContentValues();
        values.put(COL_ID, id);
        values.put(ITEM_NAME, name);
        values.put(DESCRIPTION, description);
        values.put(PRICE, price);
        values.put(TYPE, type);


        //get reference to the db(WRITABLE)
        SQLiteDatabase db = getWritableDatabase();
        //insert row into the groceries table
        long myList = db.insert(TABLE_NAME,null, values);
        db.close();
        return myList;
    }

    //Display the table (readable)

    public Groceries getName(int id) {
        //reference to te db (READABLE)
        SQLiteDatabase db = getReadableDatabase();

        //Define projection
        String [] projection = new String[] {COL_ID, ITEM_NAME, DESCRIPTION, PRICE, TYPE};
        String selection= "_id = ?";

        // Define a selection. This defines the WHERE clause.
        String[] selectionArgs = new String[]{String.valueOf(id)};


        //make the query with a cursor object
        Cursor cursor = db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null, null);

        cursor.moveToFirst();
//we have a cursor and want to get some things from it...
        String name = cursor.getString(cursor.getColumnIndex(ITEM_NAME));
        String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
        String price = cursor.getString(cursor.getColumnIndex(PRICE));
        String type = cursor.getString(cursor.getColumnIndex(TYPE));

        //return with parameters that you want to return

        return new Groceries(id, name, description, price, type);
    }

    public Cursor getAllGroceries() {
        SQLiteDatabase db = getReadableDatabase();

        //get the data

        Cursor cursor = db.query(TABLE_NAME,null, null, null, null, null, null);
        return cursor;
    }
}
