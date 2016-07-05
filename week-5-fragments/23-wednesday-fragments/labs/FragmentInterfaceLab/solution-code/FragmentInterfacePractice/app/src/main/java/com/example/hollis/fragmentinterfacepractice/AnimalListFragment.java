package com.example.hollis.fragmentinterfacepractice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by hollis on 7/5/16.
 */
public class AnimalListFragment extends ListFragment {
    private List<Animal> animalList;
    AnimalClickInterface animalClickInterface;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animalClickInterface = (AnimalClickInterface) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<Animal> arrayAdapter = new ArrayAdapter<Animal>(container.getContext(), android.R.layout.simple_list_item_1, animalList);
        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Animal curAnimal = animalList.get(position);
        animalClickInterface.onAnimalClicked(curAnimal);
    }

    public void setAnimalList(List<Animal> animalList){
        this.animalList = animalList;
    }
}
