package ly.generalassemb.project2.database.contracts;

import android.provider.BaseColumns;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/20/16.
 */
public class OrdersDatabaseContract implements BaseColumns {
    public static final String TABLE_NAME = "orders";
    public static final String COLUMN_NAME_DATE = "date";
    public static final String COLUMN_NAME_TOTAL_PRICE = "total_price";
    public static final String COLUMN_NAME_ESTIMATED_DELIVERY = "estimated_delivery";

    public static String getCreateTableStatement() {
        return "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_DATE + " TEXT NOT NULL, " +
                COLUMN_NAME_TOTAL_PRICE + " REAL NOT NULL, " +
                COLUMN_NAME_ESTIMATED_DELIVERY + " TEXT NOT NULL)";
    }
}
