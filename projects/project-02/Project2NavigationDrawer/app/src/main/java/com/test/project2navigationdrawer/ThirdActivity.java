package com.test.project2navigationdrawer;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

    int id = getIntent().getIntExtra("id", -1);
        if (id >= 0) {
           Item myItem = DatabaseHelper.getInstance(ThirdActivity.this).getItemById(id);
            TextView textView = (TextView) findViewById(R.id.third_activity_text_price);
            textView.setText("Price = $" + myItem.getType() + ".00");
            TextView textView1 = (TextView) findViewById(R.id.third_activity_text_name);
            textView1.setText(myItem.getType());

            //IMAGE DOES NOT WORK
            //ImageView imageView = (ImageView) findViewById(R.id.third_actvity_image);
            //imageView.setImageResource(myItem.getImage());
        }


        //myDB.getItemById();

        //get intent extra
        //if (id)

    }

//    int id = getIntent().getIntExtra("id",-1);
//
//    if(id >= 0){
//        String iconName = IconSQLiteOpenHelper.getInstance(DetailActivity.this).getIconNameById(id);
//        TextView textView = (TextView)findViewById(R.id.icon_description);
//        textView.setText(iconName);

//
    }

