package ly.generalassemb.project2.database.contracts;

import android.provider.BaseColumns;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/20/16.
 */
public class ProductsDatabaseContract implements BaseColumns {
    public static final String TABLE_NAME = "products";
    public static final String COLUMN_NAME_PRODUCT_NAME = "name";
    public static final String COLUMN_NAME_DESCRIPTION = "description";
    public static final String COLUMN_NAME_PRICE = "price";
    public static final String COLUMN_NAME_PICTURE_URL = "picture_url";

    public static String getCreateTableStatement(){
        return "CREATE TABLE " + TABLE_NAME +" ("
                + _ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME_PRODUCT_NAME + " TEXT NOT NULL, "
                + COLUMN_NAME_DESCRIPTION + " TEXT NOT NULL, "
                + COLUMN_NAME_PRICE + " REAL NOT NULL, "
                + COLUMN_NAME_PICTURE_URL + " TEXT)";
    }
}
