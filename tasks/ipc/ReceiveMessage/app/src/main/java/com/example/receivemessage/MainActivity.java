package com.example.receivemessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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