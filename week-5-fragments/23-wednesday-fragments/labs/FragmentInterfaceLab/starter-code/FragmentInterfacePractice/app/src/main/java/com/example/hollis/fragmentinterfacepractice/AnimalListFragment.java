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

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by patrickcummins on 7/6/16.
 */

public class AnimalListFragment extends ListFragment {

    AnimalSelectedInterface animalSelectedInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setList(List<Animal> animalList) {
        ArrayAdapter<Animal> adapter = new ArrayAdapter<Animal>(getContext(), android.R.layout.simple_list_item_1, animalList);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Animal myAnimal = (Animal) l.getAdapter().getItem(position);
        animalSelectedInterface.animalSelected(myAnimal);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        animalSelectedInterface = (AnimalSelectedInterface) getActivity();
    }
}
