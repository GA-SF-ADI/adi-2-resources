package com.example.hollis.fragmentinterfacepractice;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by nolbertoarroyo on 7/6/16.
 */
public class AnimalListFragment extends android.support.v4.app.ListFragment{
    List<Animal> animalList;
    OnAnimalSelectedListener onAnimalSelectedListener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onAnimalSelectedListener = (OnAnimalSelectedListener)getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayAdapter<Animal> adapter = new ArrayAdapter<Animal>(container.getContext(),android.R.layout.simple_list_item_1,animalList);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        onAnimalSelectedListener.onAnimalSelected(animalList.get(position));
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
