package educacionit.clase8.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class TiempoTranscurridoAlarmActivity extends AppCompatActivity {

    private CheckBox permitirDesbloquear;
    private Button crearAlarma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo_transcurrido_alarm);

        permitirDesbloquear = (CheckBox) findViewById(R.id.permitir_desbloquear);

        crearAlarma = (Button) findViewById(R.id.crear_alarma);

        crearAlarma.setText("Crear alarma para dentro de 30 segundos");

        crearAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PendingIntent alarmIntent = PendingIntent.getActivity(TiempoTranscurridoAlarmActivity.this,
                        0,
                        new Intent(TiempoTranscurridoAlarmActivity.this, AlarmActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT);
                
                int tipo = AlarmManager.ELAPSED_REALTIME;

                if (permitirDesbloquear.isChecked())
                    tipo = AlarmManager.ELAPSED_REALTIME_WAKEUP;

                AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                manager.set(tipo, SystemClock.elapsedRealtime() + 1000 * 30, alarmIntent);

                onBackPressed();
            }
        });
    }
}
