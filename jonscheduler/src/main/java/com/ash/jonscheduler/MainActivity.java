package com.ash.jonscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int JOB_ID = 101;
    private static final String TAG = MainActivity.class.getCanonicalName();
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

        //create a job
        ComponentName componentName = new ComponentName(this,MJobSchedure.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID,componentName);
        builder.setPeriodic(1);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setPersisted(true);
        jobInfo = builder.build();

        //schedule a job

        jobScheduler =(JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void stop(View view) {
        Log.i(TAG, "stop: ");
        jobScheduler.cancel(JOB_ID);
        Toast.makeText(this, "job cancel", Toast.LENGTH_SHORT).show();
    }

    public void start(View view) {
        Log.i(TAG, "start: ");
        jobScheduler.schedule(jobInfo);
        Toast.makeText(this, "job Schedule", Toast.LENGTH_SHORT).show();
    }
}