package com.ash.jonscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class MJobSchedure extends JobService {
    private MjobExecuter mjobExecuter;
    @Override
    public boolean onStartJob(final JobParameters params) {
        Log.i(TAG, "onStartJob: ");
        //place backgound jobs
         mjobExecuter = new MjobExecuter(){
             @Override
             protected void onPostExecute(String s) {
                 Toast.makeText(MJobSchedure.this, "Job Done", Toast.LENGTH_SHORT).show();
                 jobFinished(params,false);
             }
         };
         mjobExecuter.execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "onStopJob: ");
        //if job is iterpted befor finish
        mjobExecuter.cancel(true);
        return false;
    }
}
