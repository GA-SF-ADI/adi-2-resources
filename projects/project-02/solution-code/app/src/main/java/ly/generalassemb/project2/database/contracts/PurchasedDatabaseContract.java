package ly.generalassemb.project2.database.contracts;

import android.provider.BaseColumns;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/20/16.
 */
public class PurchasedDatabaseContract implements BaseColumns {
    public static final String TABLE_NAME = "purchased_products";
    public static final String COLUMN_NAME_ORDER_ID = "order_id";
    public static final String COLUMN_NAME_PRODUCT_ID = "product_id";

    public static String getCreateTableStatement() {
        return "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY NOT NULL, " +
                COLUMN_NAME_ORDER_ID + " INTEGER NOT NULL REFERENCES orders (" + _ID + "), " +
                COLUMN_NAME_PRODUCT_ID + " INTEGER NOT NULL REFERENCES products (" + ProductsDatabaseContract._ID + "), " +
                "FOREIGN KEY (" + COLUMN_NAME_ORDER_ID + ") REFERENCES orders (" + OrdersDatabaseContract._ID + "))";
    }
}
