package com.example.hollis.fragmentinterfacepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nolbertoarroyo on 7/6/16.
 */
public class ResultFragment extends Fragment {
    TextView animalName;
    TextView animalSize;
    TextView animalLegs;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         animalName = (TextView) getView().findViewById(R.id.animal_name);
         animalSize = (TextView) getView().findViewById(R.id.animal_size);
         animalLegs = (TextView) getView().findViewById(R.id.animal_legs);

        return inflater.inflate(R.layout.fragment_animal_info,container,false);
    }
    public void setAnimal(Animal animal){

        animalName.setText(animal.getName());
        animalSize.setText(animal.getSize());
        animalLegs.setText(animal.getNumLegs());

    }
}
