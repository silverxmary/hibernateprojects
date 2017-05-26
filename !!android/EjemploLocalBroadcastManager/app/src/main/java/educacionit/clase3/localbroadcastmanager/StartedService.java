package educacionit.clase3.localbroadcastmanager;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by ignacio on 17/08/15.
 */
public class StartedService extends Service {

    static final String TAG = "Started Service";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.v(TAG, "Servicio creado");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.v(TAG, "Servicio iniciado " + " StartId " + startId);

        new Temporizador().execute(startId);

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Servicio destruido");
    }

    private class Temporizador extends AsyncTask<Integer, Void, Integer> {

        @Override
        protected Integer doInBackground(Integer... params) {


           for(int i = 0 ; i < 60 ; i++){
                try {
                    Thread.sleep(1000L);
                    Log.d(this.getClass().getName(),"counter " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return params[0];
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            stopSelf(integer);
        }
    }
}
