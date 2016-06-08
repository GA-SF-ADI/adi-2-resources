package ly.generalassemb.drewmahrt.shoppinglistver2.setup;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by drewmahrt on 12/29/15.
 */
public class DBAssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "SHOPPING_DB";
    private static final int DATABASE_VERSION = 7;

    public DBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
