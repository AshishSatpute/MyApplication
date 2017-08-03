package com.example.ashish.gridview;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
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
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Android"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Windows"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Apple"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Rim"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"more...."));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Android"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Android"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Android"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Android"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Android"));
        items.add(new MyItem(R.drawable.ic_laptop_windows_black_24dp,"Android"));



        MyAdapter adapter = new MyAdapter(this,items);
        ((GridView)findViewById(R.id.grid_view)).setAdapter(adapter);
        final GridView gridView = findViewById(R.id.grid_view);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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

        ((GridView)findViewById(R.id.grid_view)).setAdapter(adapter);




    }

}
