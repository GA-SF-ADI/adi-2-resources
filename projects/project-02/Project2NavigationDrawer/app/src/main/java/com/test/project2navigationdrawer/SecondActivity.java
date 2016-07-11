package com.test.project2navigationdrawer;

import android.database.Cursor;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_second);

        super.onCreate(savedInstanceState);
        myDb = new DatabaseHelper(this);

        myDb.insert("1", "bracelet", "$49.00", "yellow gold", "ruby", null, "5", "striking", null);
        myDb.insert("2", "bracelet", "$79.00", "white gold", "diamond", null, "5", "elegant", null);
        myDb.insert("3", "bracelet", "$89.00", "platinum", "diamond", null, "5", "classic", null);

//        Cursor jewelryCursor = IconSQLiteOpenHelper.getInstance(SecondActivity.this).getJewelry();
//
//        CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this,iconCursor,0) {
//            @Override
//            public View newView(Context context, Cursor cursor, ViewGroup parent) {
//                return LayoutInflater.from(context).inflate(R.layout.icon_list_item,parent,false);
//            }
//
//            @Override
//            public void bindView(View view, Context context, Cursor cursor) {
//                ImageView iconImageView = (ImageView)view.findViewById(R.id.icon_image_view);
//                TextView iconTextView = (TextView)view.findViewById(R.id.icon_name_text_view);
//
//                iconImageView.setImageResource(getDrawableValue(cursor.getString(cursor.getColumnIndex(IconSQLiteOpenHelper.COL_ICON_NAME))));
//                iconTextView.setText(cursor.getString(cursor.getColumnIndex(IconSQLiteOpenHelper.COL_ICON_NAME)));
//            }
//        };
//
//        iconListView.setAdapter(cursorAdapter);
//    }

}
}
