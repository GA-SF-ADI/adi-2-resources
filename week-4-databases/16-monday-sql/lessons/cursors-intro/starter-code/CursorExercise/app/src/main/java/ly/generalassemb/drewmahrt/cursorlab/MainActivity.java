package ly.generalassemb.drewmahrt.cursorlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db;

        db = openOrCreateDatabase(
                "BooksData.db"
                , SQLiteDatabase.CREATE_IF_NECESSARY
                , null
        );
        db.setVersion(1);
        db.setLocale(Locale.getDefault());

        String[] titles = new String[]{"Harry Potter and the Sorcerers Stone", "Harry Potter and the Chamber of Secrets", "The Martian"};

        String[] authors = new String[]{"J. K. Rowling", "J. K. Rowling", "Andy Weir"};

        int[] years = new int[]{1997, 1998, 2011};

        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_books (title VARCHAR, author VARCHAR, year VARCHAR);");

        for (int i = 0; i < titles.length; i++) {
            db.execSQL("INSERT INTO tbl_books Values ('" + titles[i] + "', '" + authors[i] + "', '" + years[i] + "');");
        }

        /**
         * Start your code here
         */
        // 1. Get your cursor

        Cursor myCursor = db.query("tbl_books", null, null, null, null, null, null);

        Log.e(TAG, "myCusor query made");

        // 2. Iterate on the cursor and create a string for each row that looks like "Title - author - year"

        ArrayList<String> stringOfEachBookInfo = new ArrayList<>();
        Log.e(TAG, "stringOfEachBookInfo arrayList made");

        myCursor.moveToFirst();
        while (myCursor.isAfterLast() == false) {

//            "Title - Author - Year"


            stringOfEachBookInfo.add(myCursor.getString(0) + " - " + myCursor.getString(1) + " - " + myCursor.getString(2));
            myCursor.moveToNext();
        }


        myCursor.close();
        Log.e(TAG, "myCursor closed");

        // 3. Insert each of the strings from step 2 into an ArrayList<String>


        // 4. Create ListView

        ListView finalList = (ListView) findViewById(R.id.listView_book_list);
        Log.e(TAG, "listview linked to XML listview");

        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, stringOfEachBookInfo);

        Log.e(TAG, "adapter made");

        // 6. Link your ListView and Adapter

        finalList.setAdapter(mArrayAdapter);

        Log.e(TAG, "adapter set");

        mArrayAdapter.notifyDataSetChanged();
        Log.e(TAG, "data changed set notified");

    }
}
