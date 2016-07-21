package drewmahrt.generalassemb.ly.databasethreading;

import android.os.AsyncTask;

/**
 * Created by michaeljeffress on 7/20/16.
 */
public class ExampleAsyncTask extends AsyncTask<String,Integer,Double> {



    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Double doInBackground(String... params) {
        String name = params[0];
        publishProgress();
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Double aDouble) {
        super.onPostExecute(aDouble);
    }
}