package com.ash.jonscheduler;

import android.os.AsyncTask;
import android.util.Log;

import static android.content.ContentValues.TAG;


public class MjobExecuter extends AsyncTask<Void,Void,String> {

    @Override
    protected String doInBackground(Void... voids) {
        Log.i(TAG, "doInBackground: ");
        return "Backgound long running task executed";
    }
}
