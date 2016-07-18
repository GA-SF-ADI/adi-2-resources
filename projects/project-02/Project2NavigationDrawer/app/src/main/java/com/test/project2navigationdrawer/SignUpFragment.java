package com.test.project2navigationdrawer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class SignUpFragment extends Fragment {
    Button signUp;


        public SignUpFragment() {
            // Required empty public constructor
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);

        final Button mainButton = (Button) rootView.findViewById(R.id.sign_up_button);

        return rootView;
    }

    }
