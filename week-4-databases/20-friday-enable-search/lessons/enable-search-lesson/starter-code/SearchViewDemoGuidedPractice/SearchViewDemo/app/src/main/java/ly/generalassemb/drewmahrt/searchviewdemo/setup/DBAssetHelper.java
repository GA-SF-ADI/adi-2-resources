package ly.generalassemb.drewmahrt.searchviewdemo.setup;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.widget.TextView;
import android.widget.Toast;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import ly.generalassemb.drewmahrt.searchviewdemo.MainActivity;
import ly.generalassemb.drewmahrt.searchviewdemo.NumbersSQLiteHelper;

/**
 * Created by drewmahrt on 12/30/15.
 */
public class DBAssetHelper extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "TEST_DB";
    private static final int DATABASE_VERSION = 8;
    TextView textView;

    public DBAssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    }

