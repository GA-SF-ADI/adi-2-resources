package com.test.apipractice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.apipractice.models.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//curl --get --include 'https://love-calculator.p.mashape.com/getPercentage?fname=John&sname=Alice' \
//        -H 'X-Mashape-Key: wqOVdPoS0MmshZ1W7TwnpDSEpy7tp1UgLvEjsnrt7r5gMDKyDc' \
//        -H 'Accept: application/json'

public class MainActivity extends AppCompatActivity {

    String baseURL = "https://love-calculator.p.mashape.com/";
    EditText editTextName1;
    EditText editTextName2;
    Button button;
    TextView name1View, name2View, percentageView, resultView;
    String name1, name2;
    String fName = " wqOVdPoS0MmshZ1W7TwnpDSEpy7tp1UgLvEjsnrt7r5gMDKyDc";
    String sName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName1 = (EditText) findViewById(R.id.edit_name1);
        editTextName2 = (EditText) findViewById(R.id.edit_name2);
        button = (Button) findViewById(R.id.button);
        name1View = (TextView) findViewById(R.id.name1);
        name2View = (TextView) findViewById(R.id.name2);
        percentageView = (TextView) findViewById(R.id.percentage);
        resultView = (TextView) findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name1 = editTextName1.getText().toString();
                name2 = editTextName2.getText().toString();

                getNames(name1, name2);
            }
        });
    }

    protected void getNames(String fname, String sname) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            // the connection is available
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            LoveCalcInterface loveCalcInterface = retrofit.create(LoveCalcInterface.class);
            Call<Model> call = loveCalcInterface.getLoveCalc(fName, sname);

            call.enqueue(new Callback<Model>() {
                @Override
                public void onResponse(Call<Model> call, Response<Model> response) {

                    try {
                        String firstName = response.body().getFname();
                        String secondName = response.body().getSname();
                        int percentage = response.body().getPercentage();
                        String result = response.body().getResult();

                        //views here

                        name1View.setText(firstName);
                        name2View.setText(secondName);
                        percentageView.setText(percentage);
                        resultView.setText(result);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<Model> call, Throwable t) {

                }
            });

        } else {

            Toast.makeText(this, "No WIFI", Toast.LENGTH_SHORT).show();
        }

    }

}

