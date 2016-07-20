package drewmahrt.generalassemb.ly.databasethreading;

import android.os.AsyncTask;

/**
 * Created by audreyeso on 7/20/16.
 */
public class DatabaseAsyncTask extends AsyncTask<String, Integer, Double> {

    //<Void, Void, Void>
    //you must at least have doInBackground

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //TODO: Change text to indicate items are being added
        //TODO: Make progress bar visible
    }

    @Override
    protected Double doInBackground(String... params) {
        String name = params[0];
        //we want the [0] index
        return null;
        //TODO: Add items to database
        //TODO: Return number of items in the database
    }

    @Override
    protected void onProgressUpdate(Integer...values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Double aDouble) {
        super.onPostExecute(aDouble);
        //TODO: Hide progress bar
        //TODO: Update text to indicate all items are added, and display the current count
    }

}
