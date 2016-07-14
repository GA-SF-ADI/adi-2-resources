package com.test.project2navigationdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about_us, container, false);
        final TextView textView = (TextView) rootView.findViewById(R.id.about_us_text);
        textView.setText("Welcome! This is a fake company. You cannot buy jewelry, but you CAN explore the app!");
//        final Button mainButton = (Button) rootView.findViewById(R.id.about_us_button);
//        mainButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                mainButton.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
//            }
//        });
//        // Inflate the layout for this fragment
        return rootView;
    }

}




