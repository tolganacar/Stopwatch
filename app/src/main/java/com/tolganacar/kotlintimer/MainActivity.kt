package com.tolganacar.kotlintimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.tolganacar.kotlintimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var number = 0
    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun start(view : View){
        number = 0
        binding.buttonStart.isEnabled = false

        runnable = object : Runnable {
            override fun run() {
                number = number+1
                binding.textTime.text = "Time : $number"

                handler.postDelayed(this,1000)
            }
        }

        handler.post(runnable)
    }

    fun stop(view : View){
        handler.removeCallbacks(runnable)
        binding.buttonStart.isEnabled = true
        binding.textTime.text = "Time : 0"
    }
}