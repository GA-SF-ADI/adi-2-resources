package ly.generalassemb.drewmahrt.cursorlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        SQLiteDatabase db;

        db = openOrCreateDatabase(
                "BooksData.db"
                , SQLiteDatabase.CREATE_IF_NECESSARY
                , null
        );
        db.setVersion(1);
        db.setLocale(Locale.getDefault());

        String[] titles = new String[]{"Harry Potter and the Sorcerers Stone","Harry Potter and the Chamber of Secrets","The Martian"};
        String[] authors = new String[]{"J. K. Rowling","J. K. Rowling","Andy Weir"};
        int[] years = new int[]{1997,1998,2011};
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_books (title VARCHAR, author VARCHAR, year VARCHAR);");
        for (int i=0; i<titles.length;i++) {
            db.execSQL("INSERT INTO tbl_books Values ('" + titles[i] + "', '"+ authors[i] + "', '" + years[i] +"');");
        }

        /**
         * Start your code here
         */
        // 1. Get your cursor

        Cursor cursor = db.query("tbl_books",null,null,null,null,null,null);

        int titleColIndex = cursor.getColumnIndex("title");
        int authorColIndex = cursor.getColumnIndex("author");
        int yearColIndex = cursor.getColumnIndex("year");


        // 2. Iterate on the cursor and create a string for each row that looks like "Title - author - year"


        ArrayList<String> books = new ArrayList<>();

        cursor.moveToFirst();
        while(cursor.isAfterLast() == false){
            String s1 = cursor.getString(titleColIndex)+"-"+cursor.getString(authorColIndex)+"-"+cursor.getString(yearColIndex);
            books.add(s1);

            cursor.moveToNext();
        }

//        cursor.moveToFirst();
//        while(cursor.moveToNext()){
//            String s1 = cursor.getString(titleColIndex)+"-"+cursor.getString(authorColIndex)+"-"+cursor.getString(yearColIndex);
//            books.add(s1);
//        }




        // 3. Insert each of the strings from step 2 into an ArrayList<String>

        // 4. Create ListView

        ListView listView = (ListView) findViewById(R.id.list_view);


        // 5. Create adapter for listview ( ArrayAdapter or CustomAdapter )

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,books);


        // 6. Link your ListView and Adapter

        listView.setAdapter(arrayAdapter);


    }
}
