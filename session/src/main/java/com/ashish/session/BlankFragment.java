package com.ashish.session;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BlankFragment extends Fragment {



    public BlankFragment() {
        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final   View rootView = inflater.inflate(R.layout.fragment_blank, container, false);


        rootView.findViewById(R.id.btnlogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDestroyView();
                onDestroy();
            }
        });




        return rootView;
        }

}
