package drewmahrt.generalassemb.ly.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextView mCurrentText;
    EditText mNewText;
    Button mSubmitButton;
    ListView mListView;

    Firebase mFirebaseRootRef;

    ArrayList<String> mMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentText = (TextView) findViewById(R.id.current_text);
        mNewText = (EditText)findViewById(R.id.edit_text);
        mSubmitButton = (Button)findViewById(R.id.submit_button);
        mListView = (ListView)findViewById(R.id.list);

        mFirebaseRootRef = new Firebase("https://exampleappdrew.firebaseio.com");

        final Firebase firebaseCurrentTextRef = mFirebaseRootRef.child("currentText");

        Firebase firebaseMessageRef = mFirebaseRootRef.child("messages");

        mMessages = new ArrayList<>();

        firebaseCurrentTextRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                mCurrentText.setText("Latest Text: " + text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseCurrentTextRef.setValue(mNewText.getText().toString());
            }
        });

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mMessages);
        mListView.setAdapter(adapter);

        firebaseMessageRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String message = dataSnapshot.getValue(String.class);
                mMessages.add(message);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
