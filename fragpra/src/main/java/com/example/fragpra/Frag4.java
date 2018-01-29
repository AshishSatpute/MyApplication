package com.example.fragpra;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static com.example.fragpra.SecondActivity.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag4 extends Fragment {

    public static Fragment getInstance() {
        return new Frag4();
    }

    public Frag4() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.frag4, container, false);
        rootView.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplication(), SecondActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
