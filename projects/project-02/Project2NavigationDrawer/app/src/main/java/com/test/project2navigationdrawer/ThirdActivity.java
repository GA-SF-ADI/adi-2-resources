package com.test.project2navigationdrawer;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //myDB.getItemById();

        //get intent extra
        //if (id)

    }

//    public Cursor showItemById(String query) {
//        Cursor cursor = myDB.query(TABLE_NAME,
//                JEWELRY_COLUMNS,
//                "_id LIKE" + "'%" + query + "%' OR " + COL_2_TYPE +
//                        " LIKE" + "'%" + query + "%' OR " + COL_4_GOLD +
//                        " LIKE" + "'%" + query + "%' OR " + COL_5_STONE +
//                        " LIKE" + "'%" + query + "%' OR " + COL_8_NAME +
//                        " LIKE" + "'%" + query + "%'",
//                null,
//                null,
//                null,
//                null,
//                null);
//        return cursor;
    }

