package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var startBtn: Button = findViewById(R.id.startBtn)
        var name: EditText = findViewById(R.id.nameField)
        startBtn.setOnClickListener {
            if(name.text.isEmpty()){
                Toast.makeText(this,"Please Enter Your Name",Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(this,QuizQuestion::class.java)
                intent.putExtra(Constants.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}