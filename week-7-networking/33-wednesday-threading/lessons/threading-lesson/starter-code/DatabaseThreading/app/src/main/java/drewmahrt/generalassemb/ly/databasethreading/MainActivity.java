package drewmahrt.generalassemb.ly.databasethreading;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar mProgressBar;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar)findViewById(R.id.progress);
        mTextView = (TextView)findViewById(R.id.text);

//        DatabaseAsyncTask databaseAsyncTask = new DatabaseAsyncTask(mProgressBar,mTextView);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                new DatabaseAsync().execute("john","doe");
=======
                new DatabaseTask().execute("John", "Snow");
>>>>>>> efe8c1a44338a6d1f6db4275bb2ad5d8cd74bf9f
            }
        });

    }

<<<<<<< HEAD
    private class DatabaseAsync extends AsyncTask<String,Integer,Integer>{
        @Override
        protected void onPreExecute() {
            mTextView.setText("Adding names");
            mProgressBar.setVisibility(View.VISIBLE);
            mProgressBar.setProgress(0);
            mProgressBar.setMax(1000);

            super.onPreExecute();
=======

    private class DatabaseTask extends AsyncTask<String, Integer, Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mTextView.setText("Adding items to database...");
            mProgressBar.setVisibility(View.VISIBLE);
            mProgressBar.setProgress(0);
            mProgressBar.setMax(1000);
>>>>>>> efe8c1a44338a6d1f6db4275bb2ad5d8cd74bf9f
        }

        @Override
        protected Integer doInBackground(String... params) {
<<<<<<< HEAD
            String firstName = params[0];
            String lastName = params[1];

            for (int i = 0; i < 1000; i++) {
                ExampleDBHelper.getInstance(getApplicationContext()).addName(firstName,lastName);
            }

=======
            String name = params[0];
            String lastName = params[1];

            for (int i = 0; i < 1000; i++) {
                ExampleDBHelper.getInstance(getApplicationContext()).addName(name,lastName);
                publishProgress(i);
            }
>>>>>>> efe8c1a44338a6d1f6db4275bb2ad5d8cd74bf9f
            int count = ExampleDBHelper.getInstance(getApplicationContext()).getItemCount();

            return count;
        }

        @Override
<<<<<<< HEAD
        protected void onPostExecute(Integer integer) {
            mProgressBar.setVisibility(View.INVISIBLE);

            mTextView.setText("All items added to database! Current item count: "+integer);
            super.onPostExecute(integer);
=======
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int progress = values[0];
            mProgressBar.setProgress(progress);
        }

        @Override
        protected void onPostExecute(Integer count) {
            super.onPostExecute(count);

            mProgressBar.setVisibility(View.INVISIBLE);
            mTextView.setText("All items added to database! Current item count: " + count);
>>>>>>> efe8c1a44338a6d1f6db4275bb2ad5d8cd74bf9f
        }
    }


<<<<<<< HEAD
=======

>>>>>>> efe8c1a44338a6d1f6db4275bb2ad5d8cd74bf9f
}
