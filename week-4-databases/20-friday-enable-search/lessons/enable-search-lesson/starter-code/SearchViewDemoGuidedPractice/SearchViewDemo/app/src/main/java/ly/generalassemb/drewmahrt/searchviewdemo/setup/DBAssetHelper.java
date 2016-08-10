package ly.generalassemb.drewmahrt.searchviewdemo.setup;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by drewmahrt on 12/30/15.
 */
public class DBAssetHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "TEST_DB";
    private static final int DATABASE_VERSION = 8;

    public DBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
