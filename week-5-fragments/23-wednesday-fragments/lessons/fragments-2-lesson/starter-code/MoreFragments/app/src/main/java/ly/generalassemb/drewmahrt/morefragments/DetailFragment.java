package ly.generalassemb.drewmahrt.morefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by drewmahrt on 2/25/16.
 */
public class DetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail,container,false);
    }

    public void setPlanet(String planet){
        TextView textView = (TextView)getView().findViewById(R.id.text);
        textView.setText(planet);

    }

    // TODO: Create your helper method that takes selected planet name and sets it as text to TextView


}
