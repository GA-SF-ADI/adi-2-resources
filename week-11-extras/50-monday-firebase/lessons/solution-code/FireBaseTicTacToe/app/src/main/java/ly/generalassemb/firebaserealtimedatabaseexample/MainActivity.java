package ly.generalassemb.firebaserealtimedatabaseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference gameRef;

    private EditText mBox1, mBox2, mBox3, mBox4, mBox5, mBox6, mBox7, mBox8, mBox9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get instance of database singleton
        firebaseDatabase = FirebaseDatabase.getInstance();
        gameRef = firebaseDatabase.getReference("tic-tac-toe");

        setupViews();
        setupGameUpdates();
    }

    private void setupGameUpdates() {
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

    private void updateBoard(String key, String updatedValue){
        switch (key){
            case "box1":
                mBox1.setText(updatedValue);
                break;
            case "box2":
                mBox2.setText(updatedValue);
                break;
            case "box3":
                mBox3.setText(updatedValue);
                break;
            case "box4":
                mBox4.setText(updatedValue);
                break;
            case "box5":
                mBox5.setText(updatedValue);
                break;
            case "box6":
                mBox6.setText(updatedValue);
                break;
            case "box7":
                mBox7.setText(updatedValue);
                break;
            case "box8":
                mBox8.setText(updatedValue);
                break;
            case "box9":
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
        mBox1.addTextChangedListener(new Watcher("/box1"));
        mBox2.addTextChangedListener(new Watcher("/box2"));
        mBox3.addTextChangedListener(new Watcher("/box3"));
        mBox4.addTextChangedListener(new Watcher("/box4"));
        mBox5.addTextChangedListener(new Watcher("/box5"));
        mBox6.addTextChangedListener(new Watcher("/box6"));
        mBox7.addTextChangedListener(new Watcher("/box7"));
        mBox8.addTextChangedListener(new Watcher("/box8"));
        mBox9.addTextChangedListener(new Watcher("/box9"));
    }

    /**
     * Custom TextWatcher class that takes the DatabaseReference path of child in constructor
     * making this watcher re-usable for all 9 EditTexts!
     */
    private class Watcher implements TextWatcher {
        private String refPath;

        public Watcher(String refPath) {
            this.refPath = refPath;
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
