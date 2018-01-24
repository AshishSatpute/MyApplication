package com.example.fragpra;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag10 extends Fragment {

    public static Fragment getInstance() {
        return new Frag10();
    }

    public Frag10() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.frag10, container, false);
        rootView.findViewById(R.id.button9);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).loadFragment(Frag10.getInstance());
            }
        });

        return rootView;
    }
}
