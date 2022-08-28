package com.example.receivemessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    receiveBroadcast receiveObject = new receiveBroadcast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        After android 8 we need to register broadcast receiver during runtime.
//        Below code is to register a broadcast receiver during runtime
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.sendmessage.intent.action.SEND_BROADCAST_MESSAGE");
        registerReceiver(receiveObject,filter);

        TextView receiveView = (TextView) findViewById(R.id.receiveData);
        Intent receiveIntent = getIntent();
        String action = receiveIntent.getAction();
        String type = receiveIntent.getType();

        if(Intent.ACTION_SEND.equals(action) && type != null){
            if(type.equals("text/*")){
                String receiveData = receiveIntent.getStringExtra(Intent.EXTRA_TEXT);
                if(receiveData != null) {
                    receiveView.setText(receiveData.toString());
                }
            }
        }

    }
}