package com.example.kitty.ecommerceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class CommentActivity extends AppCompatActivity {

    Helper helper;

    RatingBar ratingBar;
    EditText comments;
    Button leaveCommentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        helper = Helper.getInstance(this);

        ratingBar = (RatingBar) findViewById(R.id.user_rating);
        comments = (EditText) findViewById(R.id.user_comment);
        leaveCommentButton = (Button) findViewById(R.id.user_comment_done_button);

        leaveCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCommentToDB(ratingBar.getNumStars(), comments.getText().toString());
            }
        });
    }

    public void addCommentToDB(int rating, String comment) {
        int i = 1; //need to add code to get extra from intent
        helper.addComment(i, comment, rating);
    }
}
