package com.test.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView mainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById(R.id.main_list_view);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.alc_menu, menu);

        return true;
    }

    public void addData(){
        DataBaseHelper db = new DataBaseHelper(this);
        Alcohol jameson = new Alcohol("Jameson", 23, 40, "Blended Irish whiskey",1,1);
        Alcohol greygoose = new Alcohol("Grey Goose", )


    }
}
