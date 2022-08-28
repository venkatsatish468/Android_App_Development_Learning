package com.example.receivemessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class receiveBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String receiveData  = intent.getStringExtra(Intent.EXTRA_TEXT).toString();
        Log.e("Receive_Broadcast",receiveData);
        Intent startIntent = new Intent(context.getApplicationContext(),broadcastReceiveMessage.class);
        startIntent.putExtra("Receive_Data",receiveData);
        context.startActivity(startIntent);
    }
}
