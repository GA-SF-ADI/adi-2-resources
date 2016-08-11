package drewmahrt.generalassemb.ly.databasethreading;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Jon Kim on 7/20/16.
 */
public class DatabaseAsyncTask extends AsyncTask<String,Integer,Integer> {
    ProgressBar mProgressBar;
    TextView mTextView;

    public DatabaseAsyncTask(ProgressBar mProgressBar, TextView mTextView) {
        this.mProgressBar = mProgressBar;
        this.mTextView = mTextView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Integer doInBackground(String... params) {
        String name = params[0];



        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
    }
}
