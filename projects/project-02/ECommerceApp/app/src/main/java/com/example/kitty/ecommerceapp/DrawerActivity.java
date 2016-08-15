package com.example.kitty.ecommerceapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by kitty on 7/14/16.
 */
public class DrawerActivity extends Activity {

    private String[] searchTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    private CharSequence mDrawerTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchTitles = getResources().getStringArray(R.array.searchTitles);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // set adapter for the listview
        mDrawerList.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, searchTitles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        private TPListFragment tpListFragment;
//        private Helper helper;

        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }

        /**
         * Swaps fragments in the main content view
         */
        private void selectItem(int position) {
            // create list fragment to show
            tpListFragment.searchTPList("Charmin");

            // Highlight the selected item, and close the drawer
            mDrawerList.setItemChecked(position, true);
//            setTitle(searchTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }

//        @Override
//        public void setTitle(CharSequence title) {
//            mDrawerTitleTitle = title;
//            getActionBar().setTitle(mDrawerTitleTitle);
//        }

    }

}
