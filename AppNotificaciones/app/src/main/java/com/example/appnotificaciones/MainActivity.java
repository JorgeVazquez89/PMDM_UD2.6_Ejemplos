package com.example.appnotificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.btnNotificacion);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creaNotificacion();
            }
        });


    }

    private void creaNotificacion(){

        String canalID = "MiCanal01";
        int notificacionID=0;

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence canalNombre = "Notificacion";
            NotificationChannel miCanal =
                    new NotificationChannel(canalID, canalNombre, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificador.createNotificationChannel(miCanal);
        }

        NotificationCompat.Builder creador = new NotificationCompat.Builder(getApplicationContext(), canalID);
        creador.setSmallIcon(android.R.drawable.stat_sys_warning);
        creador.setContentTitle("Notificacion de Android");
        creador.setContentText("Esto es un ejemplo de notificación");
        creador.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        creador.setColor(Color.RED);
        creador.setDefaults(Notification.DEFAULT_SOUND);

        Intent i = new Intent(MainActivity.this, SegundaActivity.class);

        PendingIntent pI = PendingIntent.getActivity
                (getApplicationContext(),0, i,PendingIntent.FLAG_UPDATE_CURRENT);
        creador.setContentIntent(pI);

        NotificationManagerCompat notification =
                NotificationManagerCompat.from(getApplicationContext());
        notification.notify(notificacionID, creador.build());

}