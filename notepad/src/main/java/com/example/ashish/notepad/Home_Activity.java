package com.example.ashish.notepad;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });




        CreateNote();
    }

    private void CreateNote() {
    }


    private void read() {

        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream fis = openFileInput("my.txt");
            while (true) {
                int ch = fis.read();
                if (ch == -1) break;
                else builder.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("@Ashish", "Data from internal " + builder.toString());



        moreMethods();
    }

    private void write() {

        try {
            FileOutputStream fos = openFileOutput("my.txt", MODE_PRIVATE);
            fos.write("this is codekul.com".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void moreMethods() {
        File file = getFilesDir();
        Log.i("@Ashish", "Internal Storage - " + file.getAbsolutePath());

        String []intStrg = fileList();
        for (String fl : intStrg) {
            Log.i("@Ashish", "File "+fl);
        }
    }


}
