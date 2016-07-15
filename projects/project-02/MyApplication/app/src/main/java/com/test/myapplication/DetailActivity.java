package com.test.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    DataBaseHelper mHelper;
    TextView detailAlcName,detailAlcDes,detailAlcAbv,detailPrice;
    EditText quantityEdit;
    ImageView detailAlcImage;
    Button buyButton;
    Cart mCart;
    Alcohol mAlcohol;
    int mQty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);
        mHelper = DataBaseHelper.getInstance(this);
        detailAlcName = (TextView)findViewById(R.id.dialog_alc_name);
        detailAlcAbv = (TextView)findViewById(R.id.dialog_alc_abv);
        detailAlcDes = (TextView)findViewById(R.id.dialog_alc_des);
        detailAlcImage = (ImageView)findViewById(R.id.dialog_alc_image);
        quantityEdit = (EditText)findViewById(R.id.dialog_quantity);
        buyButton = (Button)findViewById(R.id.dialog_buy_button);
        detailPrice = (TextView)findViewById(R.id.dialog_alc_price);

        Intent i = getIntent();
        mAlcohol = (Alcohol)i.getSerializableExtra("alc");
        detailAlcImage.setImageResource(mAlcohol.getImage());
        detailAlcName.setText(mAlcohol.getAlcName());
        detailAlcAbv.setText(String.valueOf(mAlcohol.getAbv())+"%ABV");
        detailAlcDes.setText(mAlcohol.getDescription());
        detailPrice.setText("$"+String.valueOf(mAlcohol.getAlcPrice()));

        //set button to false so user can't input empty quantity
        buyButton.setEnabled(false);
        //setenabled to true if numbers are inputed(already set numbers only in xml)
        quantityEdit.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    buyButton.setEnabled(false);
                } else {
                    buyButton.setEnabled(true);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        //adds item to shopping cart, can also select quantity here
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQty= Integer.parseInt(quantityEdit.getText().toString());
                mCart = new Cart(mQty,mAlcohol.getAlcId());
                mHelper.addCart(mCart);
                Toast.makeText(getBaseContext(), "Added item to cart" , Toast.LENGTH_SHORT ).show();
                finish();

            }
        });



    }
}
