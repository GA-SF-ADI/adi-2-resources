package com.example.hollis.fragmentinterfacepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jon Kim on 7/6/16.
 */
public class DetailFragment extends Fragment {
    TextView textView1, textView2, textView3;
    Animal animal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail,container,false);
        textView1 = (TextView) v.findViewById(R.id.text1);
        textView2 = (TextView) v.findViewById(R.id.text2);
        textView3 = (TextView) v.findViewById(R.id.text3);

        textView1.setText(animal.getName());
        textView2.setText(animal.getNumLegs());
        textView3.setText(animal.getSize()+"");
        return v;
    }

    public void setText(Animal animal){
        this.animal=animal;
    }

}
