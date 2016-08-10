package com.differentdevices.threads;

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
                DatabaseAsyncTask dbTask = new DatabaseAsyncTask();
                dbTask.execute();
            }
        });
    }

    public void addDatabaseItems(){
        for (int i = 0; i < 1000; i++) {
            DBHelper.getInstance(getApplicationContext()).addName("John","Doe");
        }
    }

    private class DatabaseAsyncTask extends AsyncTask<Void,Void,Integer>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mTextView.setText("Adding items to database...");
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(Void... params) {
            addDatabaseItems();
            return DBHelper.getInstance(getApplicationContext()).getItemCount();
        }

        @Override
        protected void onPostExecute(Integer count) {
            super.onPostExecute(count);
            mProgressBar.setVisibility(View.INVISIBLE);
            mTextView.setText("All items added to database! Current item count: "+count);
        }
    }
