package educacionit.clase8.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RTCAlarmActivity extends AppCompatActivity {

    private CheckBox permitirDesbloquear;
    private Button crearAlarma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rtcalarm);

        permitirDesbloquear = (CheckBox) findViewById(R.id.permitir_desbloquear);

        crearAlarma = (Button) findViewById(R.id.crear_alarma);

        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 2);

        crearAlarma.setText("Crear alarma para las " + parsearTiempo(calendar.getTime()));

        crearAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PendingIntent alarmIntent = PendingIntent.getActivity(RTCAlarmActivity.this,
                        0,
                        new Intent(RTCAlarmActivity.this, AlarmActivity.class),
                        PendingIntent.FLAG_UPDATE_CURRENT);

                int tipo = AlarmManager.RTC;

                if(permitirDesbloquear.isChecked())
                    tipo = AlarmManager.RTC_WAKEUP;

                AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                manager.set(tipo, calendar.getTimeInMillis(), alarmIntent);

                onBackPressed();
            }
        });
    }

    private String parsearTiempo(Date date){

        String tiempo;

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        tiempo = format.format(date);

        return tiempo;
    }


}
