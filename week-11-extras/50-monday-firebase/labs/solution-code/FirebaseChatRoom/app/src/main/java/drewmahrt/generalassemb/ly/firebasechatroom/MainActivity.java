package drewmahrt.generalassemb.ly.firebasechatroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView mChat;
    EditText mChatMessage;
    Button mSendButton;

    Firebase mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChat = (ListView)findViewById(R.id.chat);
        mChatMessage = (EditText)findViewById(R.id.chat_message);
        mSendButton = (Button)findViewById(R.id.send_button);

        final String username = generateUserName();

        setTitle("Chatting as "+username);

        mRef = new Firebase("https://drewchat.firebaseio.com/messages");

        FirebaseListAdapter<Message> adapter = new FirebaseListAdapter<Message>(this,Message.class,android.R.layout.simple_list_item_2,mRef) {
            @Override
            protected void populateView(View view, Message message, int i) {
                TextView sender = (TextView)view.findViewById(android.R.id.text1);
                TextView chatMessage = (TextView)view.findViewById(android.R.id.text2);

                sender.setText(message.getSender());
                chatMessage.setText(message.getMessage());
            }
        };

        mChat.setAdapter(adapter);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.push().setValue(new Message(username,mChatMessage.getText().toString()));
                mChatMessage.setText("");
            }
        });
    }

    private String generateUserName(){
        Random r = new Random(System.currentTimeMillis());
        return "User"+r.nextInt(1000);
    }
}
