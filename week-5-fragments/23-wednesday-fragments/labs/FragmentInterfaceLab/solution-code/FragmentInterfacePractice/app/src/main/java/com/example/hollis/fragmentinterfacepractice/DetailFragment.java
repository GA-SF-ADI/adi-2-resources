package com.example.hollis.fragmentinterfacepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by hollis on 7/5/16.
 */
public class DetailFragment extends Fragment {
    public static final String TAG = "DetailFragment";
    TextView nameTextView;
    TextView sizeTextView;
    TextView numLegsTextView;
    Animal mAnimal;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
         nameTextView = (TextView) v.findViewById(R.id.name_text);
         sizeTextView = (TextView) v.findViewById(R.id.num_legs_text);
         numLegsTextView = (TextView) v.findViewById(R.id.size_text);
        updateViews();
        return v;
    }

    public void setAnimal(Animal animal){
        mAnimal = animal;
        updateViews();
    }

    public void updateViews(){
        if(mAnimal == null){
            Log.d(TAG, "Animal is null");
        }else if(nameTextView == null){
            Log.d(TAG, "Views are null");
        }else{
            nameTextView.setText(mAnimal.getName());
            sizeTextView.setText(mAnimal.getSize());
            numLegsTextView.setText(mAnimal.getNumLegs() + "");
        }
    }

}
