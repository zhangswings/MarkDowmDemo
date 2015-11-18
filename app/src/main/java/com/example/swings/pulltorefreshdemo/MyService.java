package com.example.swings.pulltorefreshdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public static String TAG="myservice";


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG," onCreate() ");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
