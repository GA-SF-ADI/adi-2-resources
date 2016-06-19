package com.test.classesday10weekendhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PhoneBook iPhonePhoneBook = new PhoneBook(currentContacts);

        PhoneBook androidPhoneBook = new PhoneBook();


        androidPhoneBook.removeContact();










    }
}
