package ly.generalassemb.permissions;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView contactslistView;
    private Button showContactsButton;
    private ArrayAdapter arrayAdapter;

    private ArrayList<String> contacts;
    private static final String column = ContactsContract.Contacts.DISPLAY_NAME;
    private static final String CONTACTS_PERMISSION = Manifest.permission.READ_CONTACTS;
    private static final int PERMISSION_REQUEST_CODE = 12345;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupListView();
    }

    //region Views
    private void setupViews(){
        showContactsButton = (Button) findViewById(R.id.contacts_button);
        showContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showContacts();
            }
        });
    }

    private void setupListView(){
        contacts = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, contacts);

        contactslistView = (ListView) findViewById(R.id.contact_list_view);
        contactslistView.setAdapter(arrayAdapter);
    }

    /**
     * Returns a cursor that holds all contacts on the phone
     *
     * @return
     */
    public Cursor getContactsCursor() {
        Cursor cursor = null;
        if (permissionExists()){
            ContentResolver contentResolver = getContentResolver();
            Uri contentUri = ContactsContract.Contacts.CONTENT_URI;

            cursor = contentResolver.query(contentUri, null, null, null, null);
        } else {
            requestUserForPermission();
        }
        return cursor;
    }
    //endregion Views

    /**
     * Adds all of the contacts from the cursor to our list view and notifies
     * the adapter of the change.
     *
     * If no contacts are found, we make a toast.
     */
    private void showContacts(){
        Cursor cursor = getContactsCursor();
        if (cursor == null){
            Toast.makeText(this, "No contacts found", Toast.LENGTH_SHORT).show();
            return;
        }
        // Erase old contacts from list
        contacts.clear();

        // Loop through every contact in the phone
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex( column ));
            contacts.add(name);
        }
        arrayAdapter.notifyDataSetChanged();
    }

    //region Permissions

    /**
     * Returns true if the permission is granted. False otherwise.
     *
     * NOTE: If we detect that this phone is an older OS then Android M, we assume
     * the permission is true because they are granted at INSTALL time.
     *
     * @return
     */
    @TargetApi(23)
    private boolean permissionExists(){
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion < Build.VERSION_CODES.M){

            // Permissions are already granted during INSTALL TIME for older OS version
            return true;
        }

        int granted = checkSelfPermission(CONTACTS_PERMISSION);
        if (granted == PackageManager.PERMISSION_GRANTED){
            return true;
        }
        return false;
    }

    /**
     * This method will request the user for read contacts permission
     *
     * If a phone is running older OS then Android M, we simply return because
     * those phone are using the OLD permission model and permissions are granted at
     * INSTALL time.
     */
    @TargetApi(23)
    private void requestUserForPermission(){
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion < Build.VERSION_CODES.M){
            // This OS version is lower then Android M, therefore we have old permission model and should not ask for permission
            return;
        }

        // TODO request the CONTACTS_PERMISSION!
    }

    /**
     * This method returns to us the results of our permission request
     *
     * Note that permissions is a String array and grantResults is an integer Array.
     * This means that:
     * - permissions[0] relates to grantResults[0]
     * - permissions[1] relates to grantResults[1]
     * - permissions[2] relates to grantResults[2]
     * - etc
     *
     * For EACH permission asked. So if you ask for three permissions, both of these arrays
     * will have size 3 like shown above.
     *
     * In our case, we only asked for one permission, so we only check permissions[0] and grantResults[0]
     *
     * @param requestCode The original code we sent the request with. If this code doesn't match, its not our result.
     * @param permissions Array of permissions in the order they were asked
     * @param grantResults Results for each permission ( granted or not granted ) in the same order of permission array
     */
    // TODO Override the onRequestPermissionsResult() here
    
    //endregion Permissions

}
