package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class Results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvCorrect: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)

        val name: String? = intent.getStringExtra(Constants.USER_NAME)
        val score: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQuestions: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        tvName.text = name
        tvCorrect.text = "Your Score is $score out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}