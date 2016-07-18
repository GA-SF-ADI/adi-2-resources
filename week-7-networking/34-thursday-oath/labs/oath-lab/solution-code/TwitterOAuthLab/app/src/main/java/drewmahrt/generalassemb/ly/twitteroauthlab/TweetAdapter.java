package drewmahrt.generalassemb.ly.twitteroauthlab;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.ArrayList;

import drewmahrt.generalassemb.ly.twitteroauthlab.models.Tweet;

/**
 * Created by drewmahrt on 4/22/16.
 */
public class TweetAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Tweet> tweets;

    public TweetAdapter(Context context, ArrayList<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
        Log.d(TweetAdapter.class.getName(),"Tweets size: "+this.tweets.size());
    }

    @Override
    public int getCount() {
        return tweets.size();
    }

    @Override
    public Object getItem(int position) {
        return tweets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(
                    android.R.layout.simple_list_item_2, null);
        } else {
            view = convertView;
        }

        TextView text1 = (TextView)view.findViewById(android.R.id.text1);
        TextView text2 = (TextView)view.findViewById(android.R.id.text2);

        text2.setTextColor(Color.BLUE);

        text1.setText(tweets.get(position).getText());
        text2.setText(tweets.get(position).getCreatedAt());

        return view;
    }
}
