package com.example.ashish.compoundview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    }

    public void OnNext(View view){
        LinearLayout container = findViewById(R.id.llContainer);
        final  View inflaterView = inflater.inflate(R.layout.custom_item,container,true);
        CheckBox chk = inflaterView.findViewById(R.id.checkBox);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                TextView txt = inflaterView.findViewById(R.id.textView);
                txt.setText("Checked");
            }
            else {
                TextView txt = inflaterView.findViewById(R.id.textView);
                txt.setText("Hello");
            }
            }
        });

    }
}
