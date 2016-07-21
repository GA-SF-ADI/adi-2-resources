package drewmahrt.generalassemb.ly.userdictionaryexample;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.UserDictionary;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    SimpleCursorAdapter mSimpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.dictionary_list);

        final String [] columns = {UserDictionary.Words._ID,UserDictionary.Words.WORD};

        Cursor cursor = getContentResolver().query(UserDictionary.Words.CONTENT_URI,columns,null,null,null);

        mSimpleCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{UserDictionary.Words.WORD},new int[]{android.R.id.text1},0);
        listView.setAdapter(mSimpleCursorAdapter);

        Button button = (Button)findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri resultUri;

                //Create an object to contain the new values to insert
                ContentValues newValues = new ContentValues();

                EditText editText = (EditText)findViewById(R.id.new_word_text);

                newValues.put(UserDictionary.Words.APP_ID, "example.user");
                newValues.put(UserDictionary.Words.LOCALE, "en_US");
                newValues.put(UserDictionary.Words.WORD, editText.getText().toString());
                newValues.put(UserDictionary.Words.FREQUENCY, "100");

                resultUri = getContentResolver().insert(
                        UserDictionary.Words.CONTENT_URI,
                        newValues
                );

                editText.setText("");
                Toast.makeText(MainActivity.this,"New word added to dictionary",Toast.LENGTH_LONG).show();

                Cursor cursor = getContentResolver().query(UserDictionary.Words.CONTENT_URI,columns,null,null,null);
                mSimpleCursorAdapter.swapCursor(cursor);
            }
        });
    }
}
