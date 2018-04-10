package com.melayer.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner =
                findViewById(R.id.spinner);

        ArrayList<String> arrayList =
                new ArrayList<>();

        arrayList.add("HERO HONDA");
        arrayList.add("BAJAJ");
        arrayList.add("PULSER");

        arrayAdapter = ArrayAdapter
                .createFromResource(
                        this,arrayList,R.layout
                        .support_simple_spinner_dropdown_item
                );
    }
}