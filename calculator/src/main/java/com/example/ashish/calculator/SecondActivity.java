package com.example.ashish.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    StringBuilder builder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent resInt = getIntent();
        if (resInt == null) {
            Bundle bundle = resInt.getExtras();
            if (bundle != null) {
                String text = bundle.getString("text");
                ((TextView) findViewById(R.id.showtext)).setText(text);
            }
        }
    }
}