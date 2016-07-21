package drewmahrt.generalassemb.ly.databasethreading;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by alex on 7/20/16.
 */
public class ExampleAsyncTask extends AsyncTask<String, String, Double> {
    private String TAG = "AsyncTask";
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i(TAG, "onPreExecute: ");
    }

    @Override
    protected Double doInBackground(String... params) {
        String name = params[0];
        String lastName = params[1];

        // DO what I want with the name in backgorund thread
        Log.i(TAG, "doInBackground: name is " + name + " last name is " + lastName);
        publishProgress("Some value");
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        Log.i(TAG, "onProgressUpdate: progress value " + values[0] );
    }

    @Override
    protected void onPostExecute(Double aDouble) {
        super.onPostExecute(aDouble);
        Log.i(TAG, "onPostExecute: ");
    }

}
