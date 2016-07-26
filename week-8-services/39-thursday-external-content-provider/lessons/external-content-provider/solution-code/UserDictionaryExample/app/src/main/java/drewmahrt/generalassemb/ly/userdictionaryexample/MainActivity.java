package drewmahrt.generalassemb.ly.userdictionaryexample;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    SimpleCursorAdapter mSimpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri resultUri;

                //Create an object to contain the new values to insert
                ContentValues newValues = new ContentValues();

                EditText editText = (EditText) findViewById(R.id.new_word_text);
                String word = editText.getText().toString();

                UserDictionary.Words.addWord(MainActivity.this, word, 1, "", Locale.ENGLISH);

                editText.setText("");
                Toast.makeText(MainActivity.this, "New word added to dictionary: " + word, Toast.LENGTH_LONG).show();


            }
        });
    }
}
