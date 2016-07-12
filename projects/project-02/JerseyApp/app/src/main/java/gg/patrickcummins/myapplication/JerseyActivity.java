package gg.patrickcummins.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static gg.patrickcummins.myapplication.R.drawable.raiders;
import static gg.patrickcummins.myapplication.R.drawable.warriors;
import static gg.patrickcummins.myapplication.R.id.addToCartButton;

public class JerseyActivity extends AppCompatActivity {
    TextView jerseyColor1, jerseyColor2, jerseyColor3, nameTextView, numberTextView, priceTextView;
    ImageView jerseyImageView;
    String currentPlayer, team;
    int currentPlayerNumber, currentImage;
    Button addToCart;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jersey);

        getIntentExtras();


        setViews();
        setViewText();
        setUpJerseys();
        setAddToCartClick();
        setFabOnClick();
    }

    private void setFabOnClick() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JerseyActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setAddToCartClick() {
        addToCart.setOnClickListener(new View.OnClickListener() {
            DatabaseHelper helper = DatabaseHelper.getInstance(JerseyActivity.this);
            @Override
            public void onClick(View v) {
                double price = 0;
                if (team.equals("warriors")) {
                    price = 69.99;
                } else if (team.equals("raiders")) {
                    price = 99.99;
                } else {
                    price = 49.99;
                }
                CartItem cartItem = (new CartItem(currentPlayer, "blue", currentImage, price));
                helper.insertCartRow(cartItem);

            }
        });
    }


    private void getIntentExtras() {
        Intent currentIntent = getIntent();
        currentPlayer = currentIntent.getStringExtra("playerName");
        currentPlayerNumber = currentIntent.getIntExtra("playerNumber", -1);
        team = currentIntent.getStringExtra("playerTeam");
    }

    private void setViewText() {
        nameTextView.setText(currentPlayer);
        numberTextView.setText("#" + currentPlayerNumber);
        if (team.equals("warriors")) {
            priceTextView.setText("Price: $69.99");
        } else if (team.equals("raiders")) {
            priceTextView.setText("Price: $99.99");
        } else {
            priceTextView.setText("Price: $49.99");
        }


    }

    //TODO:Fix Color Of Box for Mack Pro Bowl
    private void setUpJerseys() {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(JerseyActivity.this);
        ArrayList<Integer> playerJerseysList = databaseHelper.getPlayerJerseysList(currentPlayer);
        if (playerJerseysList.get(0) != -1) {
            jerseyImageView.setImageResource(playerJerseysList.get(0));
            currentImage = playerJerseysList.get(0);
            setColorOnClick(jerseyColor1, playerJerseysList.get(0));
        } else {
            jerseyImageView.setImageResource(playerJerseysList.get(1));
            currentImage = playerJerseysList.get(1);
            jerseyColor1.setVisibility(View.GONE);
        }
        setColorOnClick(jerseyColor2, playerJerseysList.get(1));
        setColorOnClick(jerseyColor3, playerJerseysList.get(2));

    }

    private void setColorOnClick(TextView textView, final int jerseyDrawable) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jerseyImageView.setImageResource(jerseyDrawable);
                currentImage = jerseyDrawable;
            }
        });
    }

    private void setViews() {
        jerseyColor1 = (TextView) findViewById(R.id.jersey1);
        jerseyColor2 = (TextView) findViewById(R.id.jersey2);
        jerseyColor3 = (TextView) findViewById(R.id.jersey3);
        jerseyImageView = (ImageView) findViewById(R.id.jerseyImageView);
        nameTextView = (TextView) findViewById(R.id.playerNameTextView);
        numberTextView = (TextView) findViewById(R.id.playerNumberTextView);
        priceTextView = (TextView) findViewById(R.id.priceTextView);
        addToCart = (Button) findViewById(addToCartButton);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.cartFab);
    }
}
