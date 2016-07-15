package com.test.snug;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by LangstonSmith on 7/9/16.
 */
public class CartCustomCursorAdapter extends CursorAdapter {
    private LayoutInflater mInflater;

    private String LOG_TAG = "Bob";

    public CartCustomCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        ImageView imageViewimageOfCartHat = (ImageView) view.findViewById(R.id.image_of_hat_in_cart);
        TextView textViewnameOfCartHat = (TextView) view.findViewById(R.id.textview_name_of_hat_in_cart);
        ImageButton deleteButtonForCartHat = (ImageButton) view.findViewById(R.id.imagebutton_to_remove_hat_from_cart);


        // Extract properties from cursor

        int imageOfCartHat = (cursor.getInt(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_PICTUREID)));
        String nameOfCartHat = (cursor.getString(cursor.getColumnIndex(HatsSQLiteOpenHelper.HAT_COLUMN_HATNAME)));

        // Populate fields with extracted properties

        imageViewimageOfCartHat.setImageResource(imageOfCartHat);

        textViewnameOfCartHat.setText(nameOfCartHat);


        //FAB for X button which deletes single hat from cart

        deleteButtonForCartHat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("e", "deleteButtonForCartHat clicked");

                Context context = view.getContext();

                HatsSQLiteOpenHelper db = new HatsSQLiteOpenHelper(context);

                Cursor cursorForDeletingHat = db.getALLHatsFromCART();

                View parentRow = (View) view.getParent();

                ListView listView = (ListView) parentRow.getParent();

                final int finalCartListViewPosition = listView.getPositionForView(parentRow);


                db.deleteSpecificHatFromCart(cursorForDeletingHat.getInt(finalCartListViewPosition));



                cursorForDeletingHat.close();

            }
        });

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.single_hat_line_in_cart, parent, false);
    }

}
