package com.example.ashish.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Note extends AppCompatActivity {

    FileOutputStream fileOutputStream;
    EditText note_title;
    String edit_note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        note_title = findViewById(R.id.note_title);
    }

    public void write(View view) {
        edit_note = note_title.getText().toString();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(edit_note, MODE_PRIVATE);
            fileOutputStream.write(edit_note.getBytes());
            fileOutputStream.close();
            note_title.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i("@Ashish", "write data succes");
    }


    public void read(View view) {
        StringBuilder builder = new StringBuilder();
        try {
            FileInputStream fis = openFileInput(edit_note);
            while (true) {
                int ch = fis.read();
                if (ch == -1) break;
                else builder.append((char) ch);
                note_title.setText(edit_note);
                Log.i("@Ashish", "looping");}

        } catch (IOException e) {
            e.printStackTrace();
            Log.i("@Ashish", "Data created " + builder.toString());}

        simpleListView();
    }


    private void simpleListView() {
        List<String> dataSet = new ArrayList<>();
        File file = getFilesDir();
        Log.i("@Ashish", "Internal Storage - " + file.getAbsolutePath());
        String[] intStrg = fileList();
        for (String fl : intStrg) {
            Log.i("@Ashish", "File " + fl);
            dataSet.add("" + fl);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataSet);
            ((ListView) findViewById(R.id.listView)).setAdapter(adapter);
            final ListView listView = findViewById(R.id.listView);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                    Intent intent = new Intent(getApplicationContext(), Edit_Activity.class);
                    //intent.putExtra("poss", pos);
                    intent.putExtra("loc",edit_note);
                    startActivityForResult(intent, 1234);
                    Log.i("@Ashish", "call succ");
                }
            });
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("@Ashish", "onActivityResult call");
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1234 && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("data");
            String loc= data.getStringExtra("loc");
            Log.i("@Ashish","loc:"+loc);
            Log.i("@Ashish", "succcccccc");
            try {
                fileOutputStream = openFileOutput(name, MODE_PRIVATE);
                fileOutputStream.write(name.getBytes());
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            deleteFile(loc);

            Log.i("@Ashish", "onActivityResult loop");

            simpleListView();
        }
    }
}