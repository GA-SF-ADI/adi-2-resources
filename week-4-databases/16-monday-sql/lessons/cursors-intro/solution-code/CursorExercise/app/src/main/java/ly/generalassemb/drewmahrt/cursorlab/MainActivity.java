package ly.generalassemb.drewmahrt.cursorlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
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


        Cursor cursor = db.query("tbl_books",
                null, null, null, null, null, null);

        ArrayList<String> books = new ArrayList<>();

        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            books.add(cursor.getString(0)+" - "+cursor.getString(1)+" - "+cursor.getString(2));
            cursor.moveToNext();
        }

        cursor.close();

        ListView listView = (ListView)findViewById(R.id.books_list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,books);
        listView.setAdapter(arrayAdapter);
    }
}
