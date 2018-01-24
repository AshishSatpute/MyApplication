package com.example.ashish.activitylifecycle;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by ashish on 22/1/18.
 */

public class PD extends Activity {

    ProgressDialog progressDialog;

   public ProgressDialog getProgressDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Message");
        progressDialog.setTitle("Title");
        progressDialog.show();
        return new ProgressDialog(context);
    }
}



