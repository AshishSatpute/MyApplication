package com.example.interactivecommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnGoBack(View view) {
        Class cls = ImageActivity.class;
        Bundle bundle = new Bundle();
        bundle.putString("imgNm",
                ((EditText) (findViewById(R.id.edtext_image_name))).getText().toString());
        Intent intent = new Intent(this, cls);
        intent.putExtras(bundle);
        startActivityForResult(intent, 4546);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4546 && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            ((TextView) findViewById(R.id.tv_information)).setText(name);
        }
    }
}