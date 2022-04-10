package com.example.avengersapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.avengersapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        loadData()
    }


    // PRIVATE FUNCTIONS
    private fun loadData () {
        Handler().postDelayed(
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }, 3000
        )
    }

}