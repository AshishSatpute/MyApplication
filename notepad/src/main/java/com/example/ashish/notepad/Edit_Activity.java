package com.example.ashish.notepad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class Edit_Activity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_);
        editText=findViewById(R.id.edit);
        String data=editText.getText().toString();
    }

    public void Re_write(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("data",
                (editText).getText().toString());
        Intent intent = getIntent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
