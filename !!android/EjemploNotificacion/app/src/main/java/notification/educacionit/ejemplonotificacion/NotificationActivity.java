package notification.educacionit.ejemplonotificacion;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class NotificationActivity extends AppCompatActivity {
    public static final int NOTIFICATION_ID=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById(R.id.showNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(NotificationActivity.this)
                                .setSmallIcon(R.drawable.abc_list_focused_holo)
                                .setContentTitle("Mi notificación")
                                .setContentText("Descripción");

                Intent resultIntent = new Intent(NotificationActivity.this, ShowNotificationActivity.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(NotificationActivity.this);
                stackBuilder.addParentStack(ShowNotificationActivity.class);

                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );
                builder.setContentIntent(resultPendingIntent);
                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(NOTIFICATION_ID, builder.build());
            }
        });
    }
}
