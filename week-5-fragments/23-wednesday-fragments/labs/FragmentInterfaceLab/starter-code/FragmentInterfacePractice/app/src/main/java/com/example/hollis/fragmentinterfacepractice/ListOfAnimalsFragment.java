package com.example.hollis.fragmentinterfacepractice;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by michaeljeffress on 7/6/16.
 */
public class ListOfAnimalsFragment extends ListFragment {

    //data and views
    private List<Animal> animalList;

    //Globally create your interface
    AnimalInterface animalListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animalListener = (AnimalInterface) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //creating our adapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(container.getContext(), android.R.layout.simple_list_item_1, animalList);
        //set adapter
        setListAdapter(arrayAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Get string from list of items
        Animal curAnimal = animalList.get(position);
        //run interface method
        animalListener.animalListener(curAnimal);

    }
    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
