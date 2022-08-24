package com.example.senddata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sendText: EditText = findViewById(R.id.sendingText)
        var sendBtn: Button = findViewById(R.id.sendButton)
        var sendData: String = sendText.text.toString()

        sendBtn.setOnClickListener {
//            Toast.makeText(this,"${sendText.text}",Toast.LENGTH_SHORT).show()
//            var intent = Intent()
//            intent.action = Intent.ACTION_SEND
//            intent.type = "text/*"
//            intent.putExtra(Intent.EXTRA_TEXT,sendText.text.toString())
//            startActivity(Intent.createChooser(intent,"send to"))

            var shareIntent = Intent().apply {
                this.action = Intent.ACTION_SEND
                this.type = "text/*"
                this.putExtra(Intent.EXTRA_TEXT,sendText.text.toString())
            }
            startActivity(shareIntent)
        }
    }
}