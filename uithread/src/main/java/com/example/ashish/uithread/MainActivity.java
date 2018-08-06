package com.example.ashish.uithread;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    TextView textView;
    private Chronometer chronometer;
    private boolean isStart;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContentView(R.layout.activity_main);

       chronometer = findViewById(R.id.chronometer);


         intent = new Intent(this,Service.class);

        /*chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                chronometer = chronometerChanged;
            }
        });*/


        textView = findViewById(R.id.abc);
    }










    public void startStopChronometer(View view) {


        if(isStart){
           chronometer.stop();
            isStart = false;
            ((Button)view).setText("Start");
            textView.setText(chronometer.getText());

        }else{
           // startService(intent);
            isStart = true;
            ((Button)view).setText("Stop");
        }


    }


}
