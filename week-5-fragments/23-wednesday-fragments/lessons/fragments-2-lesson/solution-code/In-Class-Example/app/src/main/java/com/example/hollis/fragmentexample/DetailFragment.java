package com.example.hollis.fragmentexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hollis on 7/6/16.
 */
public class DetailFragment extends Fragment{
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        //globally set the textview
        textView = (TextView) v.findViewById(R.id.text_in_fragment);
        return v;
    }

    //create the setter for our fragment
    public void setPlanet(String planet){
        //set the textview
        textView.setText(planet);
    }
}
