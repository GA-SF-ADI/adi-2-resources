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



        /*Was able to do all instructions of homework part#1 on my own until now. Not really sure how
        to copy the iPhone contacts to the Android contacts, nor how to remove all iPhone contacts
        using the Android contact list. Need to get better at running these complex methods. No
        real point in me just copying/pasting the solution code into here :/ .....

*/

        androidPhoneBook.setPhoneBookType("Android");


    }
}
