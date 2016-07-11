package ly.generalassemb.drewmahrt.morefragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by drewmahrt on 2/25/16.
 */
public class MyListFragment extends ListFragment {
    // TODO: 1. create a OnPlanetSelectedListener.java interface in its own file

    // TODO: 2. declare a OnPlanetSelectedListener variable
    OnPlanetSelectedListener onPlanetSelectedListener;

    // TODO: 3. Override onAttach()
    // TODO: 3a. inside onAttach() set the value of your variable you created in 2.

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onPlanetSelectedListener = (OnPlanetSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + " must implement OnPlanetSelectedListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Planets));
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO: 4. Pass the selected planet to the interface variable
        String selectedPlanetString = l.getAdapter().getItem(position).toString();
        onPlanetSelectedListener.onPlanetSelected(selectedPlanetString);
    }
}
