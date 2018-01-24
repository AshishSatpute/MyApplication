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
public class LoginFragment extends Fragment {

    public static final String TAG = LoginFragment.class.getSimpleName();

    public static Fragment getInstance() {
        Log.i(TAG, "getInstance: ");
        return new LoginFragment();
    }

    public LoginFragment() {
        // Required empty public constructor
        Log.i(TAG, "LoginFragment: ");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        rootView.findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: ");
                ((MainActivity) getActivity()).loadFragment(DashBoardFragment.getInstance());
            }
        });

        return rootView;
    }

}
