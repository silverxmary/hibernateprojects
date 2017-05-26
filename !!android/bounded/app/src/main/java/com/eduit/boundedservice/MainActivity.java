package com.eduit.boundedservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BoundedService boundedService;
    private boolean isBinded;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundedService.ServiceBinder binder =  (BoundedService.ServiceBinder) service;
            boundedService = binder.getService();
            isBinded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBinded = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this,BoundedService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isBinded){
            unbindService(serviceConnection);
        }
    }

    public void start(View view){
        boundedService.startProcess();
    }

    public void obatinTime(View view){
        long time = boundedService.obtainTime();
        Toast.makeText(this,"elapsed time" + time,Toast.LENGTH_SHORT).show();
    }


}
