package com.example.ashish.fragmentsbackstack;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {

    public static final String TAG = NotificationFragment.class.getSimpleName();
    public static NotificationFragment getInstance() {
        Log.i(TAG, "getInstance: ");
        return new NotificationFragment();
    }


    public NotificationFragment() {
        Log.i(TAG, "NotificationFragment: ");
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

}
