package com.test.myapplication;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity {
    TextView textView,textView1,textView2,totalView;
    ImageView mImageView;
    ListView listView;
    Button buyButton;
    int mQty,mPrice,mTotal;
    DataBaseHelper db;
    CursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        db = DataBaseHelper.getInstance(CartActivity.this);

        buyButton = (Button)findViewById(R.id.buy_button);
        listView = (ListView)findViewById(R.id.cart_list_view);
        totalView = (TextView)findViewById(R.id.cart_total);
        Cursor cursor = db.getCartAlcList();

        mCursorAdapter = new CursorAdapter(CartActivity.this,cursor,0){
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.list_cart_item,parent,false);
            }
            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                textView = (TextView)view.findViewById(R.id.cart_alc_quantity);
                textView2 = (TextView)view.findViewById(R.id.cart_alc_name);
                textView1 = (TextView)view.findViewById(R.id.cart_alc_price);
                mImageView = (ImageView)view.findViewById(R.id.cart_image);
                mImageView.setImageResource(cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_ALC_IMAGE)));
                textView2.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_ALC_NAME)));
                textView.setText("Qt: "+cursor.getString(cursor.getColumnIndex(DataBaseHelper.CART_COL_QUANTITY)));
                textView1.setText("$"+cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_ALC_PRICE)));
            }
        };
        listView.setAdapter(mCursorAdapter);

        //while loop to get sum of cart items
        while(cursor.moveToNext()) {
            mPrice = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_ALC_PRICE));
            mQty = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.CART_COL_QUANTITY));
            mTotal += mQty*mPrice;
        }
        totalView.setText("$"+mTotal);

        //"buys" items and clears cart db.
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteCart();
                finish();
                Toast.makeText(getBaseContext(), "Thank You!" , Toast.LENGTH_LONG ).show();
                mCursorAdapter.notifyDataSetChanged();

            }
        });
    }

}

