package ly.generalassemb.drewmahrt.cursorlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

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
        Cursor cursor = db.query("tbl_books",null, null, null, null, null, null);


        // 2. Iterate on the cursor and create a string for each row that looks like "Title - author - year"
        cursor.moveToLast();
        ArrayList<String> booksArrayList = new ArrayList<>();
        while (cursor.isBeforeFirst() == false){
            Log.d("Current Position", cursor.getPosition() + "");
            booksArrayList.add(cursor.getString(cursor.getColumnIndex("title")) + " - " + cursor.getString(cursor.getColumnIndex("author")) + " - " + cursor.getString(cursor.getColumnIndex("year")));

            cursor.moveToPrevious();
        }
        cursor.close();

        // 3. Insert each of the strings from step 2 into an ArrayList<String>



        // 4. Create ListView
        ListView booksListView = (ListView) findViewById(R.id.booksListView);



        // 5. Create adapter for listview ( ArrayAdapter or CustomAdapter )
        ArrayAdapter myAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, booksArrayList);


        
        // 6. Link your ListView and Adapter
        booksListView.setAdapter(myAdapter);

    }
}
