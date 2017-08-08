package com.example.ashish.listview;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity{

    public static  ArrayList<MyItem> items;
    private LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //simpleListView();
        complexList();
    }

    private void complexList() {
        items  = new ArrayList<>();
        items.add(new MyItem(R.drawable.ic_badoo,"Badoo"));
        items.add(new MyItem(R.drawable.ic_behance,"Behance"));
        items.add(new MyItem(R.drawable.ic_deviantart,"Apple"));
        items.add(new MyItem(R.drawable.ic_deviantart,"Deviantart"));
        items.add(new MyItem(R.drawable.ic_facebook,"Facebook"));
        items.add(new MyItem(R.drawable.ic_flickr,"Flickr"));
        items.add(new MyItem(R.drawable.ic_google_plus,"Google"));
        items.add(new MyItem(R.drawable.ic_instagram,"Instragram"));
        items.add(new MyItem(R.drawable.ic_lastfm,"Lastfm"));
        items.add(new MyItem(R.drawable.ic_linkedin,"LinkedIn"));
        items.add(new MyItem(R.drawable.ic_pinterest,"Ponterest"));
        items.add(new MyItem(R.drawable.ic_soundcloud,"Soundcloud"));
        items.add(new MyItem(R.drawable.ic_swarm,"Swarm"));
        items.add(new MyItem(R.drawable.ic_tumblr,"Tumblr"));
        items.add(new MyItem(R.drawable.ic_twitter,"Twitter"));
        items.add(new MyItem(R.drawable.ic_vk,"Vk"));
        items.add(new MyItem(R.drawable.ic_badoo,"Badoo"));
        items.add(new MyItem(R.drawable.ic_behance,"Behance"));
        items.add(new MyItem(R.drawable.ic_deviantart,"Deviantart"));
        items.add(new MyItem(R.drawable.ic_facebook,"Facebook"));
        items.add(new MyItem(R.drawable.ic_flickr,"Flickr"));
        items.add(new MyItem(R.drawable.ic_google_plus,"Google"));
        items.add(new MyItem(R.drawable.ic_instagram,"Instragram"));
        items.add(new MyItem(R.drawable.ic_lastfm,"Lastfm"));
        items.add(new MyItem(R.drawable.ic_linkedin,"LinkedIn"));
        items.add(new MyItem(R.drawable.ic_pinterest,"Ponterest"));
        items.add(new MyItem(R.drawable.ic_soundcloud,"Soundcloud"));
        items.add(new MyItem(R.drawable.ic_swarm,"Swarm"));
        items.add(new MyItem(R.drawable.ic_tumblr,"Tumblr"));
        items.add(new MyItem(R.drawable.ic_twitter,"Twitter"));
        items.add(new MyItem(R.drawable.ic_vk,"Vk"));


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
