package com.melayer.jobsecheduer;

import android.os.AsyncTask;


public class MjobExecuter extends AsyncTask<Void,Void,String> {

    @Override
    protected String doInBackground(Void... voids) {
        return "Backgound long running task executed";
    }
}
