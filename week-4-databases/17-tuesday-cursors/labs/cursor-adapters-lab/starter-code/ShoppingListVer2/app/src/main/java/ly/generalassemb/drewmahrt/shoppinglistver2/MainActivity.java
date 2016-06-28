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

import org.w3c.dom.Text;

import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DBAssetHelper;
import ly.generalassemb.drewmahrt.shoppinglistver2.setup.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    public TextView textView1, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        ListView listView = (ListView)findViewById(R.id.shopping_list_view);

        DatabaseHelper db = new DatabaseHelper(this);

        Cursor cursor = db.getGroceryList();

        CursorAdapter cursorAdapter = new CursorAdapter(this, cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.list_item,parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                textView1=(TextView)view.findViewById(R.id.list_item1);
                textView2=(TextView)view.findViewById(R.id.list_item2);
                textView3=(TextView)view.findViewById(R.id.list_item3);
                textView4=(TextView)view.findViewById(R.id.list_item4);

                textView1.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_NAME)));
                textView2.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_PRICE)));
                textView3.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_DESCRIPTION)));
                textView4.setText(cursor.getString(cursor.getColumnIndex(DatabaseHelper.COL_TYPE)));

            }
        };
        listView.setAdapter(cursorAdapter);


    }
}
