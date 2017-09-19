package com.example.ashish.playlist;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songsList();
    }

    private void songsList() {
        final List<String> dataSet = new ArrayList<>();
        dataSet.add("Android Twerk");
        dataSet.add("Animal Martin");
        dataSet.add("Apocalypse REMIX");
        dataSet.add("Army Wake Up");
        dataSet.add("ATB - Summer 2015");
        dataSet.add("IPhone Apple Ring");
        dataSet.add("Android Twerk");
        dataSet.add("Animal Martin");
        dataSet.add("Apocalypse REMIX");
        dataSet.add("Army Wake Up");
        dataSet.add("ATB - Summer 2015");
        dataSet.add("IPhone Apple Ring");
        dataSet.add("Android Twerk");
        dataSet.add("Animal Martin");
        dataSet.add("Apocalypse REMIX");
        dataSet.add("Army Wake Up");
        dataSet.add("ATB - Summer 2015");
        dataSet.add("IPhone Apple Ring");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSet);
        ((ListView) findViewById(R.id.list)).setAdapter(adapter);
        final ListView listView = findViewById(R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Intent intent = new Intent(getApplicationContext(),Play.class);
                String songs_Names = (listView.getItemAtPosition(pos).toString());

                intent.putExtra("poss",pos);
               intent.putExtra("songs_Names",songs_Names);
                startActivity(intent);
            }
        });

    }
}
