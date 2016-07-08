package com.example.hollis.fragmentexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by hollis on 7/6/16.
 */
public class ListOfPlanetsFragment extends ListFragment {
    //override on create view to use the correct adapter to display the correct
    //data and views
//    String[] planets = {"mercury", ...}

    //Globally create your interface
    OnPlanetSelectedListener onPlanetSelectedListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //creating our adapter
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Planets));
       //set adapter
        setListAdapter(arrayAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //Get string from list of items
        String selected = l.getAdapter().getItem(position).toString();
        //run interface method
        onPlanetSelectedListener.onPlanetSelected(selected);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //set your listener to your casted activity
        try {
            onPlanetSelectedListener = (OnPlanetSelectedListener) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException("must implement onPlanetSelectedListener in Main Activity");
        }
    }
}
