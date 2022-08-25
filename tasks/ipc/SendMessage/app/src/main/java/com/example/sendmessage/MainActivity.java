package com.example.sendmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
//                Toast.makeText(getApplicationContext(),
//                        "The sendind data is " + sendingText.getText().toString(),
//                        Toast.LENGTH_LONG).show();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/*");
                sendIntent.putExtra(Intent.EXTRA_TEXT,sendingText.getText().toString());
                startActivity(Intent.createChooser(sendIntent,"Share using"));
            }
        });
    }
}