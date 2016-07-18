package com.differentdevices.fishtankv9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sterlinggerritz on 7/14/16.
 */
public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_FISHNO = "extra_fish";
    public static final String ITEM_ID = "ITEM_ID";
    private ProductSingleton item;
    private TextView textViewName;
    private TextView textViewDescription;

    private RatingBar ratingBar;
    private Button shoppingCart;
    //private Button buttonBack;
    private Button buttonBuy;
    private ImageView imageViewImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);


        item = Dbase.getInstance(this).getProductById(getIntent().getIntExtra(ITEM_ID, -1));
        if (item == null) {
            throw new RuntimeException("Error: Invalid ID in Intent");
        }

        imageViewImage = (ImageView) findViewById(R.id.imageView);
        textViewName = (TextView) findViewById(R.id.textview_name);
        textViewDescription = (TextView) findViewById(R.id.textview_description);


        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        shoppingCart = (Button) findViewById(R.id.shopping_button);


        Picasso.with(this).load(item.getImage()).into(imageViewImage);

        textViewName.setText(item.getName());
        textViewDescription.setText(item.getDescription());

        CheckBox favorite = (CheckBox)findViewById(R.id.favorite);
        //favorite.setChecked(isFavorite);

        ratingBar.setRating(item.getRating());

        shoppingCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ProductSingleton> cart = ShoppingCartHelper.getCart();
                cart.add(item);
                Intent intent = new Intent(DetailsActivity.this, ShoppingCartActivity.class);
                startActivity(intent);
            }
        });


    }

}
