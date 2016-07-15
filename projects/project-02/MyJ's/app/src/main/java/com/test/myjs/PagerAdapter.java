package com.test.myjs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;


/**
 * Created by nolbertoarroyo on 7/9/16.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    String query;
    SearchFragment tab2;


    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                HomeFragment tab1 = new HomeFragment();
                return tab1;
            case 1:
                tab2 = new SearchFragment();
                tab2.setResultQuery(query);
                Log.d("viewPager query","viewpager:"+query);
                return tab2;
            case 2:
                ShoppingCartFragment tab3 = new ShoppingCartFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
        tab2.setResultQuery(query);
    }
}