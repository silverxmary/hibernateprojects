package educacionit.clase8.alarmmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmManagerActivity extends AppCompatActivity {

    private Button alarmaTiempoTranscurrido;
    private Button alarmaRTC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_manager);

        alarmaTiempoTranscurrido = (Button) findViewById(R.id.alarma_tiempo_transcurrido);
        alarmaTiempoTranscurrido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlarmManagerActivity.this, TiempoTranscurridoAlarmActivity.class));
            }
        });

        alarmaRTC = (Button) findViewById(R.id.alarma_rtc);
        alarmaRTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlarmManagerActivity.this, RTCAlarmActivity.class));
            }
        });
    }
}
