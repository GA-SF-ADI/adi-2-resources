package ly.generalassemb.fragment1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alex on 7/8/16.
 */
public class DetailFragment extends Fragment {
    private TextView textView;
    private Button button;
    private OnSendStringListener onSendStringListener;
    private String textFromMainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onSendStringListener = (OnSendStringListener) getActivity();
        } catch (ClassCastException e){
            throw new ClassCastException("Activity must implement OnSendStringListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);

        return view;
    }

    // Called after onCreateView when our layout has been inflated
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = (TextView) getView().findViewById(R.id.detail_text);
        button = (Button) getView().findViewById(R.id.detail_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // reverse the string
                StringBuilder sb = new StringBuilder(textFromMainActivity);
                String reversed = sb.reverse().toString();

                // send it back to main activity
                onSendStringListener.onStringSent(reversed);
            }
        });
    }

    public void setText(String fromMain){
        textFromMainActivity = fromMain;
        textView.setText(fromMain);
    }
}
