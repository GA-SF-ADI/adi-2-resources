package com.test.contentproviderslab;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    public static final Uri CONTENT_URI = MyContentProvider.CONTENT_URI;
    ListView mStockListView;
    CursorAdapter mCursorAdapter;
    String baseUrl ="http://dev.markitondemand.com/MODApis/Api/v2/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(PracticeAPIService.class);

        mStockListView = (ListView) findViewById(R.id.portfolio_list);
        Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);
        mCursorAdapter = new CursorAdapter(this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                //set textviews here

                textView1 = (TextView) view.findViewById(R.id.text1);
                String name = cursor.getString(cursor.getColumnIndex("stockname"));
                textView1.setText(name);

                textView2 = (TextView) view.findViewById(R.id.text2);
                String symbol = cursor.getColumnName(cursor.getColumnIndex("symbol"));
                textView2.setText(symbol);

                textView3 =(TextView) view.findViewById(R.id.text3);
                String quantity = cursor.getColumnName(cursor.getColumnIndex("quantity"));
                textView3.setText(quantity);
            }

        };

        //set listview to adapter
        mStockListView.setAdapter(mCursorAdapter);
    }
}
