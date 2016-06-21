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
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TextView textView1 = viewHolder.firstTV;
        TextView textView2 = viewHolder.secondTV;
        Button mButton = viewHolder.theButton;

        final Animal currentAnimal = data.get(position);

        textView1.setText(currentAnimal.getName());
        textView2.setText(currentAnimal.getSound());

        mButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Toast.makeText(context, "The " + currentAnimal.getName() + " goes " + currentAnimal.getSound(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
    private class ViewHolder{
        TextView firstTV;
        TextView secondTV;
        Button theButton;

        public ViewHolder(View itemLayout) {
            this.firstTV = (TextView) itemLayout.findViewById(R.id.list_item_tv_first);
            this.secondTV = (TextView) itemLayout.findViewById(R.id.list_item_tv_second);
            this.theButton = (Button) itemLayout.findViewById(R.id.list_item_button);
        }
    }


}
