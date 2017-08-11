package com.example.ashish.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class BrnFrag extends Fragment {


    public BrnFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_brn, container, false);
        final RatingBar rating = rootView.findViewById(R.id.rating);
        rating.setMax(5);
        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(v > 1f)
                ((MainActivity)getActivity()).loadFrag(R.drawable.ic_badoo);
                else if(v > 2f)
                    ((MainActivity)getActivity()).loadFrag(R.drawable.ic_deviantart);
                else
                    ((MainActivity)getActivity()).loadFrag(R.drawable.ic_dribbble);
            }
        });
        return rootView;
    }
}
