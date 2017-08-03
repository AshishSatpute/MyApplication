package com.example.ashish.listview;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    public static  ArrayList<MyItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //simpleListView();
        complexList();

    }

    private void complexList() {
        items  = new ArrayList<>();
        items.add(new MyItem(R.drawable.ic_android_black_24dp,"Android"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Windows"));
        items.add(new MyItem(R.drawable.ic_flight_black_24dp,"Apple"));
        items.add(new MyItem(R.drawable.ic_cloud_download_black_24dp,"Rim"));
        items.add(new MyItem(R.drawable.ic_phonelink_ring_black_24dp,"more...."));

        MyAdapter adapter = new MyAdapter(this,items);
        ((ListView)findViewById(R.id.mobile)).setAdapter(adapter);
        final ListView listView = findViewById(R.id.mobile);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
                intent.putExtra("poss",pos);
                startActivity(intent);


            }
        });
    }

    private void simpleListView() {
        List<String> dataSet = new ArrayList<>();
        dataSet.add("Android");
        dataSet.add("Apple");
        dataSet.add("Windows");
        dataSet.add("Rim");
        dataSet.add("Symbians");
        dataSet.add("bada");
        dataSet.add("many more..");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,dataSet);

        ((ListView)findViewById(R.id.mobile)).setAdapter(adapter);




    }

}
