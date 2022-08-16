package com.example.backgroundjava;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    private final String TAG = MyService.class.getSimpleName();
    public static final String CHANNEL_ID = "autoStartServiceChannel";
    public static final String CHANNEL_NAME = "Auto Start Service Channel";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    //    @Override
//    public void onCreate() {
//        Log.i(TAG, "onCreate()");
//        Intent i = new Intent(this, MainActivity.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(i);
//    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.e("Service_background","True");
        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("Example service")
                .setContentText("This is a foreground service")
                .setSmallIcon(R.drawable.ic_baseline_arrow_circle_down_24)
                .build();
        startForeground(1,notification);

//        The Below code is to create a thread and print on to console this works even if we do not use
//        The notification manager and all
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            Log.e("Service_Test", "Service is running...");
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();
        return  START_NOT_STICKY;
//        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
