package com.example.jeanweatherwax.sqliteandroidpractice;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);

        db.insert(1, "Super Mario", "1985");
        db.insert(2, "Fallout 4", "2015");
        db.insert(3, "Doom", "2016");

        ListView listView = (ListView) findViewById(R.id.list_view);
        Cursor cursor = db.getAllGames();
        //String[] columnNames = new String[]{DatabaseHelper.COL_GAME_NAME , DatabaseHelper.COL_GAME_YEAR};
        //int[] viewNames = new int[]{R.id.gameName, R.id.gameYear};

        //CursorAdapter myCursorAdapter = new SimpleCursorAdapter(this, R.layout.custom_cursor_layout, cursor, columnNames, viewNames, 0);
        CursorAdapter myCursorAdapter = new CursorAdapter(MainActivity.this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.custom_cursor_layout, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView nameTextView = (TextView) view.findViewById(R.id.gameName);
                TextView yearTextView = (TextView) view.findViewById(R.id.gameYear);

                nameTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GAME_NAME)));
                yearTextView.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_GAME_YEAR)));

            }
        };
        listView.setAdapter(myCursorAdapter);


    }
}
