package com.kim.demo_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private final String TAG = "My Serivce : ";
    public MyService() {
    }
    private DownloadBinder mBinder = new DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.e(TAG,"start download executed ... ");
        }
        public int getProgress(){
            Log.e(TAG,"getProcess executed ...");
            return 0;
        }
    }
    @Override
    public void onCreate() {
        Log.e(TAG,"onCreate is running ...");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand is running ...");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e(TAG,"onDestroy is running ...");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }
}
