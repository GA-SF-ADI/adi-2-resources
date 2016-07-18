package ly.generalassemb.drewmahrt.gsonexample;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //TODO: Insert your API Key into the URL
    private static String mUrl = "http://api.walmartlabs.com/v1/search?apiKey=g5p3xscxuhc7v4bgecnckwkp&query=";
    //private static String mUrl = "http://api.walmartlabs.com/v1/items?apiKey=g5p3xscxuhc7v4bgecnckwkp&upc=035000521019";

    private WalmartAsyncTask mTask;
    private ArrayAdapter<WalmartItem> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new ArrayAdapter<WalmartItem>(this,android.R.layout.simple_list_item_1,new ArrayList<WalmartItem>());

        ListView listView = (ListView) findViewById(R.id.results_list);
        listView.setAdapter(mAdapter);

        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    if (mTask != null && (mTask.getStatus() != AsyncTask.Status.FINISHED)) {
                        mTask.cancel(true);
                    }
                    mTask = new WalmartAsyncTask();
                    String query = ((TextView)findViewById(R.id.search_text)).getText().toString();
                    mTask.execute(mUrl+query);
                } else {
                    Toast.makeText(MainActivity.this, "No network connection detected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class WalmartAsyncTask extends AsyncTask<String, Void, WalmartSearchResult> {

        @Override
        protected WalmartSearchResult doInBackground(String... params) {
            String data ="";
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inStream = connection.getInputStream();
                data = getInputData(inStream);
            } catch (Throwable e) {
                e.printStackTrace();
            }

            Gson gson = new Gson();
            WalmartSearchResult result = gson.fromJson(data, WalmartSearchResult.class);

            return result;
        }

        @Override
        protected void onPostExecute(WalmartSearchResult s) {
            super.onPostExecute(s);
            mAdapter.clear();
            mAdapter.addAll(s.getItems());
        }
    }

    private String getInputData(InputStream inStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

        String data = null;

        while ((data = reader.readLine()) != null){
            builder.append(data);
        }

        reader.close();

        return builder.toString();
    }
}
