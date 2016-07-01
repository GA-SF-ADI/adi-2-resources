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
    private ArrayList<Animal> data;
    private Context context;
    private ViewHolder viewHolder;

    public CustomBaseAdapter(Context context, ArrayList<Animal> animalList){
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        /**
         * Convert view will be the top level view of our list item layout.
         *
         * For us this means its a LinearLayout.
         *
         * We check if its null, and non existent then we inflate the view. Otherwise
         * we want to re-use the current layout.
         */
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /**
         * We can pull out our data object from the data list using its position.
         *
         * In this case, we grab the current animal for this view based on its position
         * in the data list.
         */
        final Animal currentAnimal = data.get(position);

        /**
         * Now we can bind our data values from the currentAnimal object instance into our
         * views, which are saved inside the ViewHolder!
         */
        viewHolder.firstTextView.setText(currentAnimal.getName());
        viewHolder.secondTextView.setText(currentAnimal.getSound());

        /**
         * Lastly, we create a button click listener that will toast the animal name and sound.
         *
         * First we store the String `animalName says: animalSound` inside a variable to use inside
         * the Toast
         */
        final String toastText = currentAnimal.getName() + " says: "+ currentAnimal.getSound();
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * Return the whole item layout here so it can be drawn by the ListView
         */
        return convertView;
    }

    private class ViewHolder {
        TextView firstTextView;
        TextView secondTextView;
        Button button;

        public ViewHolder(View itemLayout){
            this.firstTextView = (TextView) itemLayout.findViewById(R.id.list_item_tv_first);
            this.secondTextView = (TextView) itemLayout.findViewById(R.id.list_item_tv_second);
            this.button = (Button) itemLayout.findViewById(R.id.list_item_button);
        }
    }
}
