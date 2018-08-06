package com.example.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
    }

    public void show(View view) {
        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy :h:mm a");
        String dateString = sdf.format(date);
        tv.setText(dateString);

    }
}
