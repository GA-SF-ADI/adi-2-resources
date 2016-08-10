package generalassembly.yuliyakaleda.usabilitytestingstartercode;

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
      // TODO: Write the logic that will check if the DetailsFragment is present next to the
      // TODO: ListFragment or not. If it is not (it is a handset), start DetailsActivity. If
      // TODO: it is present, get reference to DetailsFragment and call a method on it that will
      // TODO: open a webview with the information about the clicked sign.

      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String itemValue = (String) listView.getItemAtPosition(position);

        DetailsFragment detailsFragment = (DetailsFragment) getFragmentManager()
                .findFragmentById(R.id.details_fragment);

        //null check to see if the details fragment is there.  If the detail fragement is NOT there its a phone.
        //if its a phone we start the "detail" activity
        //if null check reveals that the details fragment IS there, that means its a tablet.

        if(detailsFragment==null) {  //So, if its a phone (no detail activity there),start the activity:
          Intent intent = new Intent(getActivity(), DetailsActivity.class);
          intent.putExtra(SIGN, itemValue);
          startActivity(intent);
        }else{ //its a tablet and the detail fragment is there
          //tell fragment to update with the bigger layout for for a tablet
          detailsFragment.updateContent(itemValue);
      } }
    });
  }
}
