package generalassembly.yuliyakaleda.usabilitytestinglabsolutioncode;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SignListFragment extends Fragment {
  private static final String SIGN = "sign";
  private ListView listView;

  // Define an instance of our OnSignClickListener interface
  private OnSignClickedListener onSignClickedListener;
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);

    try {
      // try to convert activity into OnSignClickedListener
      onSignClickedListener = (OnSignClickedListener) getActivity();
    } catch (ClassCastException e){
      // If activity does not implement OnSignClickedListener we throw an exception
      throw new ClassCastException("Activity must implement OnSignClickedListener");
    }
  }

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
        String sign = (String) listView.getItemAtPosition(position);
        onSignClickedListener.onSignClick(sign);
      }
    });
  }
}

