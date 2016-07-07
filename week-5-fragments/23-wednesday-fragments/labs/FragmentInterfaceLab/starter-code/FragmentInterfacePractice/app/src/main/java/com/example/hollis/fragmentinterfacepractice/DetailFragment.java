package com.example.hollis.fragmentinterfacepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

/**
 * Created by sterlinggerritz on 7/7/16.
 */
public class DetailFragment extends Fragment {
    Animal animal;

    //create the correct view
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        //got the views
        TextView nameText = (TextView) v.findViewById(R.id.name);
        TextView sizeText = (TextView) v.findViewById(R.id.size);
        TextView numLegsText = (TextView) v.findViewById(R.id.num_legs);
        //set the views based on the animal property
        nameText.setText(animal.getName());
        sizeText.setText(animal.getSize());
        numLegsText.setText(animal.getNumLegs() + "");
        return v;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
