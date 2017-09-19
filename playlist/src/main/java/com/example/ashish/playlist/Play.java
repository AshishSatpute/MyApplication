package com.example.ashish.playlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Play extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Intent intent = getIntent();

        String songs_name =intent.getStringExtra("songs_Names");
        Toast.makeText(this, ""+songs_name, Toast.LENGTH_SHORT).show();

       textView = findViewById(R.id.songs_name);
       textView.setText(songs_name);



    }

}
