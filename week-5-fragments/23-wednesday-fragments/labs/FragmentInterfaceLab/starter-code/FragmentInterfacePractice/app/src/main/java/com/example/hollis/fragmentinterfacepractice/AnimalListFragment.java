package com.example.hollis.fragmentinterfacepractice;

import android.content.Context;
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
 * Created by Jon Kim on 7/6/16.
 */
public class AnimalListFragment extends ListFragment {
    private List<Animal> animalList;
    OnAnimalSelectedListener mListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListener = (OnAnimalSelectedListener) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<Animal> adapter = new ArrayAdapter<>(container.getContext(),android.R.layout.simple_list_item_1,animalList);
        setListAdapter(adapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    public void getAnimalList(List<Animal> animalList){
        this.animalList=animalList;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Animal animalSelect = animalList.get(position);
        mListener.onAnimalSelected(animalSelect);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            mListener = (OnAnimalSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement OnPlanetSelectedListener");
        }

    }
}
