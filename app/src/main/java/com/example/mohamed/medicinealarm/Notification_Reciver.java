package com.example.mohamed.medicinealarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.app.NotificationCompat;

import static android.content.Intent.getIntent;


public class Notification_Reciver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String med_name=intent.getStringExtra("med_name");
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repearing_intent=new Intent(context,Repeating_activity.class);
        repearing_intent.putExtra("med_namei",med_name);
        repearing_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(context,100,repearing_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder builder=new Notification.Builder(context).setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.arrow_up_float)
                .setContentText("you have to take you medicine "+med_name+" now")
                .setContentTitle("Medicine Reminder")
                .setAutoCancel(true);
        notificationManager.notify(100,builder.build());


    }
}
