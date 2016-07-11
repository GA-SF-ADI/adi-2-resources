package com.test.project2;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    Button featuredJewelryButton;
    Toolbar toolbar;
//    private String [] mSelectionList = {"Shopping", "Contact Us", "Feedback"};
//    private DrawerLayout mDrawerLayout;
//    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        featuredJewelryButton = (Button) findViewById(R.id.featured_jewelry_button);
//        mSelectionList.toString();
//        mDrawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.left_drawer);
//        mDrawerList.setAdapter(new ArrayAdapter<String> (this, R.layout.drawerlayout, mSelectionList));
//        mDrawerList.setOnClickListener(null);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        super.onCreate(savedInstanceState);

        featuredJewelryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.main_icon:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
