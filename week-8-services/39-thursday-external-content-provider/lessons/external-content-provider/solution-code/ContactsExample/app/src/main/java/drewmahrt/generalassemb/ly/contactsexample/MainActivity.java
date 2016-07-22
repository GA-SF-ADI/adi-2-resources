package drewmahrt.generalassemb.ly.contactsexample;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.UserDictionary;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    SimpleCursorAdapter mCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView)findViewById(R.id.contacts_list);

        final String[] projection = new String[] { ContactsContract.Contacts._ID, ContactsContract.Contacts.DISPLAY_NAME };
        final Uri uri = ContactsContract.Contacts.CONTENT_URI;

        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);

        while(cursor.moveToNext()){
            Log.d(MainActivity.class.getName(),"ID: "+cursor.getString(0)+" Name: "+cursor.getString(1));
        }

        mCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{ContactsContract.Contacts.DISPLAY_NAME},new int[]{android.R.id.text1},0);
        listView.setAdapter(mCursorAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(MainActivity.class.getName(),"Clicked on ID: "+id);
//                getContentResolver().delete(uri,null,null);

                Cursor current = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                        null, ContactsContract.Contacts._ID + "=" + id, null, null);
                if(current.moveToFirst()) {
                    String lookupKey = current.getString(current.getColumnIndex(
                            ContactsContract.Contacts.LOOKUP_KEY));
                    Uri lookupUri = Uri.withAppendedPath(ContactsContract.
                            Contacts.CONTENT_LOOKUP_URI, lookupKey);
                    System.out.println("The uri is " + lookupUri.toString());
                    getContentResolver().delete(lookupUri, ContactsContract.Contacts._ID + "=" + id, null);

                    Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                    mCursorAdapter.swapCursor(cursor);
                }else {
                    Snackbar.make(view, "Error deleting contact", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                return false;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    private Cursor getContacts() {
        // Run query
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        String[] projection = new String[] { ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME };


        return getContentResolver().query(uri, projection, null, null, null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
