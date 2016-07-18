package com.test.project2navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//main fragment that user can return to... serves as the home screen
public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        final Button mainButton = (Button) rootView.findViewById(R.id.main_button_add_something);
        final ImageView second = (ImageView) rootView.findViewById(R.id.image_view);
        final ImageButton jewelButton = (ImageButton) rootView.findViewById(R.id.jewelryboximage);

        jewelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutUsFragment fragment = new AboutUsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), SecondActivity.class);
                startActivity(intent);
                mainButton.setBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));

            }
        });

        return rootView;
    }
}
