package com.ashish.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.pass);

        button  =  findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
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
}
