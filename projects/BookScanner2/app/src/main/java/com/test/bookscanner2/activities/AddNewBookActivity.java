package com.test.bookscanner2.activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.test.bookscanner2.interfaces.OpenLibraryAPI;
import com.test.bookscanner2.R;
import com.test.bookscanner2.models.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddNewBookActivity extends AppCompatActivity {

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    static final String ACTION_ZXING = "com.google.zxing.client.android";
    static final String SCAN_MODE = "SCAN_MODE";
    static final String PRODUCT_MODE = "PRODUCT_MODE";
    static final String QR_MODE = "QR_CODE_MODE";

    private Button bookListButton;
    private TextView textView;
    private String baseUrl = "https://openlibrary.org/api/";
//    private String baseUrl = "https://openlibrary.org/";
    private String contents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);

        //getBookDescription();



        textView = (TextView) findViewById(R.id.textview);
        bookListButton = (Button) findViewById(R.id.book_list_button);
        bookListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddNewBookActivity.this, BookListActvity.class);
                startActivity(intent);
            }

        });
    }

    public void scanBar(View view) {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra(SCAN_MODE, PRODUCT_MODE);
            startActivityForResult(intent, 0);
            //getBookDescription(); // getting book description here
            getBookDescription();
        } catch (ActivityNotFoundException e) {
            showDialog(AddNewBookActivity.this, "No Scanner Found",
                    "Download a scanner code activity?", "Yes", "No").show();
        }
    }

    public void scanQR(View view) {
        try {
            Intent intent = new Intent(ACTION_SCAN);
            intent.putExtra(SCAN_MODE, QR_MODE);
            startActivityForResult(intent, 0);
        } catch (ActivityNotFoundException e) {
            showDialog(AddNewBookActivity.this, "No Scanner Found",
                    "Download a scanner code activity?", "Yes", "No").show();
        }
    }

    private static AlertDialog showDialog(final AddNewBookActivity act, CharSequence title,
                                          CharSequence message, CharSequence buttonYes,
                                          CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title).setMessage(message).setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                Uri uri = Uri.parse("market://search?q=pname:" + ACTION_ZXING);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                }

            }
        }).setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

            }
        });
        return downloadDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                contents = intent.getStringExtra("SCAN_RESULT");
                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
                Toast.makeText(this, "Content:" + contents + "Format:" +
                        format, Toast.LENGTH_LONG).show();

                // append "ISBN:" to contents

            }
        }
    }


    protected void getBookDescription() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            OpenLibraryAPI openLibraryAPI = retrofit.create(OpenLibraryAPI.class);
            //replace ISBN with contents //"ISBN:0439639034"- flyguy
            //https://openlibrary.org/api/books?bibkeys=ISBN:0439639034&jscmd=data&format=json
            //9780060731335
            //slow reading 9780980200447
            //contents = "9780980200447";
            String full = "ISBN:" + contents;


            Call<Example> call = openLibraryAPI.getBookDescription(full,"data","json");

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    try {

                        Log.d("on response", "onResponse: " + response.body().getiSBN().getTitle().toString());

                        //String title = response.body().getMyTitle().toString();
//                        String ISBN = response.body().getMyTitle(contents);
//                        String newISBN= response.body().setISBN9780980200447(ISBN);

                        //String book = response.body().setISBN9780980200447(full);
                        String bookTitle = response.body().getiSBN().getTitle().toString();
                        String bookAuthor = response.body().getiSBN().getAuthors().toString();


                        textView.setText(bookTitle);

                        String x = bookTitle;

                        Toast.makeText(AddNewBookActivity.this, x, Toast.LENGTH_LONG).show();


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        } else {
            Toast.makeText(AddNewBookActivity.this, "No WIFI", Toast.LENGTH_LONG).show();

        }

    }

}
