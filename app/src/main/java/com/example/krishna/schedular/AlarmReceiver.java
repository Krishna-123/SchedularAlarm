package com.example.krishna.schedular;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by krishna on 23/1/17.
 */
public class AlarmReceiver extends BroadcastReceiver {
    private static final Object ONGOING_NOTIFICATION_ID = 0;

    @Override

    /*Intent notificationIntent = new Intent(this, .class);
    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
*/

    public void onReceive(final Context context, Intent intent) {

       createNotification(context);

        /* Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtone = RingtoneManager.getRingtone(context, uri);
        ringtone.play();*/
    }

    public void createNotification(Context context){
        PendingIntent notificIntent=PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);

        Notification notification = new Notification.Builder(context)
                .setContentTitle("content Tittle")
                .setContentText("hello its the starting ")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(notificIntent)
                .setTicker("TickerTittle")
                .build();

        //startForeground(ONGOING_NOTIFICATION_ID, notification);

        // noti.flags = Notification.FLAG_AUTO_CANCEL;

        NotificationManager nm = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0, notification);

    }

}