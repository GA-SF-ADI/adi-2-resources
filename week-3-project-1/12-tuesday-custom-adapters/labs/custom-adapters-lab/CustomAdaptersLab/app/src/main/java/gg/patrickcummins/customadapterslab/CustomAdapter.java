package gg.patrickcummins.customadapterslab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import static android.R.attr.data;

/**
 * Created by patrickcummins on 6/21/16.
 */

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Forecast> forecasts;
    private ViewHolder viewHolder;

    public CustomAdapter(Context context, ArrayList<Forecast> forecasts) {
        this.context = context;
        this.forecasts = forecasts;
    }

    @Override
    public int getCount() {
        return forecasts.size();
    }

    @Override
    public Object getItem(int position) {
        return forecasts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.forecast_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Forecast currentForecast= forecasts.get(position);

        viewHolder.textViewHigh.setText(currentForecast.getHigh());
        viewHolder.textViewLow.setText(currentForecast.getLow());
        viewHolder.textViewWeather.setText(currentForecast.getWeatherPrediction());
        if (currentForecast.getWeatherPrediction().equals("Sunny")){
            viewHolder.weatherImage.setImageResource(R.drawable.sunny);
        }else if (currentForecast.getWeatherPrediction().equals("Dead")){
            viewHolder.weatherImage.setImageResource(R.drawable.dead);

        }else if (currentForecast.getWeatherPrediction().equals("Snowy")){
            viewHolder.weatherImage.setImageResource(R.drawable.snow);

        }else if (currentForecast.getWeatherPrediction().equals("Raining")){
            viewHolder.weatherImage.setImageResource(R.drawable.rain);


        }



        return convertView;
    }

    public class ViewHolder{
        private TextView textViewHigh;
        private TextView textViewLow;
        private TextView textViewWeather;
        private ImageView weatherImage;

        public ViewHolder(View forecastLayout) {
            this.textViewHigh = (TextView) forecastLayout.findViewById(R.id.highTextView);
            this.textViewLow = (TextView) forecastLayout.findViewById(R.id.lowTextView);
            this.textViewWeather = (TextView) forecastLayout.findViewById(R.id.weatherTextView);
            this.weatherImage = (ImageView) forecastLayout.findViewById(R.id.weatherImageView);
        }
    }

}
