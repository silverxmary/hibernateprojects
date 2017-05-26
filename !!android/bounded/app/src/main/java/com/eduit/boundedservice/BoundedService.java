package com.eduit.boundedservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Marcelo on 16/08/2016.
 */
public class BoundedService extends Service {


    private IBinder binder;
    private long elpasedTime;


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(this.getClass().getSimpleName(),"service created");
        binder = new ServiceBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(this.getClass().getSimpleName(),"service destroyed");
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(this.getClass().getSimpleName(),"service Un bind");
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(this.getClass().getSimpleName(),"service bind");
        return binder;
    }

    public class ServiceBinder extends Binder{

        public BoundedService getService(){
            return BoundedService.this;
        }

    }


    public void startProcess(){
        Log.i(this.getClass().getSimpleName(),"startProcess");
        elpasedTime = System.currentTimeMillis();
    }

    public long obtainTime(){
        Log.i(this.getClass().getSimpleName(),"obstain time");
        return   elpasedTime - System.currentTimeMillis();
    }



}
