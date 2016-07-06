package com.example.hollis.fragmentinterfacepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kitty on 7/6/16.
 */
public class DetailFragment extends Fragment {

    TextView name;
    TextView size;
    TextView numLegs;
    Animal selectedAnimal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        name = (TextView) v.findViewById(R.id.detail_fragment_name);
        size = (TextView) v.findViewById(R.id.detail_fragment_size);
        numLegs = (TextView) v.findViewById(R.id.detail_fragment_num_legs);
        name.setText("Name: " + selectedAnimal.getName());
        size.setText("Size: " + selectedAnimal.getSize());
        numLegs.setText("Number of legs: " + selectedAnimal.getNumLegs()+"");
        return v;
    }

    // Create your helper method that takes selected animal object and sets info as text to TextView
    public void setAnimalText(Animal selectedAnimal) {

        this.selectedAnimal = selectedAnimal;

    }

}
