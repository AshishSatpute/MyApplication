
package com.example.recyclerdailogprogress;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String URL_DATA = "https://api.androidhive.info/volley/person_object.json";
    public static final String TAG = MainActivity.class.getCanonicalName();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    public Context context;

    public ProgressDialog progressDialog;

    ProgressBar pb;

    Button button;
    ImageView imageView;

    @SuppressLint("WrongViewCast")
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

        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTask myTask = new MyTask();
                myTask.execute();
            }
        });

//        loadData();

        for (int i = -1; i <= 9; i++) {
            ListItem listItem = new ListItem(
                    "name" + (i + 1),
                    "email" + (i + 1),
                    "Load image......" + (R.id.iv)
            );
            listItems.add(listItem);
        }


    }

    private void loadData() {
        Log.i(TAG, "loadData: ");

        /*StringRequest stringRequest = new StringRequest(Request.Method.GET
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
        requestQueue.add(stringRequest);*/
    }


    class MyTask extends AsyncTask<Integer/*params*/, String/*Progress*/, Boolean/*Result*/> {
        public final String TAG = MyTask.class.getSimpleName();
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            //Ui thread
            super.onPreExecute();

            adapter = new MyAdapter(listItems, context);
            recyclerView.setAdapter(adapter);

            Log.i(TAG, "onPreExecute: ");

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMax(100);
            progressDialog.setView(recyclerView);
            progressDialog.setMessage("Its loading....");
            progressDialog.show();
        }

        @Override
        protected Boolean/*Result*/ doInBackground(Integer... params/*Params*/) {
            Log.i(TAG, "doInBackground: ");
            // worker thread
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Log.i(TAG, "onPostExecute: ");
            progressDialog.dismiss();

            //ui thread
        }

        @Override
        protected void onProgressUpdate(String... values/*Progress*/) {
            super.onProgressUpdate(values);
            Log.i(TAG, "onProgressUpdate: ");
            //ui thread
        }
    }
}