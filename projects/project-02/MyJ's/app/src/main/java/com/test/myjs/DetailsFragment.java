package com.test.myjs;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by nolbertoarroyo on 7/9/16.
 */
public class DetailsFragment extends Fragment {
    ListView homeListView;
    TextView homeText;
    ImageButton homeImgBttn;
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_details,container,false);
        homeListView.findViewById(R.id.home_lv);


        final ShoeOpenHelper helper = ShoeOpenHelper.getInstance(getContext());
        Cursor cursor=helper.getShoesList();
        final CursorAdapter cursorAdapter = new CursorAdapter(getContext(),cursor,0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return inflater.inflate(R.layout.item_list,parent,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

            }
        };homeListView.setAdapter(cursorAdapter);

        return v;
    }

}
