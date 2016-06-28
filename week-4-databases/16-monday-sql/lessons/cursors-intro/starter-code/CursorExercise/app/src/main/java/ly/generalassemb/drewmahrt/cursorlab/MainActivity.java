package ly.generalassemb.drewmahrt.cursorlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    CustomBaseAdapter customBaseAdapter;
    ArrayList<String> myList;

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


        Cursor cursor = db.query("tbl_books", null, null, null, null, null, null);


        int titleColIndex = cursor.getColumnIndex("title");
        int authorsColIndex = cursor.getColumnIndex("authors");
        int yearsColIndex = cursor.getColumnIndex("years");

        myList = new ArrayList<String>();

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            myList.add(cursor.getString(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2));
            cursor.moveToNext();
        }

        cursor.close();


        //DID not work... kept shutting the program down

        //myList.add(cursor.getString(titleColIndex) +  " - " + cursor.getString(authorsColIndex) +  " - " + cursor.getString(yearsColIndex));


        ListView listview = (ListView) findViewById(R.id.list_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myList);


        customBaseAdapter = new CustomBaseAdapter(myList, this);


        listview.setAdapter(customBaseAdapter);

        customBaseAdapter.notifyDataSetChanged();


    }
}