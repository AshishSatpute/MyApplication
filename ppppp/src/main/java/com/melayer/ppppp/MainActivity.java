package com.melayer.ppppp;

import android.os.PersistableBundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    Chronometer chronometer;
    private long runningTime;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);


        if(savedInstanceState != null){
            chronometer.setBase(savedInstanceState.getLong("runningTime"));
            chronometer.start();
        }


        /*runningTime = SystemClock.elapsedRealtime()-chronometer.getBase();*/


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long time = SystemClock.elapsedRealtime()-chronometer.getBase();
                Log.i(TAG, "onClick: "+time);
            }
        });
        chronometer = findViewById(R.id.chronometer);

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometerChanged) {
                chronometer = chronometerChanged;
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putLong("runningTime",chronometer.getBase());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getLong("runningTime");

    }

    public void startStopChronometer(View view) {
        chronometer.start();
    }
}
