package com.ashish.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.ashish.sqlitedemo.AddDataSource.COLUMN_PASSWORD;
import static com.ashish.sqlitedemo.AddDataSource.COLUMN_USERNAME;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button,button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.pass);
        button  =  findViewById(R.id.save);
        button1 = findViewById(R.id.btnRead);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read();
            }
        });

    }


    private void doLogin() {
        DataModel dataModel = new DataModel();
        dataModel.setName(editText1.getText().toString());
        dataModel.setPass(editText2.getText().toString());

        AddDataSource addDataSource = new AddDataSource(getApplicationContext());
        addDataSource.insertDetails(dataModel);

    }

    private void read() {

        AddDataSource addDataSource = new AddDataSource(this);
        SQLiteDatabase database = addDataSource.getReadableDatabase();

        Cursor cursor = addDataSource.read(database);

        String info = "";
        while (cursor.moveToNext()) {
            String name= cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
            String pass= cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));

            info = info+"\n\n"+name +pass;
            Log.i("Ashish", "read: "+info);
        }
    }
}
