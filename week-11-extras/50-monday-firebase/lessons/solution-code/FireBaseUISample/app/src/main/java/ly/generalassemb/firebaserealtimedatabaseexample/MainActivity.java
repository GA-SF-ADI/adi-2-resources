package ly.generalassemb.firebaserealtimedatabaseexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference chatRef;

    private ListView listView;
    private EditText userName, userMsg;
    private Button sendButton;

    private ArrayList<String> chatMessages;
    private FirebaseListAdapter<String> messageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get instance of database singleton
        firebaseDatabase = FirebaseDatabase.getInstance();
        chatRef = firebaseDatabase.getReference("chat-room");

        chatMessages = new ArrayList<>();

        setupViews();
        setupChat();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        messageAdapter.cleanup();
    }

    private void setupChat(){
        messageAdapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_expandable_list_item_1, chatRef) {
            @Override
            protected void populateView(View v, String model, int position) {
                ((TextView) v).setText(model);
            }
        };
        listView.setAdapter(messageAdapter);
    }

    private void setupViews(){
        userMsg = (EditText) findViewById(R.id.user_msg);
        userName = (EditText) findViewById(R.id.user_name);
        sendButton = (Button) findViewById(R.id.send_button);
        listView = (ListView) findViewById(R.id.list_view);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = userName.getText().toString();
                String msg = userMsg.getText().toString();

                String bundle = user + " - " + msg;
                chatRef.push().setValue(bundle);

                userMsg.setText("");
            }
        });
    }

}
