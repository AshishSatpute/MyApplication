package com.example.ashish.fragmentsbackstack;


import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {

    public static final String TAG = DashBoardFragment.class.getSimpleName();
    public static Fragment getInstance(){
        Log.i(TAG, "getInstance: ");
        return new DashBoardFragment();
    }

    public DashBoardFragment() {
        Log.i(TAG, "DashBoardFragment: ");
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        final View rootView = inflater.inflate(R.layout.fragment_dash_board, container, false);

        rootView.findViewById(R.id.btnNotify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: ");
                ((MainActivity)getActivity()).loadFragment(NotificationFragment.getInstance());
            }
        });
        return rootView;
    }

}
