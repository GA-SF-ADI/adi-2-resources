package ly.generalassemb.drewmahrt.cursordemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db; //db is the SQLiteDatabase db

        db = openOrCreateDatabase(
                "TestingData.db" //name of data base...
                , SQLiteDatabase.CREATE_IF_NECESSARY
                , null
        );
        db.setVersion(1);
        db.setLocale(Locale.getDefault());

        String[] countryNames = new String[]{"Canada","USA","Mexico"};
        int[] populations = new int[]{35,318,125};
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_countries (country_name VARCHAR, population VARCHAR);");
        //making it work or executing it... creating a table if one doesn't already exist
        // create a table called tbl_countries if one doesn't exist already
        //VARCHAR= variable character ... look at cheat sheet for data types...
        // could be NULL, INTEGER, REAL, TEXT, BLOB, etc.


        for (int i=0; i<countryNames.length;i++) {
            db.execSQL("INSERT INTO tbl_countries Values ('" + countryNames[i] + "', '"+ populations[i] + "');");

            //the structure of the language "INSERT INTO".. inserting into tbl_countries (table name)
        }

        Cursor cursor = db.query("tbl_countries",null, null, null, null, null, null);

        int nameColIndex= cursor.getColumnIndex("country_name");
        int populationColIndex = cursor.getColumnIndex("population");
        //cursor.getColumnNames();

    cursor.moveToFirst(); //NEED THIS OR YOU WILL GET an out of bounds error
    while (cursor.isAfterLast() == false) {
        Log.d(TAG, "In the " + cursor.getString(nameColIndex) + "there are" + cursor.getString(populationColIndex));
        cursor.moveToNext();

        //or you can you can do:
        //while(cursor.moveToNext()) {
        // Log.d(TAG, "DB result" + cursor.getString (nameColIndex));
        //}
    }
        cursor.close(); //must have!
    }
}
