package ly.generalassemb.fragment1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by alex on 7/8/16.
 */
public class DetailFragment extends Fragment {
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    public void setText(String textFromMainActivity){
        textView = (TextView) getView().findViewById(R.id.detail_text);

        textView.setText("Fragment: " + textFromMainActivity);
    }
}
