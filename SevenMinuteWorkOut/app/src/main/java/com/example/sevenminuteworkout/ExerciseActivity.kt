package com.example.sevenminuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.sevenminuteworkout.databinding.ActivityExerciseBinding

class ExerciseActivity : AppCompatActivity() {
    private var binding: ActivityExerciseBinding? = null

    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbarExercise)
        if(supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.flProgressBarNew?.visibility = View.INVISIBLE
        binding?.toolbarExercise?.setNavigationOnClickListener {
            onBackPressed()
        }

        setupRestView()
    }
    private fun setupRestView(){
        if(restTimer != null){
            restTimer?.cancel()
            restProgress =0
        }
        setRestProgressBar()
    }
    private fun setupRestViewNew(){
        if(restTimer != null){
            restTimer?.cancel()
            restProgress =0
        }
        setRestProgressBarNew()
    }
    private fun setRestProgressBar(){
        binding?.progressBar?.progress = restProgress

        restTimer = object : CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding?.progressBar?.progress = 10-restProgress
                binding?.tvTimer?.text = (10-restProgress).toString()
            }

            override fun onFinish() {
//                Toast.makeText(
//                    this@ExerciseActivity,
//                    "Completed",
//                    Toast.LENGTH_SHORT
//                ).show()
                binding?.flProgressBar?.visibility = View.INVISIBLE
                binding?.flProgressBarNew?.visibility = View.VISIBLE
                setupRestViewNew()
            }

        }.start()
    }

    private fun setRestProgressBarNew(){
        binding?.tvTitle?.text = "Exercise"
        binding?.progressBarNew?.progress = restProgress

        restTimer = object : CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding?.progressBarNew?.progress = 30-restProgress
                binding?.tvTimerNew?.text = (30-restProgress).toString()
            }

            override fun onFinish() {
                Toast.makeText(
                    this@ExerciseActivity,
                    "Completed exercise",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if(restTimer != null){
            restTimer?.cancel()
            restProgress =0
        }
        binding = null
    }
}