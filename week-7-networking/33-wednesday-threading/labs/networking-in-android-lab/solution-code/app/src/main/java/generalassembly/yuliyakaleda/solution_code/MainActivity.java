package generalassembly.yuliyakaleda.solution_code;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private static final String URL_TEA =
      "http://api.walmartlabs.com/v1/search?apiKey=35s8a6nuab3wydbn99nb777h&query=tea";
  private static final String URL_CEREAL =
      "http://api.walmartlabs.com/v1/search?apiKey=35s8a6nuab3wydbn99nb777h&query=cereal";
  private static final String URL_CHOCOLATE =
      "http://api.walmartlabs.com/v1/search?apiKey=35s8a6nuab3wydbn99nb777h&query=chocolate";
  private ListView list;
  private List<String> ipods;
  private Button cereal;
  private Button chocolate;
  private Button tea;
  private DownloadTask cerealTask;
  private DownloadTask chocolateTask;
  private DownloadTask teaTask;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    list = (ListView) findViewById(R.id.list);
    cereal = (Button) findViewById(R.id.cereal);
    chocolate = (Button) findViewById(R.id.chocolate);
    tea = (Button) findViewById(R.id.tea);
    cereal.setOnClickListener(this);
    tea.setOnClickListener(this);
    chocolate.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    ConnectivityManager connMgr = (ConnectivityManager)
        getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    if (networkInfo != null && networkInfo.isConnected()) {
      switch (v.getId()) {
        case R.id.cereal:
          //There should be just one AsyncTask running to prevent memory leaks. Thus all other
          // tasks should be cancelled before starting a new one.
          if (teaTask != null) {
            teaTask.cancel(true);
          }
          if (chocolateTask != null) {
            chocolateTask.cancel(true);
          }
          cerealTask = new DownloadTask();
          cerealTask.execute(URL_CEREAL);
          break;
        case R.id.chocolate:
          if (teaTask != null) {
            teaTask.cancel(true);
          }
          if (cerealTask != null) {
            cerealTask.cancel(true);
          }
          chocolateTask = new DownloadTask();
          chocolateTask.execute(URL_CHOCOLATE);
          break;
        case R.id.tea:
          if (cerealTask != null) {
            cerealTask.cancel(true);
          }
          if (chocolateTask != null) {
            chocolateTask.cancel(true);
          }
          teaTask = new DownloadTask();
          teaTask.execute(URL_TEA);
          break;
      }
    } else {
      Toast.makeText(this, R.string.network_connection_check, Toast.LENGTH_LONG).show();
    }
  }

  // Given a URL, establishes an HttpUrlConnection and retrieves the web page content as a
  // InputStream, which it returns as a string.
  private List<String> downloadUrl(String myUrl) throws IOException, JSONException {
    InputStream is = null;

    try {
      URL url = new URL(myUrl);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setDoInput(true);
      // Starts the query
      conn.connect();
      is = conn.getInputStream();

      // Convert the InputStream into a string
      String contentAsString = readIt(is);
      ipods = parseJson(contentAsString);
      return ipods;

      // Makes sure that the InputStream is closed after the app is
      // finished using it.
    } finally {
      if (is != null) {
        is.close();
      }
    }
  }

  private List<String> parseJson(String contentAsString) throws JSONException {
    JSONObject root = new JSONObject(contentAsString);
    JSONArray array = root.getJSONArray("items");
    for (int i = 0; i < array.length(); i++)
    {
      JSONObject item = array.getJSONObject(i);
      String name = item.getString("name");
      ipods.add(name);
    }
    return ipods;
  }

  public String readIt(InputStream stream) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(stream));
    String read;

    while((read = br.readLine()) != null) {
      sb.append(read);
    }
    return sb.toString();
  }

  private class DownloadTask extends AsyncTask<String, Void, List<String>> {
    @Override
    protected List<String> doInBackground(String... urls) {
      ipods = new ArrayList<>();
      try {
        return downloadUrl(urls[0]);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (JSONException e) {
        e.printStackTrace();
      }
      return ipods;
    }

    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(List<String> listIpods) {
      ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout
          .simple_list_item_1, listIpods);
      list.setAdapter(adapter);
    }
  }
}
