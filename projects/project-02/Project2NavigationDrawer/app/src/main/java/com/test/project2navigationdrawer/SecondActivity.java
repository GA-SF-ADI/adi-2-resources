package com.test.project2navigationdrawer;

import android.database.Cursor;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    ListView listView;
    DBAdapter customAdapter;
    int[] imagePic = {R.drawable.rounddiamond
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_second);


        super.onCreate(savedInstanceState);
        myDb = new DatabaseHelper(this);

        myDb.insert("1", "bracelet", "$49.00", "yellow gold", "ruby", null, "5", "striking", null);
        myDb.insert("2", "bracelet", "$79.00", "white gold", "diamond", null, "5", "elegant", null);
        myDb.insert("3", "bracelet", "$89.00", "platinum", "diamond", null, "5", "classic", null);

        populateListViewFromDB();
    }



    private void populateListViewFromDB() {
        Cursor cursor = myDb.getJewelry();
        //allow activity to manage cursor
        //DEPRECATED

        startManagingCursor(cursor);

        //map string of column name to an id in the view
        String[] fromFieldNames = new String[]
                {myDb.COL_2_TYPE, myDb.COL_3_PRICE};
        int [] toViewIds = new int[]
                {R.id.text_view_type_of_jewelry, R.id.text_view_price_of_jewelry};
        //create adapter to map columns of DB

        customAdapter = new DBAdapter(this,cursor,0);


        //SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.item_layout, cursor, fromFieldNames, toViewIds);

        //set adapter
        listView = (ListView) findViewById(R.id.second_activity_list_view);
        listView.setAdapter(customAdapter);
    }

}

