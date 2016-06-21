package ly.generalassemb.customadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Custom Adapter for our two TextViews and single Button.
 *
 * It holds a list of Animals and binds the animal name to
 * firstTextView, animal sound to secondTextView.
 *
 * When button is clicked a toast is made with animal name saying
 * animal sound ( i.e. cow says moo ).
 */
public class CustomBaseAdapter extends BaseAdapter {

    // TODO: implement the rest of the CustomBaseAdapter class

    // hint: Create constructor first. Implement 4 methods next.

    private ArrayList<Animal> data;
    private Context context;

    public CustomBaseAdapter(Context context, ArrayList<Animal> animalList) {
        this.data = animalList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        TextView firstTV = (TextView) convertView.findViewById(R.id.list_item_tv_first);
        TextView secondTV = (TextView) convertView.findViewById(R.id.list_item_tv_second);
        Button button = (Button) convertView.findViewById(R.id.list_item_button);

        final Animal currentAnimal = data.get(position);

        firstTV.setText(currentAnimal.getName());
        secondTV.setText(currentAnimal.getSound());

        final String toastText = currentAnimal.getName() + " says: " + currentAnimal.getSound();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    // TODO: Bonus - use a ViewHolder!
}
