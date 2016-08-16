package com.test.firebaseprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference chatRef;
    private EditText editText;
    private ListView listView;
    private Button button;
    private Message mMessage;
    private int userID;
    private String userName;
    private FirebaseListAdapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userID = (int)(Math.random() * 1000);

        userName = "User"+userID;

        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.list_view);

        firebaseDatabase = FirebaseDatabase.getInstance();
        chatRef = firebaseDatabase.getReference("chatroom");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMessage = new Message(userName,editText.getText().toString(),00000);
                chatRef.push().setValue(mMessage);
            }
        });

        messageAdapter = new FirebaseListAdapter<Message>(this, Message.class, android.R.layout.simple_expandable_list_item_1, chatRef) {
            @Override
            protected void populateView(View v, Message model, int position) {
                String text = model.getUser()+" "+model.getMsg();

                ((TextView)v).setText(text);

            }
        };

        listView.setAdapter(messageAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        messageAdapter.cleanup();
    }
}
