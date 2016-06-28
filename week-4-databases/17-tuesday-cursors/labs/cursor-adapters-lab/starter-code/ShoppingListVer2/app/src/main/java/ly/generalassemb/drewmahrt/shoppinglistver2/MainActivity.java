package ly.generalassemb.drewmahrt.shoppinglistver2;

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

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        ListView listView = (ListView) findViewById(R.id.shopping_list_view);

        DataBaseHelper db = new DataBaseHelper(this);
        Cursor cursor = db.getAllGrocery();

        CursorAdapter cursorAdapter = new CursorAdapter(MainActivity.this,cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.grocery_list_view_layout,parent,false);

            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textViewName = (TextView)view.findViewById(R.id.name_text_view);

                textViewName.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_NAME)));

            }
        };

        listView.setAdapter(cursorAdapter);


    }
}
