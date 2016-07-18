package ly.generalassemb.drewmahrt.gsonexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.google.gson.Gson;

import ly.generalassemb.drewmahrt.gsonexample.models.Book;
import ly.generalassemb.drewmahrt.gsonexample.models.BookShelf;
import ly.generalassemb.drewmahrt.gsonexample.models.Library;

public class MainActivity extends AppCompatActivity {
    private static final String JSON_DATA = "{\"bookshelves\":[{\"books\":[{\"title\":\"Ender's Game\",\"author\":\"Orson Scott Card\",\"cover\":{\"color\":\"red\",\"material\":\"leather\"}},{\"title\":\"The Martian\",\"author\":\"Andy Weir\",\"cover\":{\"color\":\"blue\",\"material\":\"plastic\"}},{\"title\":\"A Song of Ice and Fire\",\"author\":\"George RR Martin\",\"cover\":{\"color\":\"green\",\"material\":\"paper\"}}]},{\"books\":[{\"title\":\"Harry Potter and the Chamber of Secrets\",\"author\":\"JK Rowling\",\"cover\":{\"color\":\"black\",\"material\":\"leather\"}},{\"title\":\"I, Robot\",\"author\":\"Isaac Asimov\",\"cover\":{\"color\":\"white\",\"material\":\"metal\"}}]}]}";
    private Gson gson;
    private ArrayAdapter<Book> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button jsonToJava = (Button) findViewById(R.id.json_to_java);
        Button javaToJson = (Button) findViewById(R.id.java_to_json);

        gson = new Gson();
        final Library library = gson.fromJson(JSON_DATA, Library.class);


        jsonToJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printAllBooks(library);
            }
        });

        javaToJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                printJsonString(library);
            }
        });
    }

    private void printAllBooks(Library library){
        if (library == null ||
                library.getBookshelves() == null){
            return;
        }
        for (BookShelf bookShelf : library.getBookshelves()){
            for (Book book : bookShelf.getBooks()){
                Log.i("MainActivity", "Book title: " + book.getTitle());
            }
        }
    }

    private void printJsonString(Library library){
        String jsonString = gson.toJson(library);
        Log.i("MainActivity", jsonString);
    }


}
