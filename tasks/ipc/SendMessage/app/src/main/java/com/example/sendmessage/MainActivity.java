package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText sendingText = (EditText) findViewById(R.id.sendingData);
        Button sendBtn = (Button) findViewById(R.id.sendButton);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Below code is to send message using intents
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.setType("text/*");
//                sendIntent.putExtra(Intent.EXTRA_TEXT,sendingText.getText().toString());
//                startActivity(Intent.createChooser(sendIntent,"Share using"));

//                Below code is to send message using broadcasts
                Log.e("OnClicked","Button Clicked");
                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction("com.example.sendmessage.intent.action.SEND_BROADCAST_MESSAGE");
                broadcastIntent.putExtra(Intent.EXTRA_TEXT,sendingText.getText().toString());
                broadcastIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                getApplicationContext().sendBroadcast(broadcastIntent);
            }
        });

//        Below code to change the resource value at run time
        Button changeResBtn = (Button) findViewById(R.id.changeResBtn);
        changeResBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}