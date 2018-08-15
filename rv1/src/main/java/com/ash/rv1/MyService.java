package com.ash.rv1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static final String TAG=MyService.class.getCanonicalName();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        backgound();
        return START_STICKY;

    }

    private void backgound() {
         Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<10;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.i(TAG, "run: "+i);
                }
            }
        });
        thread.start();
    }
}
