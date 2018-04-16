package com.melayer.jobsecheduer;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class MJobSchedure extends JobService {
    private MjobExecuter mjobExecuter;
    @Override
    public boolean onStartJob(final JobParameters params) {
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
        //if job is iterpted befor finish
        mjobExecuter.cancel(true);
        return false;
    }
}
