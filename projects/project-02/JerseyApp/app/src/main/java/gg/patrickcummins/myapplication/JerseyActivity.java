package gg.patrickcummins.myapplication;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static gg.patrickcummins.myapplication.R.drawable.raiders;
import static gg.patrickcummins.myapplication.R.drawable.warriors;
import static gg.patrickcummins.myapplication.R.id.addToCartButton;
import static gg.patrickcummins.myapplication.R.id.extraSmallTextView;
import static gg.patrickcummins.myapplication.R.id.smallTextView;

public class JerseyActivity extends AppCompatActivity {
    private TextView jerseyColor1, jerseyColor2, jerseyColor3, nameTextView, numberTextView, priceTextView, sizeExtraSmallTextView, sizeSmallTextView, sizeMediumTextView, sizeLargeTextView, sizeExtraLargeTextView;
    private EditText quantityEditText;
    private ImageView jerseyImageView;
    private String currentPlayer, team, size;
    private String currentJerseyColor;
    double singleprice, price;
    int quantity;
    private int currentPlayerNumber, currentImage;
    private Button addToCart;
    private FloatingActionButton floatingActionButton;

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
        setOnClickSize();
        setEditTextChangeListener();
    }

    private void setEditTextChangeListener() {
        quantityEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals("")) {
                    quantity = 0;
                    priceTextView.setText("Price: $00.00");
                } else {
                    quantity = Integer.parseInt(s.toString());
                    price = singleprice * quantity;
                    priceTextView.setText("Price: $" + Math.round(price * 100.00) / 100.00);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void setOnClickSize() {
        size = "";
        sizeExtraSmallTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedSize(sizeExtraSmallTextView);
                size = "Extra Small";
            }
        });
        sizeSmallTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedSize(sizeSmallTextView);
                size = "Small";
            }
        });
        sizeMediumTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedSize(sizeMediumTextView);
                size = "Medium";
            }
        });
        sizeLargeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedSize(sizeLargeTextView);
                size = "Large";
            }
        });
        sizeExtraLargeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectedSize(sizeExtraLargeTextView);
                size = "Extra Large";
            }
        });

    }

    private void setSelectedSize(TextView sizeTextView) {
        if (!size.equals("")) {
            if (size.equals("Extra Small")) {
                setUnselectedSize(sizeExtraSmallTextView);
            } else if (size.equals("Small")) {
                setUnselectedSize(sizeSmallTextView);
            } else if (size.equals("Medium")) {
                setUnselectedSize(sizeMediumTextView);
            } else if (size.equals("Large")) {
                setUnselectedSize(sizeLargeTextView);
            } else if (size.equals("Extra Large")) {
                setUnselectedSize(sizeExtraLargeTextView);
            }
        }
        sizeTextView.setBackgroundColor(ContextCompat.getColor(JerseyActivity.this, R.color.raiderPrimaryDark));
        sizeTextView.setTextColor(ContextCompat.getColor(JerseyActivity.this, R.color.raiderAccent));
    }

    private void setUnselectedSize(TextView sizeTextView) {
        sizeTextView.setBackgroundColor(ContextCompat.getColor(JerseyActivity.this, R.color.raiderAccent));
        sizeTextView.setTextColor(ContextCompat.getColor(JerseyActivity.this, R.color.raiderPrimaryDark));
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
                if (quantity== 0 || size.equals("") ){
                    Toast.makeText(JerseyActivity.this, "Make Sure You Input a Size and Quantity", Toast.LENGTH_SHORT).show();
                    if (quantity == 0){
                        quantityEditText.setError("Please Enter a Quantity");
                    }
                }else {
                    CartItem cartItem = (new CartItem(currentPlayer, currentJerseyColor, currentImage, price, quantity, size));
                    helper.insertCartRow(cartItem);
                    Toast.makeText(JerseyActivity.this, "Item Added To Cart!", Toast.LENGTH_SHORT).show();
                    finish();
                }
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
            singleprice = 69.99;
        } else if (team.equals("raiders")) {
            singleprice = 99.99;
        } else {
            singleprice = 49.99;
        }
        priceTextView.setText("Price: $" + singleprice);

    }

    //TODO: Fix Pro Bowl Jerseys
    private void setUpJerseys() {
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(JerseyActivity.this);
        ArrayList<Integer> playerJerseysList = databaseHelper.getPlayerJerseysList(currentPlayer);
        if (playerJerseysList.get(0) != -1) {
            jerseyImageView.setImageResource(playerJerseysList.get(0));
            currentImage = playerJerseysList.get(0);
            currentJerseyColor = "Blue";
            setColorOnClick(jerseyColor1, playerJerseysList.get(0), "Blue");
        } else {
            jerseyImageView.setImageResource(playerJerseysList.get(1));
            currentImage = playerJerseysList.get(1);
            currentJerseyColor = "White";
            jerseyColor1.setVisibility(View.GONE);
        }
        setColorOnClick(jerseyColor2, playerJerseysList.get(1), "White");
        setColorOnClick(jerseyColor3, playerJerseysList.get(2), "Black");

    }

    private void setColorOnClick(final TextView textView, final int jerseyDrawable, final String color) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jerseyImageView.setImageResource(jerseyDrawable);
                currentImage = jerseyDrawable;
                currentJerseyColor = color;
                jerseyColor1.setText("");
                jerseyColor2.setText("");
                jerseyColor3.setText("");
                textView.setText("X");
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
        sizeExtraSmallTextView = (TextView) findViewById(R.id.extraSmallTextView);
        sizeSmallTextView = (TextView) findViewById(R.id.smallTextView);
        sizeMediumTextView = (TextView) findViewById(R.id.mediumTextView);
        sizeLargeTextView = (TextView) findViewById(R.id.largeTextView);
        sizeExtraLargeTextView = (TextView) findViewById(R.id.extraLargeTextView);
        quantityEditText = (EditText) findViewById(R.id.quantityEditText);
        quantity=0;
    }
}
