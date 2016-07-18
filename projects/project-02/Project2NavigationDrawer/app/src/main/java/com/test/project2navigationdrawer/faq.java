package com.test.project2navigationdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class faq extends Fragment {

    //this fragment displays 4 different user stories

    public faq() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_faq, container, false);
        final TextView textView = (TextView) rootView.findViewById(R.id.user_story1);
        final TextView textView2 = (TextView) rootView.findViewById(R.id.user_story2);
        final TextView textView3 = (TextView) rootView.findViewById(R.id.user_story3);
        final TextView textView4 = (TextView) rootView.findViewById(R.id.user_story4);

        return rootView;
    }

}
