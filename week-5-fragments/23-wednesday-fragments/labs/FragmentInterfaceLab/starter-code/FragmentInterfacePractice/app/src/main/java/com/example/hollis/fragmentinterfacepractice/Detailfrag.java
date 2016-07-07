package com.example.hollis.fragmentinterfacepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by generalassembly on 7/6/16.
 */
public class Detailfrag extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.support_simple_spinner_dropdown_item,container,false);

        textView = (TextView) v.findViewById(R.id.upfrag);
        return v;
    }
    public void setAnimal(String animal){
        textView.setText(animal);

    }
}
