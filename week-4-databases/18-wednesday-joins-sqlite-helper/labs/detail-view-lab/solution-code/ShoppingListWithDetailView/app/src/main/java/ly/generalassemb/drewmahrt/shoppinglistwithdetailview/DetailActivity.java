package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView nameTextView = (TextView)findViewById(R.id.name_text_view);
        TextView descriptionTextView = (TextView)findViewById(R.id.description_text_view);
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        TextView typeTextView = (TextView)findViewById(R.id.type_text_view);

        int selectedId = getIntent().getIntExtra("dbIndex",-1);

        if(selectedId != -1) {
            Cursor selectedItemCursor = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItem(selectedId);
            selectedItemCursor.moveToFirst();

            nameTextView.setText(selectedItemCursor.getString(selectedItemCursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_NAME)));
            descriptionTextView.setText(selectedItemCursor.getString(selectedItemCursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_DESCRIPTION)));
            priceTextView.setText(selectedItemCursor.getString(selectedItemCursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_PRICE)));
            typeTextView.setText(selectedItemCursor.getString(selectedItemCursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_TYPE)));

            selectedItemCursor.close();
        } else {
            nameTextView.setText("Error: The selected item was not found!");
        }
    }
}
