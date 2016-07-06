package com.example.hollis.fragmentinterfacepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.R.attr.name;

/**
 * Created by patrickcummins on 7/6/16.
 */

public class DetailFragment extends Fragment {
    TextView nametv, sizetv, legstv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container,false);
        nametv = (TextView) v.findViewById(R.id.name);
        sizetv = (TextView) v.findViewById(R.id.size);
        legstv = (TextView) v.findViewById(R.id.legs);


        return v;
    }

    public void setAnimalText(Animal myAnimal){
        nametv.setText("Name: " +myAnimal.getName());
        sizetv.setText("Size: " +myAnimal.getSize());
        legstv.setText("Legs: " + myAnimal.getNumLegs());
    }


}
