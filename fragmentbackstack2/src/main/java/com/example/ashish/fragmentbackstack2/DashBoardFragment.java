package com.example.ashish.fragmentbackstack2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {


    public static Fragment getInstance(){
        return new DashBoardFragment();
    }

    public DashBoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_dash_board, container, false);

        rootView.findViewById(R.id.btnNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // must correct  ((MainActivity)getActivity()).loadFragment(NotificationFragment.getInstance());
            }
        });
        return rootView;
    }
}
