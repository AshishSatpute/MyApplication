package com.ash.rv1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Chronometer;

public class MyService extends Service {

    Chronometer chronometer;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //chronometer.start();
        return START_NOT_STICKY;

    }
}
