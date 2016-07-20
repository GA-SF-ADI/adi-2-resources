package drewmahrt.generalassemb.ly.databasethreading;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyDatabaseAsyncTask myDatabaseAsyncTask = new MyDatabaseAsyncTask();
                myDatabaseAsyncTask.execute();


            }
        });

        //how to create an asynctask
        DatabaseAsyncTask asyncTask = new DatabaseAsyncTask();
        asyncTask.execute("John" , "Doe");
        //can pass in multiple strings because String...params

    }

    public class MyDatabaseAsyncTask extends AsyncTask<Void, Integer, Integer> {
        // make horizontal progress bar in XML, defalut is circle
        @Override
        protected void onPreExecute() {
            //UI thread
            mTextView.setText("Adding items to database...");
            mProgressBar.setVisibility(View.VISIBLE);
            mProgressBar.setProgress(0);
            mProgressBar.setMax(1000);
            //doing 1000 updates that's why it's 1000
            super.onPreExecute();
        }

        @Override
        //this is the worker thread that sends information to UI thread
        protected Integer doInBackground(Void...params) {
            //worker thread
            //String stringName = params[0];
            for (int i = 0; i < 1000; i++) {
                ExampleDBHelper.getInstance(getApplicationContext()).addName("Audrey", "Rainbow");
                //publish progress takes an int (i)
                publishProgress(i); // every time it is called , will activate onProgressUpdate on UI thread
               // mProgressBar.setProgress(i);... this won't work because you have to publish it
            }
            int count = ExampleDBHelper.getInstance(getApplicationContext()).getItemCount();
            return count;
        }

        @Override
        //this is the method that does the updating
        protected void onProgressUpdate(Integer... values) {
            //UI thread
            mProgressBar.setProgress(values [0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer myCount) {
            //UI thread
            mProgressBar.setVisibility(View.INVISIBLE);
            mTextView.setText("All items added to database! Current item count: "+ myCount);
            super.onPostExecute(myCount);
        }

            }

    }


