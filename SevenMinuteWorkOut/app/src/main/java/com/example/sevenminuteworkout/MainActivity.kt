package com.example.sevenminuteworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.example.sevenminuteworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.flStart?.setOnClickListener {
            val intent = Intent(this,ExerciseActivity::class.java)
            startActivity(intent)

        }

//        val flStartButton: FrameLayout = findViewById(R.id.flStart)
//        flStartButton.setOnClickListener {
//            Toast.makeText(
//                this,
//                "Button Clicked",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}