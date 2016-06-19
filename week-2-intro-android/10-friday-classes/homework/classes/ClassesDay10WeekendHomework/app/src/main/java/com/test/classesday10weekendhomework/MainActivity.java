package com.test.classesday10weekendhomework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PhoneBook iPhonePhoneBook = new PhoneBook();

        PhoneBook androidPhoneBook = new PhoneBook();
        

        /*From here, wasn't really sure how to copy the iPhone contacts
        to the Android contacts, nor how to remove all iPhone contacts
        using the Android contact list.

*/


    }
}
