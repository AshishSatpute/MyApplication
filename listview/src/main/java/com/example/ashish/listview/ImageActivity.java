package com.example.ashish.listview;

import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.List;

public class ImageActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent intent = getIntent();
        int position = intent.getIntExtra("poss", 0);
        Log.e("ASHISH", "onCreate: " + position);

        MyItem myItem = MainActivity.items.get(position);
        ((ImageView) findViewById(R.id.imageView)).setImageResource(myItem.getImage());

    }
}
