package com.example.receivemessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class broadcastReceiveMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receive_message);
        Intent receiveIntent = getIntent();
        String message = receiveIntent.getStringExtra("Receive_Data").toString();

        TextView receiveDisplay = (TextView) findViewById(R.id.receiveMessage);
        receiveDisplay.setText(message);
    }
}