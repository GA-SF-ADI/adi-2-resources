package com.example.jeanweatherwax.sqliteandroidpractice;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpDB();
        ListView listView = (ListView) findViewById(R.id.list_view);
        CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this, db.getAllGames(), 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.game_layout, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView nameText = (TextView) view.findViewById(R.id.name_text_view);
                TextView yearText = (TextView) view.findViewById(R.id.year_text_view);
                nameText.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GAME_NAME)));
                yearText.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GAME_YEAR)));

            }
        };
        listView.setAdapter(cursorAdapter);

    }


    
//IGNORE THIS CODE SHH
    public void setUpDB(){
        db = new DatabaseHelper(this);
        try{
            db.getGame(1);
        }catch(CursorIndexOutOfBoundsException e ){
            db.insert(1, "Super Mario", "1985");
            db.insert(2, "Legend of Zelda", "1986");

        }

    }
}
