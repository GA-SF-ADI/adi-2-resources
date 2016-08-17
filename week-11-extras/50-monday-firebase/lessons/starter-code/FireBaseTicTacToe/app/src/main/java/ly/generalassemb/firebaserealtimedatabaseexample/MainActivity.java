package ly.generalassemb.firebaserealtimedatabaseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private static final String BOX_1 = "box1";
    private static final String BOX_2 = "box2";
    private static final String BOX_3 = "box3";
    private static final String BOX_4 = "box4";
    private static final String BOX_5 = "box5";
    private static final String BOX_6 = "box6";
    private static final String BOX_7 = "box7";
    private static final String BOX_8 = "box8";
    private static final String BOX_9 = "box9";

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference gameRef;

    private EditText mBox1, mBox2, mBox3, mBox4, mBox5, mBox6, mBox7, mBox8, mBox9;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Setup your firebase and game category reference
        firebaseDatabase = FirebaseDatabase.getInstance();
        setupViews();
        setupGameUpdates();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }



        // TODO ChildEventListener
        private void setupGameUpdates () {
            gameRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    String newValue = dataSnapshot.getValue(String.class);
                    updateBoard(dataSnapshot.getKey(), newValue);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    String updatedValue = dataSnapshot.getValue(String.class);
                    updateBoard(dataSnapshot.getKey(), updatedValue);
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        // Hint dataSnapshot.getKey() returns the key for this snapshot
        // Hint make use of updateBoard() helper method


    private void updateBoard(String key, String updatedValue) {
        switch (key) {
            case BOX_1:
                mBox1.setText(updatedValue);
                break;
            case BOX_2:
                mBox2.setText(updatedValue);
                break;
            case BOX_3:
                mBox3.setText(updatedValue);
                break;
            case BOX_4:
                mBox4.setText(updatedValue);
                break;
            case BOX_5:
                mBox5.setText(updatedValue);
                break;
            case BOX_6:
                mBox6.setText(updatedValue);
                break;
            case BOX_7:
                mBox7.setText(updatedValue);
                break;
            case BOX_8:
                mBox8.setText(updatedValue);
                break;
            case BOX_9:
                mBox9.setText(updatedValue);
                break;
            default:
                break;
        }
    }


    private void setupViews() {
        mBox1 = (EditText) findViewById(R.id.box1);
        mBox2 = (EditText) findViewById(R.id.box2);
        mBox3 = (EditText) findViewById(R.id.box3);
        mBox4 = (EditText) findViewById(R.id.box4);
        mBox5 = (EditText) findViewById(R.id.box5);
        mBox6 = (EditText) findViewById(R.id.box6);
        mBox7 = (EditText) findViewById(R.id.box7);
        mBox8 = (EditText) findViewById(R.id.box8);
        mBox9 = (EditText) findViewById(R.id.box9);

        setupEditTexts();
    }

    private void setupEditTexts() {
        // TODO: Listen for changes in EditText and pass them up to DB

            mBox1.addTextChangedListener(new Watcher(BOX_1));
            mBox2.addTextChangedListener(new Watcher(BOX_2));
            mBox3.addTextChangedListener(new Watcher(BOX_3));
            mBox4.addTextChangedListener(new Watcher(BOX_4));
            mBox5.addTextChangedListener(new Watcher(BOX_5));
            mBox6.addTextChangedListener(new Watcher(BOX_6));
            mBox7.addTextChangedListener(new Watcher(BOX_7));
            mBox8.addTextChangedListener(new Watcher(BOX_8));
            mBox9.addTextChangedListener(new Watcher(BOX_9));
        }
         class Watcher implements TextWatcher {
            private String refPath;

            public Watcher(String refPath) {
                // We have a slash denoting child here, ie /box1 or /box2, etc.
                this.refPath = "/" + refPath;
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("Watcher", refPath + " updated text to " + charSequence.toString() + " updated DB");
                gameRef.child(refPath).setValue(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        }

}





