package ly.generalassemb.drewmahrt.actorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drewmahrt on 2/29/16.
 */
public class ActorArrayAdapter extends ArrayAdapter<Actor> {
    ArrayList<Actor> mActors;

    public ActorArrayAdapter(Context context, int resource, ArrayList<Actor> actors) {
        super(context, resource, actors);
        mActors = actors;
    }

    @Override
    public int getCount() {
        return mActors.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = ((LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.actor_item,parent,false);
        }

        TextView nameText = (TextView)convertView.findViewById(R.id.actor_name);
        TextView dobText = (TextView) convertView.findViewById(R.id.actor_dob);
        TextView oscarsText = (TextView) convertView.findViewById(R.id.num_oscars);

        nameText.setText("Name: "+mActors.get(position).getmName());
        dobText.setText("DOB: "+mActors.get(position).getmDob());
        oscarsText.setText("Oscars won: "+mActors.get(position).getmNumOscars());

        return convertView;
    }
}
