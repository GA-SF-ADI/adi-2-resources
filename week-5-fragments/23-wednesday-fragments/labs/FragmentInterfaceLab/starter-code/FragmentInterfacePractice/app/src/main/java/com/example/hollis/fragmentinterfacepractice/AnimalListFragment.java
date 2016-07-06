package com.example.hollis.fragmentinterfacepractice;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by kitty on 7/6/16.
 */
public class AnimalListFragment extends ListFragment {

    OnAnimalSelectedListener onAnimalSelectedListener;
    List<Animal> animalList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<Animal> adapter = new ArrayAdapter<Animal>(getContext(), android.R.layout.simple_list_item_1, animalList);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onAnimalSelectedListener = (OnAnimalSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement OnAnimalSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Animal selectedAnimal = (Animal) l.getAdapter().getItem(position);
        onAnimalSelectedListener.onAnimalSelected(selectedAnimal);
    }

    public void setAnimalList(List<Animal> list) {
        animalList = list;
    }
}
