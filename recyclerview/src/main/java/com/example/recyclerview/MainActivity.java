package com.example.recyclerview;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String URL_DATA = "https://api.androidhive.info/volley/person_object.json";
    public static final String TAG = MainActivity.class.getCanonicalName();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = context;
        Log.i(TAG, "onCreate: ");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        listItems = new ArrayList<>();

//        loadData();

        for (int i = -1; i <= 9; i++) {
            ListItem listItem = new ListItem(
                    "Name" + (i + 1),
                    "Load Name......" + (i + 1)
            );
            listItems.add(listItem);
        }

        adapter = new MyAdapter(listItems, context);
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        Log.i(TAG, "loadData: ");

        StringRequest stringRequest = new StringRequest(Request.Method.GET
                , URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "onResponse: ");
                        Gson gson = new Gson();

                        List<ListItem> listItems = gson.fromJson(response,new TypeToken<List<String>>(){
                        }.getType());

                        adapter = new MyAdapter(listItems,MainActivity.this.getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i(TAG, "onErrorResponse: ");
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
