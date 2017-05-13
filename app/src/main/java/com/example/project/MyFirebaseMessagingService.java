package com.example.project;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;



/**
 * Created by Musee on 1/11/2017.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public final static String BROADCAST_ACTION_NEW_NOTIFICATION = "com.example.project.NEW_NOTIFICATION";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        sendToActivity(remoteMessage);
    }

    /**
     * Send the notification body to activity
     * @param remoteMessage
     */
    private void sendToActivity(RemoteMessage remoteMessage){
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION_NEW_NOTIFICATION);
        intent.putExtra("notification", remoteMessage.getNotification().getBody());
        getApplicationContext().sendBroadcast(intent);
    }

    /**
     * Show notification on the notification bar
     * @param remoteMessage
     */
    private void showNotification(RemoteMessage remoteMessage){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("PROJECT NOTIFICATION");
        notificationBuilder.setContentText(remoteMessage.getNotification().getBody());
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());
    }
}
