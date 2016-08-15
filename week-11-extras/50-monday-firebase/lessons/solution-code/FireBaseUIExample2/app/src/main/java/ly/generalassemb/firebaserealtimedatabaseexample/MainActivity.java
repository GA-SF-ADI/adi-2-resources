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

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference msgRef;

    private EditText userName, userMsg;
    private Button addStudentButton;
    private ListView studentList;

    private FirebaseListAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get instance of database singleton
        firebaseDatabase = FirebaseDatabase.getInstance();
        msgRef = firebaseDatabase.getReference("chat-room");

        setupViews();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        adapter.cleanup();
    }


    private void setupViews(){
        userName = (EditText) findViewById(R.id.student_name);
        userMsg = (EditText) findViewById(R.id.student_last_name);
        addStudentButton = (Button) findViewById(R.id.add_button);
        studentList = (ListView) findViewById(R.id.list_view);

        addStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                String lastName = userMsg.getText().toString();
                userMsg.setText("");

                // Push chat message to DB with random generated key
                msgRef.push().setValue(name + " - " + lastName);
            }
        });

        setupListView();
    }

    private void setupListView(){
        adapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, msgRef) {
            @Override
            protected void populateView(View v, String model, int position) {
                ((TextView) v).setText(model);
            }
        };
        studentList.setAdapter(adapter);
    }
}
