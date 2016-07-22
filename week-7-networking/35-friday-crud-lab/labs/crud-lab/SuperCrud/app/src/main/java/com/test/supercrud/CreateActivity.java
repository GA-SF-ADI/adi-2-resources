package com.test.supercrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateActivity extends AppCompatActivity {
    CreateCustomBaseAdapter customBaseAdapter;
    private ListView listView;
    private ArrayList<Books> booksArrayList;
    private SuperCrudInterface superCrudInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        setupBooks();
        listView = (ListView) findViewById(R.id.listView_created_books);
//
//        bookTitle = (EditText) findViewById(R.id.edit_text_book_title);
//        bookAuthor = (EditText) findViewById(R.id.edit_text_book_author);
//        imageLink = (EditText) findViewById(R.id.edit_text_image_url);
//        addButton = (Button) findViewById(R.id.button_add);


    superCrudInterface.postBooks().enqueue(new retrofit2.Callback<Root>() {
        @Override
        public void onResponse(retrofit2.Call<Root> call, retrofit2.Response<Root> response) {
            // grab the two objects from the response
            //STEP 5: use AuthenticationResponse object to get response
            //get the user if you want to
            Root root = response.body();
            customBaseAdapter = new CreateCustomBaseAdapter(CreateActivity.this, Arrays.asList(root.setBooks()));
            customBaseAdapter.notifyDataSetChanged();
            //change adapter to list
            listView.setAdapter(customBaseAdapter);
            //set up adapter here

        }

        @Override
        public void onFailure(retrofit2.Call<Root> call, Throwable t) {
            t.printStackTrace();
            Toast.makeText(CreateActivity.this, "No WIFI", Toast.LENGTH_LONG).show();

        }

    });
}


    private void setupBooks() {
        // 5. Create retrofit instance with a base url and GsonConverter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        superCrudInterface = retrofit.create(SuperCrudInterface.class);
    }


}
