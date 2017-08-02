package com.example.ashish.listview;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //simpleListView();
        complexList();
    }

    private void complexList() {
     List<MyItem> items  = new ArrayList<>();
     items.add(new MyItem(R.drawable.ic_launcher_background,"Android"));
        items.add(new MyItem(R.drawable.ic_launcher_background,"Windows"));
        items.add(new MyItem(R.drawable.ic_launcher_background,"Apple"));
        items.add(new MyItem(R.drawable.ic_launcher_background,"Rim"));
        items.add(new MyItem(R.drawable.ic_launcher_background,"more...."));

        MyAdapter adapter = new MyAdapter(this,items);
        ((ListView)findViewById(R.id.mobile)).setAdapter(adapter);

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
