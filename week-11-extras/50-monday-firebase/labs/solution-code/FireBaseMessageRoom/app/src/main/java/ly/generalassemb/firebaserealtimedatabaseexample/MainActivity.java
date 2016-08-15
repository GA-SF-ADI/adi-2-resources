package ly.generalassemb.firebaserealtimedatabaseexample;

import android.graphics.Color;
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
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference chatRef;

    private ListView listView;
    private EditText userMsg;
    private Button sendButton;
    private String userName;

    private ArrayList<String> chatMessages;
    private FirebaseListAdapter<Message> messageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get instance of database singleton
        firebaseDatabase = FirebaseDatabase.getInstance();
        chatRef = firebaseDatabase.getReference("message-room");

        userName = generateUserName();
        setTitle(userName); // Set title of app to user's name

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
        messageAdapter = new FirebaseListAdapter<Message>(this, Message.class, android.R.layout.simple_expandable_list_item_2, chatRef) {
            @Override
            protected void populateView(View v, Message model, int position) {
                TextView sender = (TextView) v.findViewById(android.R.id.text1);
                TextView chatMessage = (TextView) v.findViewById(android.R.id.text2);

                chatMessage.setText(model.getMsg());
                sender.setText(model.getUser());

                if (userName.equals(model.getUser())){
                    // this user always red
                    sender.setTextColor(Color.RED);
                } else {
                    // other users are green
                    sender.setTextColor(Color.GREEN);
                }
            }
        };
        listView.setAdapter(messageAdapter);
    }

    private void setupViews(){
        userMsg = (EditText) findViewById(R.id.user_msg);
        sendButton = (Button) findViewById(R.id.send_button);
        listView = (ListView) findViewById(R.id.list_view);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = userMsg.getText().toString();
                chatRef.push().setValue(new Message(userName, msg));

                userMsg.setText("");
            }
        });
    }

    private String generateUserName(){
        Random r = new Random(System.currentTimeMillis());
        return "User"+r.nextInt(1000);
    }
    
}
