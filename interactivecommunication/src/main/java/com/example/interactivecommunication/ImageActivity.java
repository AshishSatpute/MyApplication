package com.example.interactivecommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    private StringBuilder builder = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent resInt = getIntent();
        if(resInt != null) {
            Bundle bundle = resInt.getExtras();
            if(bundle != null) {
                String imgNm = bundle.getString("imgNm");
                if(imgNm.equals("a")) {
                    ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.ic_buses);
                }
                else if(imgNm.equals("b")){
                    ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.ic_cycle);
                }
                else {
                    ((ImageView)findViewById(R.id.imageView2)).setImageResource(R.drawable.ic_airport_shuttle_black_24dp);
                }
            }
        }

        ((CheckBox)findViewById(R.id.cband)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    builder.append("Android");
                }
            }
        });


        ((CheckBox)findViewById(R.id.cbapple)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    builder.append(" & Apple");
                }
            }
        });


        ((CheckBox)findViewById(R.id.cbwin)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    builder.append(" & Windows");
                }
            }
        });
    }

    public void OnGoBack(View view){
        Intent intent =  new Intent();
        intent.putExtra("name",builder.toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
