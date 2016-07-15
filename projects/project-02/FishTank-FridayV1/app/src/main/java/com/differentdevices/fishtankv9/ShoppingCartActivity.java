package com.differentdevices.fishtankv9;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {


        private List<ProductSingleton> CartList;
        private ProductAdapter mProductAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_shopping_cart);

            CartList = ShoppingCartHelper.getCart();
            Log.d("shopping cart",""+CartList.size());
            // Make sure to clear the selections
            for(int i=0; i<CartList.size(); i++) {
                CartList.get(i).selected = false;
            }

            // Create the list
            final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
            mProductAdapter = new ProductAdapter(CartList, getLayoutInflater(), true);
            listViewCatalog.setAdapter(mProductAdapter);

            listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {

                    ProductSingleton selectedProduct = CartList.get(position);
                    if(selectedProduct.selected == true)
                        selectedProduct.selected = false;
                    else
                        selectedProduct.selected = true;

                    mProductAdapter.notifyDataSetInvalidated();

                }
            });

            Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);
            removeButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Loop through and remove all the products that are selected
                    // Loop backwards so that the remove works correctly
                    for(int i=CartList.size()-1; i>=0; i--) {

                        if(CartList.get(i).selected) {
                            CartList.remove(i);
                        }
                    }
                    mProductAdapter.notifyDataSetChanged();
                }
            });}}








