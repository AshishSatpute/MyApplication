package com.example.ashish.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {


     /*BroadcastReceiver by using xml
            it will use when app is not running*/

    @Override
    public void onReceive(Context context, Intent intent) {
    if (intent.getBooleanExtra("state",false)){
        Toast.makeText(context, "Airopane mode on", Toast.LENGTH_SHORT).show();
    }else
    {
        Toast.makeText(context, "Off", Toast.LENGTH_SHORT).show();
    }
    }
}