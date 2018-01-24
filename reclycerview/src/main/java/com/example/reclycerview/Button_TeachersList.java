package com.example.reclycerview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashish on 15/1/18.
 */

public class Button_TeachersList extends AppCompatActivity {

    public static final String URL_DATA = "http://192.168.1.34:8484/management/user/getListUser";
    public static final String TAG = Button_TeachersList.class.getCanonicalName();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Context context;
    private List<ListTeacher> listTeachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__teachers_list);
        this.context = context;
        Log.i(TAG, "onCreate:");

        recyclerView = findViewById(R.id.recyclerViewTeacher);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listTeachers = new ArrayList<>();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTeacherList();
    }

    private void loadTeacherList() {
        Log.i(TAG, "loadTeacherList:");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Log.i(TAG, "res " + response);
                List<String> listTeachers = gson.fromJson(response, new TypeToken<List<String>>() {
                }.getType());
                if (listTeachers != null) {
                    adapter = new AdapterTeacherList(listTeachers, Button_TeachersList.this.getApplicationContext());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getApplicationContext(), "List is Empty...!!!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "res " + error);
                Toast.makeText(getApplicationContext(), "Check Your Internet Connection" + error, Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected:");
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}