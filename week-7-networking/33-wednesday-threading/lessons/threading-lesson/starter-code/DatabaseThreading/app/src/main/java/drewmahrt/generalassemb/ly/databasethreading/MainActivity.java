package drewmahrt.generalassemb.ly.databasethreading;

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

//        DatabaseAsyncTask databaseAsyncTask = new DatabaseAsyncTask(mProgressBar,mTextView);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatabaseAsync().execute("john","doe");
            }
        });

    }

    private class DatabaseAsync extends AsyncTask<String,Integer,Integer>{
        @Override
        protected void onPreExecute() {
            mTextView.setText("Adding names");
            mProgressBar.setVisibility(View.VISIBLE);
            mProgressBar.setProgress(0);
            mProgressBar.setMax(1000);

            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(String... params) {
            String firstName = params[0];
            String lastName = params[1];

            for (int i = 0; i < 1000; i++) {
                ExampleDBHelper.getInstance(getApplicationContext()).addName(firstName,lastName);
            }

            int count = ExampleDBHelper.getInstance(getApplicationContext()).getItemCount();

            return count;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            mProgressBar.setVisibility(View.INVISIBLE);

            mTextView.setText("All items added to database! Current item count: "+integer);
            super.onPostExecute(integer);
        }
    }


}
