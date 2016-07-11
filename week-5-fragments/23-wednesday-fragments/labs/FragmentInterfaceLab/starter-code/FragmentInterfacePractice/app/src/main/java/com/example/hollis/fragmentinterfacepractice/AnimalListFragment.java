package com.example.hollis.fragmentinterfacepractice;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.ListFragment;

import java.util.List;

/**
 * Created by sterlinggerritz on 7/7/16.
 */
public class AnimalListFragment extends ListFragment {
    List<Animal> animalList;
    //globally declare an object of type interface
    OnAnimalClickListner onAnimalClickListner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Create our adapter and set it
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,  animalList);
        setListAdapter(arrayAdapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
    //get an instance of our activity as our interface

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onAnimalClickListner = (OnAnimalClickListner) getActivity();
        }catch(ClassCastException e){
            throw new ClassCastException("need to implement OnAnimalClickListener in activity");
        }
    }

    //override our onListItemClick listener
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Animal curAnimal = animalList.get(position);
        onAnimalClickListner.onAnimalClicked(curAnimal);
    }


    //create my interface as an inner interface
    public interface OnAnimalClickListner{
        //giving it a method that takes in an animal as an argument
        void onAnimalClicked(Animal animal);
    }
}
