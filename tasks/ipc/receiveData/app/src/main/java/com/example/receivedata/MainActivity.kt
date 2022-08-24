package com.example.receivedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var receiveData: TextView = findViewById(R.id.receiveData)
        val isActivityLaunchedFromActionSend = intent?.action == Intent.ACTION_SEND
        val isTextData = intent.type?.startsWith("text/*") == true
        if (isActivityLaunchedFromActionSend && isTextData) {
            val sentString = intent.getStringExtra(Intent.EXTRA_TEXT).toString()
            receiveData.text = sentString

        }

    }
}