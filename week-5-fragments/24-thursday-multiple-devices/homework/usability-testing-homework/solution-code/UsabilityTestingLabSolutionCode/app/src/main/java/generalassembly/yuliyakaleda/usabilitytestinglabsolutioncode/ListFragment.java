package generalassembly.yuliyakaleda.usabilitytestinglabsolutioncode;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment {
  private static final String SIGN = "sign";
  private ListView listView;

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_layout, container, false);
    listView = (ListView) view.findViewById(R.id.list_view);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    String[] values = getResources().getStringArray(R.array.signs);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
        android.R.layout.simple_list_item_1, android.R.id.text1, values);
    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String itemValue = (String) listView.getItemAtPosition(position);

        DetailsFragment detailsFragment = (DetailsFragment) getFragmentManager()
            .findFragmentById(R.id.details_fragment);
        // It checks if the DetailsFragment is present next to the ListFragment.
        if (detailsFragment == null) {
          // If DetailsFragment is not in the layout (handset layout), DetailsActivity starts
          // and the info about the selected item gets passed.
          Intent intent = new Intent(getActivity(), DetailsActivity.class);
          intent.putExtra(SIGN, itemValue);
          startActivity(intent);
        } else {
          // DetailsFragment is in the layout (tablet layout), so tell the fragment to update
          detailsFragment.updateContent(itemValue);
        }
      }
    });
  }
}

