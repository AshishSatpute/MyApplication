package com.example.fragpra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Frag6 extends Fragment {

    public static Fragment getInstance() {
        return new Frag6();
    }

    public Frag6() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.frag6, container, false);
        rootView.findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).loadFragment(Frag7.getInstance());
            }
        });

        return rootView;
    }
}
