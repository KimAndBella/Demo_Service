package com.kim.demo_service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button startServiceButton ;
    private Button endServiceButton;
    private Button bindButton;
    private Button unBindButton;
    private MyService.DownloadBinder downloadBinder;
    private ServiceConnection connnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        startServiceButton = (Button) findViewById(R.id.start_service);
//        endServiceButton = (Button) findViewById(R.id.end_service);
//        startServiceButton.setOnClickListener(this);
//        endServiceButton.setOnClickListener(this);
        bindButton = (Button) findViewById(R.id.bind_service);
        unBindButton = (Button) findViewById(R.id.unbind_service);
        bindButton.setOnClickListener(this);
        unBindButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_service:
                Intent startIntent = new Intent(this,MyService.class);
                startService(startIntent);
                break;
            case R.id.end_service:
                Intent endIntent = new Intent(this,MyService.class);
                stopService(endIntent);
                break;
            case R.id.bind_service:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent,connnection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connnection);
                break;
            default:
                break;
        }
    }
}
