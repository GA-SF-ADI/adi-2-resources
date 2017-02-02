package com.example.hollis.fragmentinterfacepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by michaeljeffress on 7/6/16.
 */
public class DetailFragment extends ListFragment {
    public static final String TAG = "DetailFragment";
    TextView nameTextView;
    TextView sizeTextView;
    TextView legsTextView;
    Animal dAnimal;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        nameTextView = (TextView) v.findViewById(R.id.animal_text);
        sizeTextView = (TextView) v.findViewById(R.id.legs_text);
        legsTextView = (TextView) v.findViewById(R.id.size_text);
        updateViews();
        return v;
    }

    public void setAnimal(Animal animal) {
        dAnimal = animal;
        updateViews();
    }

    public void updateViews(){
        if(dAnimal == null) {
            Log.d(TAG, "Animal is null");
        }else if(nameTextView == null) {
            Log.d(TAG, "Views are null");
        }else {
            nameTextView.setText(dAnimal.getName());
            sizeTextView.setText(dAnimal.getSize());
            legsTextView.setText(dAnimal.getNumLegs() + "");
        }
    }
}
