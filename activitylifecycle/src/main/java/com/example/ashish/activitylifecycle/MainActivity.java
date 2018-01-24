package com.example.ashish.activitylifecycle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");
        button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ");
                MyTask myTask = new MyTask();
                myTask.execute();
            }
        });
    }


    private class MyTask extends AsyncTask<Integer/*params*/, String/*Progress*/, Boolean/*Result*/> {
        public final String TAG = MyTask.class.getSimpleName();

        PD pd = new PD();
        @Override
        protected void onPreExecute() {
            //Ui thread
            super.onPreExecute();
            Log.i(TAG, "onPreExecute: ");
            /*progressDoalog = new ProgressDialog(MainActivity.this);
            // progressDoalog.setMax(100);
            progressDoalog.setMessage("Its loading....");
            progressDoalog.setTitle("ProgressDialog bar example");
            progressDoalog.show();*/

            //PD.getProgressDialog(MainActivity.this);
            pd.getProgressDialog(MainActivity.this);
        }

        @Override
        protected Boolean/*Result*/ doInBackground(Integer... params/*Params*/) {
            Log.i(TAG, "doInBackground: ");
            // worker thread
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            Log.i(TAG, "onPostExecute: ");
            pd.progressDialog.dismiss();
            //progressDoalog.dismiss();
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
            //ui thread
        }

        @Override
        protected void onProgressUpdate(String... values/*Progress*/) {
            super.onProgressUpdate(values);
            Log.i(TAG, "onProgressUpdate: ");
            //ui thread
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
