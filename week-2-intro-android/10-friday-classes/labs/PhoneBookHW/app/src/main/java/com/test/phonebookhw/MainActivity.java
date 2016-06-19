package com.test.phonebookhw;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make ArrayList here for "old contacts"

        ArrayList<Contact> oldContacts = returnMyContacts();
        PhoneBook iPhone = new PhoneBook(oldContacts, "iPhone");
        PhoneBook androidPhone = new PhoneBook();
        AndroidPhone androidPhone1 = new AndroidPhone(oldContacts, "Android", 3.0f);

        boolean checkVersion = androidPhone1.checkVersion();

        //below: gets the iphone contacts and COPIES them to android
        //had to look up because I was stuck here...
        if (checkVersion) {
            for (Contact contact : iPhone.getContactsList()) {
                androidPhone.addNewContact(contact);
            }
            //had to look up how to remove as well...
            for (Contact contact : androidPhone.getContactsList()) {
                iPhone.removeContact(contact);
            }
        } else {
            Toast.makeText(MainActivity.this, "Does not work", Toast.LENGTH_SHORT).show();
        }
    }
        protected static ArrayList<Contact> returnMyContacts() {

            ArrayList<Contact> myContactList = new ArrayList<>();

            Contact firstContact = new Contact("Audrey", "1234567890");
            Contact secondContact = new Contact("Liz", "987654321");
            myContactList.add(firstContact);
            myContactList.add(secondContact);

            //I knew how to create an arraylist and add contacts to it
            // I got stuck on returning the list

            return myContactList;

        }

    }

