package com.example.backgroundjava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class StartOnBoot extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())){
            Log.e("OnBoot","recieved");
            Intent i = new Intent(context,MyService.class);
////            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                context.getApplicationContext().startForegroundService(i);
//                context.startForegroundService(i);
                context.startForegroundService(i);
            }
        }
    }
}
