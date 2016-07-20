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

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleAsync aTask = new ExampleAsync();
                aTask.execute();
            }
        });

    }

    public void addDatabaseItems(){
        for (int i = 0; i < 1000; i++) {
            ExampleDBHelper.getInstance(getApplicationContext()).addName("John","Doe");
        }

    }

    class ExampleAsync extends AsyncTask<Void,Void,Integer>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //TODO: Change text to indicate items are being added
            //TODO: Make progress bar visible
            mTextView.setText("Adding items to database...");
            mProgressBar.setVisibility(View.VISIBLE);


        }

        @Override
        protected Integer doInBackground(Void... params) {
         addDatabaseItems();
           int count = ExampleDBHelper.getInstance(getApplicationContext()).getItemCount();
            return count;
        }

        @Override
        protected void onPostExecute(Integer count) {
            super.onPostExecute(count);
            //TODO: Hide progress bar
            //TODO: Update text to indicate all items are added, and display the current count

            mProgressBar.setVisibility(View.INVISIBLE);
            mTextView.setText("count: "+ count);
        }


    }

}

