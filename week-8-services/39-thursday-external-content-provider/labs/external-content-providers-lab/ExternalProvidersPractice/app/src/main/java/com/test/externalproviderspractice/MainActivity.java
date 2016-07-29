package com.test.externalproviderspractice;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SimpleCursorAdapter simpleCursorAdapter;
    private static final int READ_CONTACTS_PERMISSIONS_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getPermissionToReadUserContacts();
    }

    private Cursor getContacts() {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = new String[]{ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME};

        return getContentResolver().query(uri, projection, null, null, null, null);
    }

    @TargetApi(23)
    public void getPermissionToReadUserContacts() {
        //1. user the support library version Context.Compat.checkSelfPermission
        //to avoid checking the build version since Context.checkSelfPermission
        // is ONLY available in Marshmallow

        //2. also always check for permission (even if permission has already been
        //granted... since the user can REVOKE permissions at any time through Setting

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {

            //The permission is NOT granted yet... check if user has been asked about
            //this permission already and denied it
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.READ_CONTACTS)) {
            }
            //send an async request to actually get the permission
            //this code will show the standard permission request dialog UI
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},
                    READ_CONTACTS_PERMISSIONS_REQUEST);
        } else if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                == PackageManager.PERMISSION_GRANTED) {
            //Permission has been granted! Now list the contacts!
            setContactListView();
        }
    }

    //Callback with the REQUEST from calling requestPermissions

    @TargetApi(23)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {

        //make sure it's our ORIGINAL READ_CONTACTS request

        if(requestCode == READ_CONTACTS_PERMISSIONS_REQUEST) {
            if(grantResults.length== 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Read Contacts permission granted", Toast.LENGTH_SHORT).show();
                setContactListView();
            } else {
                // showRationale = false if user clicks Never Ask Again, otherwise true
                boolean showRationale = shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS);

                if (showRationale) {
                    // do something here to handle degraded mode
                } else {
                    Toast.makeText(this, "Read Contacts permission denied", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }


    public void setContactListView() {
        ListView listView = (ListView) findViewById(R.id.contacts_list);
        final String[] projection = new String[]{ContactsContract.Contacts.CONTENT_TYPE, ContactsContract.Contacts.DISPLAY_NAME};
        final Uri uri = ContactsContract.Contacts.CONTENT_URI;

        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);

        while (cursor.moveToNext()) {
            Log.d(MainActivity.class.getName(), "ID: " + cursor.getString(0) + " Name: " + cursor.getString(1));
        }

        simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                cursor, new String[]{ContactsContract.Contacts.DISPLAY_NAME}, new int[]{android.R.id.text1}, 0);
        listView.setAdapter(simpleCursorAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(MainActivity.class.getName(), "Clicked on ID: " + id);

                Cursor current = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                        null, ContactsContract.Contacts._ID + "=" + id, null, null);
                if (current.moveToFirst()) {
                    String lookupKey = current.getString(current.getColumnIndex(
                            ContactsContract.Contacts.LOOKUP_KEY));
                    Uri lookupUri = Uri.withAppendedPath(ContactsContract.
                            Contacts.CONTENT_LOOKUP_URI, lookupKey);
                    System.out.println("The uri is " + lookupUri.toString());
                    getContentResolver().delete(lookupUri, ContactsContract.Contacts._ID + "=" + id, null);

                    Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                   simpleCursorAdapter.swapCursor(cursor);
                } else {

                    Toast.makeText(MainActivity.this, "error deleting contact", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}