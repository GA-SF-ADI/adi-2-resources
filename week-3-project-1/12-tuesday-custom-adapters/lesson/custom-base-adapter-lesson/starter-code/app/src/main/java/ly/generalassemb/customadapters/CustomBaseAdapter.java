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
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
        }else {

            viewHolder = (ViewHolder) convertView.getTag();

        }

        final Animal currentAnimal = data.get(position);

        viewHolder.firstTextView.setText(currentAnimal.getName());
        viewHolder.secondTextView.setText(currentAnimal.getName());

        final String toastText = currentAnimal.getName() + "says:"+ currentAnimal.getSound();
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
            }
        });




        return convertView;
    }
// TODO: implement the rest of the CustomBaseAdapter class

    // hint: Create constructor first. Implement 4 methods next.



    // TODO: Bonus - use a ViewHolder!
    private class ViewHolder {
        TextView firstTextView;
        TextView secondTextView;
        Button button;

        public ViewHolder(View itemLayout){
            this.firstTextView = (TextView) itemLayout.findViewById(R.id.list_item_tv_first);
            this.secondTextView = (TextView) itemLayout.findViewById(R.id.list_item_tv_second);
            this.button =(Button) itemLayout.findViewById(R.id.list_item_button);

        }

    }
}
